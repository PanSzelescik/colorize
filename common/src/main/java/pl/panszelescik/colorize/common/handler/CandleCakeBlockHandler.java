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
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

import java.util.stream.Stream;

public class CandleCakeBlockHandler extends BaseBlockHandler {

    public CandleCakeBlockHandler() {
        super("candle", CANDLE_CAKES);
    }

    @Override
    protected @NotNull SoundEvent getSound() {
        return SoundEvents.CANDLE_HIT;
    }

    @Override
    public @NotNull Stream<ColorizeRecipe> getRecipes() {
        return Stream.empty(); // Don't duplicate recipes
    }

    private static final Object2ObjectMap<RightClicker, Block> CANDLE_CAKES;

    static {
        var map = new RightClicker2BlockMap(17);

        map.put(Colors.CLEAR, Blocks.CANDLE_CAKE);
        map.putColors(Blocks.DYED_CANDLE_CAKE);

        CANDLE_CAKES = map.freeze();
    }
}
