package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyStoneBrickStairsHandler extends MossyBlockHandler {

    public MossyStoneBrickStairsHandler() {
        super("mossyStoneBrickStairs", MOSSY_STONE_BRICK_STAIRS);
    }

    private static final RightClicker2BlockMap MOSSY_STONE_BRICK_STAIRS = new RightClicker2BlockMap(2);

    static {
        MOSSY_STONE_BRICK_STAIRS.put(Colors.CLEAR, Blocks.STONE_BRICK_STAIRS);
        MOSSY_STONE_BRICK_STAIRS.put(Items.VINE, Blocks.MOSSY_STONE_BRICK_STAIRS);
    }
}
