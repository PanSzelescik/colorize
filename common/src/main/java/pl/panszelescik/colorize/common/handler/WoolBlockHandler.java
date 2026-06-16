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

        map.putColors(Blocks.WOOL);

        WOOLS = map.freeze();
    }
}
