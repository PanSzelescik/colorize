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

    private static final Object2ObjectOpenHashMap<DyeColor, Block> WOOLS = new Object2ObjectOpenHashMap<>(16);

    static {
        WOOLS.put(DyeColor.WHITE, Blocks.WHITE_WOOL);
        WOOLS.put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
        WOOLS.put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
        WOOLS.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        WOOLS.put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
        WOOLS.put(DyeColor.LIME, Blocks.LIME_WOOL);
        WOOLS.put(DyeColor.PINK, Blocks.PINK_WOOL);
        WOOLS.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
        WOOLS.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        WOOLS.put(DyeColor.CYAN, Blocks.CYAN_WOOL);
        WOOLS.put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
        WOOLS.put(DyeColor.BLUE, Blocks.BLUE_WOOL);
        WOOLS.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
        WOOLS.put(DyeColor.GREEN, Blocks.GREEN_WOOL);
        WOOLS.put(DyeColor.RED, Blocks.RED_WOOL);
        WOOLS.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
    }
}
