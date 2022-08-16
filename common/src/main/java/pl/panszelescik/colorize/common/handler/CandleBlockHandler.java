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

    private static final Object2ObjectOpenHashMap<DyeColor, Block> CANDLES = new Object2ObjectOpenHashMap<>(16);

    static {
        CANDLES.put(DyeColor.WHITE, Blocks.WHITE_CANDLE);
        CANDLES.put(DyeColor.ORANGE, Blocks.ORANGE_CANDLE);
        CANDLES.put(DyeColor.MAGENTA, Blocks.MAGENTA_CANDLE);
        CANDLES.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CANDLE);
        CANDLES.put(DyeColor.YELLOW, Blocks.YELLOW_CANDLE);
        CANDLES.put(DyeColor.LIME, Blocks.LIME_CANDLE);
        CANDLES.put(DyeColor.PINK, Blocks.PINK_CANDLE);
        CANDLES.put(DyeColor.GRAY, Blocks.GRAY_CANDLE);
        CANDLES.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CANDLE);
        CANDLES.put(DyeColor.CYAN, Blocks.CYAN_CANDLE);
        CANDLES.put(DyeColor.PURPLE, Blocks.PURPLE_CANDLE);
        CANDLES.put(DyeColor.BLUE, Blocks.BLUE_CANDLE);
        CANDLES.put(DyeColor.BROWN, Blocks.BROWN_CANDLE);
        CANDLES.put(DyeColor.GREEN, Blocks.GREEN_CANDLE);
        CANDLES.put(DyeColor.RED, Blocks.RED_CANDLE);
        CANDLES.put(DyeColor.BLACK, Blocks.BLACK_CANDLE);
    }
}
