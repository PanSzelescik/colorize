package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyStoneBricksHandler extends MossyBlockHandler {

    public MossyStoneBricksHandler() {
        super("mossyStoneBricks", MOSSY_STONE_BRICKS);
    }

    private static final RightClicker2BlockMap MOSSY_STONE_BRICKS = new RightClicker2BlockMap(2);

    static {
        MOSSY_STONE_BRICKS.put(Colors.CLEAR, Blocks.STONE_BRICKS);
        MOSSY_STONE_BRICKS.put(Items.VINE, Blocks.MOSSY_STONE_BRICKS);
    }
}
