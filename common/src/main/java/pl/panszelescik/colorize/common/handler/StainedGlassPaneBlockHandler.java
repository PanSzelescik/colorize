package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;

public class StainedGlassPaneBlockHandler extends BaseBlockHandler<StainedGlassPaneBlock> {

    @Override
    protected @Nullable StainedGlassPaneBlock getOldBlock(BlockState state) {
        var block = state.getBlock();
        if (block instanceof StainedGlassPaneBlock paneBlock && STAINED_GLASS_PANES.containsValue(paneBlock)) {
            return paneBlock;
        }
        return null;
    }

    @Override
    protected @Nullable DyeColor getOldColor(BlockState state, StainedGlassPaneBlock block) {
        return block.getColor();
    }

    @Override
    protected StainedGlassPaneBlock getNewBlock(DyeColor color) {
        return STAINED_GLASS_PANES.get(color);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, StainedGlassPaneBlock> STAINED_GLASS_PANES = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, (StainedGlassPaneBlock) Blocks.WHITE_STAINED_GLASS_PANE);
        put(DyeColor.ORANGE, (StainedGlassPaneBlock) Blocks.ORANGE_STAINED_GLASS_PANE);
        put(DyeColor.MAGENTA, (StainedGlassPaneBlock) Blocks.MAGENTA_STAINED_GLASS_PANE);
        put(DyeColor.LIGHT_BLUE, (StainedGlassPaneBlock) Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
        put(DyeColor.YELLOW, (StainedGlassPaneBlock) Blocks.YELLOW_STAINED_GLASS_PANE);
        put(DyeColor.LIME, (StainedGlassPaneBlock) Blocks.LIME_STAINED_GLASS_PANE);
        put(DyeColor.PINK, (StainedGlassPaneBlock) Blocks.PINK_STAINED_GLASS_PANE);
        put(DyeColor.GRAY, (StainedGlassPaneBlock) Blocks.GRAY_STAINED_GLASS_PANE);
        put(DyeColor.LIGHT_GRAY, (StainedGlassPaneBlock) Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
        put(DyeColor.CYAN, (StainedGlassPaneBlock) Blocks.CYAN_STAINED_GLASS_PANE);
        put(DyeColor.PURPLE, (StainedGlassPaneBlock) Blocks.PURPLE_STAINED_GLASS_PANE);
        put(DyeColor.BLUE, (StainedGlassPaneBlock) Blocks.BLUE_STAINED_GLASS_PANE);
        put(DyeColor.BROWN, (StainedGlassPaneBlock) Blocks.BROWN_STAINED_GLASS_PANE);
        put(DyeColor.GREEN, (StainedGlassPaneBlock) Blocks.GREEN_STAINED_GLASS_PANE);
        put(DyeColor.RED, (StainedGlassPaneBlock) Blocks.RED_STAINED_GLASS_PANE);
        put(DyeColor.BLACK, (StainedGlassPaneBlock) Blocks.BLACK_STAINED_GLASS_PANE);
    }};
}
