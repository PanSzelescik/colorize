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

        map.putColors(Blocks.CARPET);

        CARPETS = map.freeze();
    }
}
