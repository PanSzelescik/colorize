package pl.panszelescik.colorize.common.handler;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class CandleBlockHandler extends BaseBlockHandler {

    public CandleBlockHandler() {
        super("candle", CANDLES);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundEvents.CANDLE_HIT;
    }

    private static final RightClicker2BlockMap CANDLES = new RightClicker2BlockMap(16);

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
