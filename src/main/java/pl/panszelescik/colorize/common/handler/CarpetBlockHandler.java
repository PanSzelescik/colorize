package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class CarpetBlockHandler extends MaterialBlockHandler {

    public CarpetBlockHandler() {
        super(CARPETS);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, Block> CARPETS = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, Blocks.WHITE_CARPET);
        put(DyeColor.ORANGE, Blocks.ORANGE_CARPET);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_CARPET);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CARPET);
        put(DyeColor.YELLOW, Blocks.YELLOW_CARPET);
        put(DyeColor.LIME, Blocks.LIME_CARPET);
        put(DyeColor.PINK, Blocks.PINK_CARPET);
        put(DyeColor.GRAY, Blocks.GRAY_CARPET);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CARPET);
        put(DyeColor.CYAN, Blocks.CYAN_CARPET);
        put(DyeColor.PURPLE, Blocks.PURPLE_CARPET);
        put(DyeColor.BLUE, Blocks.BLUE_CARPET);
        put(DyeColor.BROWN, Blocks.BROWN_CARPET);
        put(DyeColor.GREEN, Blocks.GREEN_CARPET);
        put(DyeColor.RED, Blocks.RED_CARPET);
        put(DyeColor.BLACK, Blocks.BLACK_CARPET);
    }};
}
