package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.Colors;

public class StainedGlassPaneBlockHandler extends BaseBlockHandler<Block> {

    public StainedGlassPaneBlockHandler(ColorizeConfig config) {
        super(config);
    }

    @Override
    protected @Nullable Block getOldBlock(BlockState state) {
        var block = state.getBlock();
        return STAINED_GLASS_PANES.containsValue(block) ? block : null;
    }

    @Override
    protected @Nullable Colors getOldColor(BlockState state, Block block) {
        if (block == Blocks.GLASS_PANE) {
            return Colors.CLEAR;
        }
        return block instanceof StainedGlassPaneBlock paneBlock ? Colors.getByDyeColor(paneBlock.getColor()) : null;
    }

    @Override
    protected Block getNewBlock(Colors color) {
        return STAINED_GLASS_PANES.get(color);
    }

    @Override
    protected boolean isEnabled() {
        return this.config.stainedGlassPaneHandler();
    }

    @Override
    protected boolean requireSneaking() {
        return this.config.stainedGlassPaneSneaking();
    }

    private static final Object2ObjectOpenHashMap<Colors, Block> STAINED_GLASS_PANES = new Object2ObjectOpenHashMap<>(16);

    static {
        STAINED_GLASS_PANES.put(Colors.CLEAR, Blocks.GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.WHITE, Blocks.WHITE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.ORANGE, Blocks.ORANGE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.MAGENTA, Blocks.MAGENTA_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.YELLOW, Blocks.YELLOW_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.LIME, Blocks.LIME_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.PINK, Blocks.PINK_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.GRAY, Blocks.GRAY_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.CYAN, Blocks.CYAN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.PURPLE, Blocks.PURPLE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.BLUE, Blocks.BLUE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.BROWN, Blocks.BROWN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.GREEN, Blocks.GREEN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.RED, Blocks.RED_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.BLACK, Blocks.BLACK_STAINED_GLASS_PANE);
    }
}
