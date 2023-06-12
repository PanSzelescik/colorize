package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class CandleBlockHandler extends BaseBlockHandler {

    public CandleBlockHandler() {
        super("candle", CANDLES);
    }

    @Override
    protected @NotNull SoundEvent getSound() {
        return SoundEvents.CANDLE_HIT;
    }

    private static final Object2ObjectMap<RightClicker, Block> CANDLES;

    static {
        var map = new RightClicker2BlockMap(17);

        map.put(Colors.CLEAR, Blocks.CANDLE);
        map.put(Colors.WHITE, Blocks.WHITE_CANDLE);
        map.put(Colors.ORANGE, Blocks.ORANGE_CANDLE);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_CANDLE);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CANDLE);
        map.put(Colors.YELLOW, Blocks.YELLOW_CANDLE);
        map.put(Colors.LIME, Blocks.LIME_CANDLE);
        map.put(Colors.PINK, Blocks.PINK_CANDLE);
        map.put(Colors.GRAY, Blocks.GRAY_CANDLE);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CANDLE);
        map.put(Colors.CYAN, Blocks.CYAN_CANDLE);
        map.put(Colors.PURPLE, Blocks.PURPLE_CANDLE);
        map.put(Colors.BLUE, Blocks.BLUE_CANDLE);
        map.put(Colors.BROWN, Blocks.BROWN_CANDLE);
        map.put(Colors.GREEN, Blocks.GREEN_CANDLE);
        map.put(Colors.RED, Blocks.RED_CANDLE);
        map.put(Colors.BLACK, Blocks.BLACK_CANDLE);

        CANDLES = map.freeze();
    }
}
