package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class WoolBlockHandler extends MaterialBlockHandler {

    public WoolBlockHandler() {
        super(WOOLS);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, Block> WOOLS = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, Blocks.WHITE_WOOL);
        put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
        put(DyeColor.LIME, Blocks.LIME_WOOL);
        put(DyeColor.PINK, Blocks.PINK_WOOL);
        put(DyeColor.GRAY, Blocks.GRAY_WOOL);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        put(DyeColor.CYAN, Blocks.CYAN_WOOL);
        put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
        put(DyeColor.BLUE, Blocks.BLUE_WOOL);
        put(DyeColor.BROWN, Blocks.BROWN_WOOL);
        put(DyeColor.GREEN, Blocks.GREEN_WOOL);
        put(DyeColor.RED, Blocks.RED_WOOL);
        put(DyeColor.BLACK, Blocks.BLACK_WOOL);
    }};
}
