package pl.panszelescik.colorize.common.handler;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

import java.util.stream.Stream;

public class CandleCakeBlockHandler extends BaseBlockHandler {

    public CandleCakeBlockHandler() {
        super("candle", CANDLE_CAKES);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundEvents.CANDLE_HIT;
    }

    @Override
    public Stream<ColorizeRecipe> getRecipes() {
        return Stream.empty(); // Don't duplicate recipes
    }

    private static final RightClicker2BlockMap CANDLE_CAKES = new RightClicker2BlockMap(17);

    static {
        CANDLE_CAKES.put(Colors.CLEAR, Blocks.CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.WHITE, Blocks.WHITE_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.ORANGE, Blocks.ORANGE_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.MAGENTA, Blocks.MAGENTA_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.YELLOW, Blocks.YELLOW_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.LIME, Blocks.LIME_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.PINK, Blocks.PINK_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.GRAY, Blocks.GRAY_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.CYAN, Blocks.CYAN_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.PURPLE, Blocks.PURPLE_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.BLUE, Blocks.BLUE_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.BROWN, Blocks.BROWN_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.GREEN, Blocks.GREEN_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.RED, Blocks.RED_CANDLE_CAKE);
        CANDLE_CAKES.put(Colors.BLACK, Blocks.BLACK_CANDLE_CAKE);
    }
}
