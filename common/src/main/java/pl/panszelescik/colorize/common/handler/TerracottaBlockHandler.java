package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class TerracottaBlockHandler extends BaseBlockHandler {

    public TerracottaBlockHandler() {
        super("terracotta", TERRACOTTAS);
    }

    private static final Object2ObjectMap<RightClicker, Block> TERRACOTTAS;

    static {
        var map = new RightClicker2BlockMap(17);

        map.put(Colors.CLEAR, Blocks.TERRACOTTA);
        map.putColors(Blocks.DYED_TERRACOTTA);

        TERRACOTTAS = map.freeze();
    }
}
