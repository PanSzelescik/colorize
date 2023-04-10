package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.WoollyBlockHandler;

public class CarpetBlockHandler extends WoollyBlockHandler {

    public CarpetBlockHandler() {
        super("carpet", CARPETS);
    }

    private static final Object2ObjectMap<RightClicker, Block> CARPETS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.put(Colors.WHITE, Blocks.WHITE_CARPET);
        map.put(Colors.ORANGE, Blocks.ORANGE_CARPET);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_CARPET);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_CARPET);
        map.put(Colors.YELLOW, Blocks.YELLOW_CARPET);
        map.put(Colors.LIME, Blocks.LIME_CARPET);
        map.put(Colors.PINK, Blocks.PINK_CARPET);
        map.put(Colors.GRAY, Blocks.GRAY_CARPET);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_CARPET);
        map.put(Colors.CYAN, Blocks.CYAN_CARPET);
        map.put(Colors.PURPLE, Blocks.PURPLE_CARPET);
        map.put(Colors.BLUE, Blocks.BLUE_CARPET);
        map.put(Colors.BROWN, Blocks.BROWN_CARPET);
        map.put(Colors.GREEN, Blocks.GREEN_CARPET);
        map.put(Colors.RED, Blocks.RED_CARPET);
        map.put(Colors.BLACK, Blocks.BLACK_CARPET);

        CARPETS = map.freeze();
    }
}
