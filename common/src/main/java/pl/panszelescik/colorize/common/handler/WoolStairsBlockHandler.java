package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.WoollyBlockHandler;

public class WoolStairsBlockHandler extends WoollyBlockHandler {

    public WoolStairsBlockHandler() {
        super("woolStairs", WOOL_STAIRS);
    }

    private static final Object2ObjectMap<RightClicker, Block> WOOL_STAIRS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.putColors(Blocks.WOOL_STAIRS);

        WOOL_STAIRS = map.freeze();
    }
}
