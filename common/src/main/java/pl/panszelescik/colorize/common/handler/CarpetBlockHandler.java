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

    private static final Object2ObjectOpenHashMap<DyeColor, Block> CARPETS = new Object2ObjectOpenHashMap<>(16);

    static {
        CARPETS.put(DyeColor.WHITE, Blocks.WHITE_CARPET);
        CARPETS.put(DyeColor.ORANGE, Blocks.ORANGE_CARPET);
        CARPETS.put(DyeColor.MAGENTA, Blocks.MAGENTA_CARPET);
        CARPETS.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CARPET);
        CARPETS.put(DyeColor.YELLOW, Blocks.YELLOW_CARPET);
        CARPETS.put(DyeColor.LIME, Blocks.LIME_CARPET);
        CARPETS.put(DyeColor.PINK, Blocks.PINK_CARPET);
        CARPETS.put(DyeColor.GRAY, Blocks.GRAY_CARPET);
        CARPETS.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CARPET);
        CARPETS.put(DyeColor.CYAN, Blocks.CYAN_CARPET);
        CARPETS.put(DyeColor.PURPLE, Blocks.PURPLE_CARPET);
        CARPETS.put(DyeColor.BLUE, Blocks.BLUE_CARPET);
        CARPETS.put(DyeColor.BROWN, Blocks.BROWN_CARPET);
        CARPETS.put(DyeColor.GREEN, Blocks.GREEN_CARPET);
        CARPETS.put(DyeColor.RED, Blocks.RED_CARPET);
        CARPETS.put(DyeColor.BLACK, Blocks.BLACK_CARPET);
    }
}
