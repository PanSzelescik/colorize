package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyStoneBrickWallHandler extends MossyBlockHandler {

    public MossyStoneBrickWallHandler() {
        super("mossyStoneBrickWall", MOSSY_STONE_BRICK_WALLS);
    }

    private static final RightClicker2BlockMap MOSSY_STONE_BRICK_WALLS = new RightClicker2BlockMap(2);

    static {
        MOSSY_STONE_BRICK_WALLS.put(Colors.CLEAR, Blocks.STONE_BRICK_WALL);
        MOSSY_STONE_BRICK_WALLS.put(Items.VINE, Blocks.MOSSY_STONE_BRICK_WALL);
    }
}
