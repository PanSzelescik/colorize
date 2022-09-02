package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyCobblestoneSlabHandler extends MossyBlockHandler {

    public MossyCobblestoneSlabHandler() {
        super("mossyCobblestoneSlab", MOSSY_COBBLESTONE_SLABS);
    }

    private static final RightClicker2BlockMap MOSSY_COBBLESTONE_SLABS = new RightClicker2BlockMap(2);

    static {
        MOSSY_COBBLESTONE_SLABS.put(Colors.CLEAR, Blocks.COBBLESTONE_SLAB);
        MOSSY_COBBLESTONE_SLABS.put(Items.VINE, Blocks.MOSSY_COBBLESTONE_SLAB);
    }
}
