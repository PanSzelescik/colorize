package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class ConcreteBlockHandler extends BaseBlockHandler {

    public ConcreteBlockHandler() {
        super("concrete", CONCRETES);
    }

    private static final Object2ObjectMap<RightClicker, Block> CONCRETES;

    static {
        var map = new RightClicker2BlockMap(16);

        map.put(Colors.WHITE, Blocks.WHITE_CONCRETE);
        map.put(Colors.ORANGE, Blocks.ORANGE_CONCRETE);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_CONCRETE);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE);
        map.put(Colors.YELLOW, Blocks.YELLOW_CONCRETE);
        map.put(Colors.LIME, Blocks.LIME_CONCRETE);
        map.put(Colors.PINK, Blocks.PINK_CONCRETE);
        map.put(Colors.GRAY, Blocks.GRAY_CONCRETE);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE);
        map.put(Colors.CYAN, Blocks.CYAN_CONCRETE);
        map.put(Colors.PURPLE, Blocks.PURPLE_CONCRETE);
        map.put(Colors.BLUE, Blocks.BLUE_CONCRETE);
        map.put(Colors.BROWN, Blocks.BROWN_CONCRETE);
        map.put(Colors.GREEN, Blocks.GREEN_CONCRETE);
        map.put(Colors.RED, Blocks.RED_CONCRETE);
        map.put(Colors.BLACK, Blocks.BLACK_CONCRETE);

        CONCRETES = map.freeze();
    }
}
