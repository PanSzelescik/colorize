package pl.panszelescik.colorize.common.handler.moss;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyCobblestoneSlabHandler extends MossyBlockHandler {

    public MossyCobblestoneSlabHandler() {
        super("mossyCobblestoneSlab", MOSSY_COBBLESTONE_SLABS);
    }

    private static final Object2ObjectMap<RightClicker, Block> MOSSY_COBBLESTONE_SLABS;

    static {
        var map = new RightClicker2BlockMap(2);

        map.put(Colors.CLEAR, Blocks.COBBLESTONE_SLAB);
        map.put(Items.VINE, Blocks.MOSSY_COBBLESTONE_SLAB);

        MOSSY_COBBLESTONE_SLABS = map.freeze();
    }
}
