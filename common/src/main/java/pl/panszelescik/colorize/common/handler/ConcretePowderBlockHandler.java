package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class ConcretePowderBlockHandler extends MaterialBlockHandler {

    public ConcretePowderBlockHandler() {
        super(CONCRETE_POWDERS);
    }

    private static final Object2ObjectOpenHashMap<Colors, Block> CONCRETE_POWDERS = new Object2ObjectOpenHashMap<>(16);

    static {
        CONCRETE_POWDERS.put(Colors.WHITE, Blocks.WHITE_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.ORANGE, Blocks.ORANGE_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.MAGENTA, Blocks.MAGENTA_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.YELLOW, Blocks.YELLOW_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.LIME, Blocks.LIME_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.PINK, Blocks.PINK_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.GRAY, Blocks.GRAY_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.CYAN, Blocks.CYAN_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.PURPLE, Blocks.PURPLE_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.BLUE, Blocks.BLUE_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.BROWN, Blocks.BROWN_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.GREEN, Blocks.GREEN_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.RED, Blocks.RED_CONCRETE_POWDER);
        CONCRETE_POWDERS.put(Colors.BLACK, Blocks.BLACK_CONCRETE_POWDER);
    }
}
