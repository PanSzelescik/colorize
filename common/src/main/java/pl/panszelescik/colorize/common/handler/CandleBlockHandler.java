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
        map.putColors(Blocks.DYED_CANDLE);

        CANDLES = map.freeze();
    }
}
