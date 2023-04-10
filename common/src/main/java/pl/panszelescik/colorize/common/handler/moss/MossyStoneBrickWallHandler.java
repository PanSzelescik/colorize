package pl.panszelescik.colorize.common.handler.moss;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyStoneBrickWallHandler extends MossyBlockHandler {

    public MossyStoneBrickWallHandler() {
        super("mossyStoneBrickWall", MOSSY_STONE_BRICK_WALLS);
    }

    private static final Object2ObjectMap<RightClicker, Block> MOSSY_STONE_BRICK_WALLS;

    static {
        var map = new RightClicker2BlockMap(2);

        map.put(Colors.CLEAR, Blocks.STONE_BRICK_WALL);
        map.put(Items.VINE, Blocks.MOSSY_STONE_BRICK_WALL);

        MOSSY_STONE_BRICK_WALLS = map.freeze();
    }
}
