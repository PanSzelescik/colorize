package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class CandleBlockHandler extends MaterialBlockHandler {

    public CandleBlockHandler() {
        super(CANDLES);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, Block> CANDLES = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, Blocks.WHITE_CANDLE);
        put(DyeColor.ORANGE, Blocks.ORANGE_CANDLE);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_CANDLE);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CANDLE);
        put(DyeColor.YELLOW, Blocks.YELLOW_CANDLE);
        put(DyeColor.LIME, Blocks.LIME_CANDLE);
        put(DyeColor.PINK, Blocks.PINK_CANDLE);
        put(DyeColor.GRAY, Blocks.GRAY_CANDLE);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CANDLE);
        put(DyeColor.CYAN, Blocks.CYAN_CANDLE);
        put(DyeColor.PURPLE, Blocks.PURPLE_CANDLE);
        put(DyeColor.BLUE, Blocks.BLUE_CANDLE);
        put(DyeColor.BROWN, Blocks.BROWN_CANDLE);
        put(DyeColor.GREEN, Blocks.GREEN_CANDLE);
        put(DyeColor.RED, Blocks.RED_CANDLE);
        put(DyeColor.BLACK, Blocks.BLACK_CANDLE);
    }};
}
