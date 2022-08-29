package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class WoolBlockHandler extends MaterialBlockHandler {

    public WoolBlockHandler(ColorizeConfig config) {
        super(config, WOOLS);
    }

    @Override
    protected boolean isEnabled() {
        return this.config.woolHandler();
    }

    @Override
    protected boolean requireSneaking() {
        return this.config.woolSneaking();
    }

    private static final Object2ObjectOpenHashMap<Colors, Block> WOOLS = new Object2ObjectOpenHashMap<>(16);

    static {
        WOOLS.put(Colors.WHITE, Blocks.WHITE_WOOL);
        WOOLS.put(Colors.ORANGE, Blocks.ORANGE_WOOL);
        WOOLS.put(Colors.MAGENTA, Blocks.MAGENTA_WOOL);
        WOOLS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        WOOLS.put(Colors.YELLOW, Blocks.YELLOW_WOOL);
        WOOLS.put(Colors.LIME, Blocks.LIME_WOOL);
        WOOLS.put(Colors.PINK, Blocks.PINK_WOOL);
        WOOLS.put(Colors.GRAY, Blocks.GRAY_WOOL);
        WOOLS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        WOOLS.put(Colors.CYAN, Blocks.CYAN_WOOL);
        WOOLS.put(Colors.PURPLE, Blocks.PURPLE_WOOL);
        WOOLS.put(Colors.BLUE, Blocks.BLUE_WOOL);
        WOOLS.put(Colors.BROWN, Blocks.BROWN_WOOL);
        WOOLS.put(Colors.GREEN, Blocks.GREEN_WOOL);
        WOOLS.put(Colors.RED, Blocks.RED_WOOL);
        WOOLS.put(Colors.BLACK, Blocks.BLACK_WOOL);
    }
}
