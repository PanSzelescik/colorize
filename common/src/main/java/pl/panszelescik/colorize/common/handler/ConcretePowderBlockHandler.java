package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class ConcretePowderBlockHandler extends BaseBlockHandler {

    public ConcretePowderBlockHandler() {
        super("concretePowder", CONCRETE_POWDERS);
    }

    private static final Object2ObjectMap<RightClicker, Block> CONCRETE_POWDERS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.put(Colors.WHITE, Blocks.WHITE_CONCRETE_POWDER);
        map.put(Colors.ORANGE, Blocks.ORANGE_CONCRETE_POWDER);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_CONCRETE_POWDER);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE_POWDER);
        map.put(Colors.YELLOW, Blocks.YELLOW_CONCRETE_POWDER);
        map.put(Colors.LIME, Blocks.LIME_CONCRETE_POWDER);
        map.put(Colors.PINK, Blocks.PINK_CONCRETE_POWDER);
        map.put(Colors.GRAY, Blocks.GRAY_CONCRETE_POWDER);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE_POWDER);
        map.put(Colors.CYAN, Blocks.CYAN_CONCRETE_POWDER);
        map.put(Colors.PURPLE, Blocks.PURPLE_CONCRETE_POWDER);
        map.put(Colors.BLUE, Blocks.BLUE_CONCRETE_POWDER);
        map.put(Colors.BROWN, Blocks.BROWN_CONCRETE_POWDER);
        map.put(Colors.GREEN, Blocks.GREEN_CONCRETE_POWDER);
        map.put(Colors.RED, Blocks.RED_CONCRETE_POWDER);
        map.put(Colors.BLACK, Blocks.BLACK_CONCRETE_POWDER);

        CONCRETE_POWDERS = map.freeze();
    }
}
