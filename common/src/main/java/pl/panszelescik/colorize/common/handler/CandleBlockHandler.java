package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class CandleBlockHandler extends MaterialBlockHandler {

    public CandleBlockHandler(ColorizeConfig config) {
        super(config, CANDLES);
    }

    @Override
    protected boolean isEnabled() {
        return this.config.candleHandler();
    }

    @Override
    protected boolean requireSneaking() {
        return this.config.candleSneaking();
    }

    private static final Object2ObjectOpenHashMap<Colors, Block> CANDLES = new Object2ObjectOpenHashMap<>(16);

    static {
        CANDLES.put(Colors.WHITE, Blocks.WHITE_CANDLE);
        CANDLES.put(Colors.ORANGE, Blocks.ORANGE_CANDLE);
        CANDLES.put(Colors.MAGENTA, Blocks.MAGENTA_CANDLE);
        CANDLES.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CANDLE);
        CANDLES.put(Colors.YELLOW, Blocks.YELLOW_CANDLE);
        CANDLES.put(Colors.LIME, Blocks.LIME_CANDLE);
        CANDLES.put(Colors.PINK, Blocks.PINK_CANDLE);
        CANDLES.put(Colors.GRAY, Blocks.GRAY_CANDLE);
        CANDLES.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CANDLE);
        CANDLES.put(Colors.CYAN, Blocks.CYAN_CANDLE);
        CANDLES.put(Colors.PURPLE, Blocks.PURPLE_CANDLE);
        CANDLES.put(Colors.BLUE, Blocks.BLUE_CANDLE);
        CANDLES.put(Colors.BROWN, Blocks.BROWN_CANDLE);
        CANDLES.put(Colors.GREEN, Blocks.GREEN_CANDLE);
        CANDLES.put(Colors.RED, Blocks.RED_CANDLE);
        CANDLES.put(Colors.BLACK, Blocks.BLACK_CANDLE);
    }
}
