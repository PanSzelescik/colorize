package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
    protected SoundEvent getSound() {
        return SoundEvents.CANDLE_HIT;
    }

    @Override
    public Stream<ColorizeRecipe> getRecipes() {
        return Stream.empty(); // Don't duplicate recipes
    }

    private static final Object2ObjectMap<RightClicker, Block> CANDLE_CAKES;

    static {
        var map = new RightClicker2BlockMap(17);

        map.put(Colors.CLEAR, Blocks.CANDLE_CAKE);
        map.put(Colors.WHITE, Blocks.WHITE_CANDLE_CAKE);
        map.put(Colors.ORANGE, Blocks.ORANGE_CANDLE_CAKE);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_CANDLE_CAKE);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CANDLE_CAKE);
        map.put(Colors.YELLOW, Blocks.YELLOW_CANDLE_CAKE);
        map.put(Colors.LIME, Blocks.LIME_CANDLE_CAKE);
        map.put(Colors.PINK, Blocks.PINK_CANDLE_CAKE);
        map.put(Colors.GRAY, Blocks.GRAY_CANDLE_CAKE);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CANDLE_CAKE);
        map.put(Colors.CYAN, Blocks.CYAN_CANDLE_CAKE);
        map.put(Colors.PURPLE, Blocks.PURPLE_CANDLE_CAKE);
        map.put(Colors.BLUE, Blocks.BLUE_CANDLE_CAKE);
        map.put(Colors.BROWN, Blocks.BROWN_CANDLE_CAKE);
        map.put(Colors.GREEN, Blocks.GREEN_CANDLE_CAKE);
        map.put(Colors.RED, Blocks.RED_CANDLE_CAKE);
        map.put(Colors.BLACK, Blocks.BLACK_CANDLE_CAKE);

        CANDLE_CAKES = map.freeze();
    }
}
