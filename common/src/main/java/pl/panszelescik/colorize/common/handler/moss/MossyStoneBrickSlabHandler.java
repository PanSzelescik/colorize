package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class MossyStoneBrickSlabHandler extends BaseBlockHandler {

    public MossyStoneBrickSlabHandler() {
        super("mossyStoneBrickSlab", MOSSY_STONE_BRICK_SLABS);
    }

    private static final RightClicker2BlockMap MOSSY_STONE_BRICK_SLABS = new RightClicker2BlockMap(2);

    static {
        MOSSY_STONE_BRICK_SLABS.put(Colors.CLEAR, Blocks.STONE_BRICK_SLAB);
        MOSSY_STONE_BRICK_SLABS.put(Items.VINE, Blocks.MOSSY_STONE_BRICK_SLAB);
    }
}
