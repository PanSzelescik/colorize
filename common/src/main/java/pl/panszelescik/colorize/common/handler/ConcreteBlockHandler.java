package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class ConcreteBlockHandler extends BaseBlockHandler {

    public ConcreteBlockHandler() {
        super("concrete", CONCRETES);
    }

    private static final RightClicker2BlockMap CONCRETES = new RightClicker2BlockMap(16);

    static {
        CONCRETES.put(Colors.WHITE, Blocks.WHITE_CONCRETE);
        CONCRETES.put(Colors.ORANGE, Blocks.ORANGE_CONCRETE);
        CONCRETES.put(Colors.MAGENTA, Blocks.MAGENTA_CONCRETE);
        CONCRETES.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE);
        CONCRETES.put(Colors.YELLOW, Blocks.YELLOW_CONCRETE);
        CONCRETES.put(Colors.LIME, Blocks.LIME_CONCRETE);
        CONCRETES.put(Colors.PINK, Blocks.PINK_CONCRETE);
        CONCRETES.put(Colors.GRAY, Blocks.GRAY_CONCRETE);
        CONCRETES.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE);
        CONCRETES.put(Colors.CYAN, Blocks.CYAN_CONCRETE);
        CONCRETES.put(Colors.PURPLE, Blocks.PURPLE_CONCRETE);
        CONCRETES.put(Colors.BLUE, Blocks.BLUE_CONCRETE);
        CONCRETES.put(Colors.BROWN, Blocks.BROWN_CONCRETE);
        CONCRETES.put(Colors.GREEN, Blocks.GREEN_CONCRETE);
        CONCRETES.put(Colors.RED, Blocks.RED_CONCRETE);
        CONCRETES.put(Colors.BLACK, Blocks.BLACK_CONCRETE);
    }
}
