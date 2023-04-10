package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.WoollyBlockHandler;

public class WoolBlockHandler extends WoollyBlockHandler {

    public WoolBlockHandler() {
        super("wool", WOOLS);
    }

    private static final Object2ObjectMap<RightClicker, Block> WOOLS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.put(Colors.WHITE, Blocks.WHITE_WOOL);
        map.put(Colors.ORANGE, Blocks.ORANGE_WOOL);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_WOOL);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        map.put(Colors.YELLOW, Blocks.YELLOW_WOOL);
        map.put(Colors.LIME, Blocks.LIME_WOOL);
        map.put(Colors.PINK, Blocks.PINK_WOOL);
        map.put(Colors.GRAY, Blocks.GRAY_WOOL);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        map.put(Colors.CYAN, Blocks.CYAN_WOOL);
        map.put(Colors.PURPLE, Blocks.PURPLE_WOOL);
        map.put(Colors.BLUE, Blocks.BLUE_WOOL);
        map.put(Colors.BROWN, Blocks.BROWN_WOOL);
        map.put(Colors.GREEN, Blocks.GREEN_WOOL);
        map.put(Colors.RED, Blocks.RED_WOOL);
        map.put(Colors.BLACK, Blocks.BLACK_WOOL);

        WOOLS = map.freeze();
    }
}
