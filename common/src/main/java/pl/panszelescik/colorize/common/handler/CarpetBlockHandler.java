package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.WoollyBlockHandler;

public class CarpetBlockHandler extends WoollyBlockHandler {

    public CarpetBlockHandler() {
        super("carpet", CARPETS);
    }

    private static final RightClicker2BlockMap CARPETS = new RightClicker2BlockMap(16);

    static {
        CARPETS.put(Colors.WHITE, Blocks.WHITE_CARPET);
        CARPETS.put(Colors.ORANGE, Blocks.ORANGE_CARPET);
        CARPETS.put(Colors.MAGENTA, Blocks.MAGENTA_CARPET);
        CARPETS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CARPET);
        CARPETS.put(Colors.YELLOW, Blocks.YELLOW_CARPET);
        CARPETS.put(Colors.LIME, Blocks.LIME_CARPET);
        CARPETS.put(Colors.PINK, Blocks.PINK_CARPET);
        CARPETS.put(Colors.GRAY, Blocks.GRAY_CARPET);
        CARPETS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CARPET);
        CARPETS.put(Colors.CYAN, Blocks.CYAN_CARPET);
        CARPETS.put(Colors.PURPLE, Blocks.PURPLE_CARPET);
        CARPETS.put(Colors.BLUE, Blocks.BLUE_CARPET);
        CARPETS.put(Colors.BROWN, Blocks.BROWN_CARPET);
        CARPETS.put(Colors.GREEN, Blocks.GREEN_CARPET);
        CARPETS.put(Colors.RED, Blocks.RED_CARPET);
        CARPETS.put(Colors.BLACK, Blocks.BLACK_CARPET);
    }
}
