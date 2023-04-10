package pl.panszelescik.colorize.common.handler.moss;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyStoneBricksHandler extends MossyBlockHandler {

    public MossyStoneBricksHandler() {
        super("mossyStoneBricks", MOSSY_STONE_BRICKS);
    }

    private static final Object2ObjectMap<RightClicker, Block> MOSSY_STONE_BRICKS;

    static {
        var map = new RightClicker2BlockMap(2);

        map.put(Colors.CLEAR, Blocks.STONE_BRICKS);
        map.put(Items.VINE, Blocks.MOSSY_STONE_BRICKS);

        MOSSY_STONE_BRICKS = map.freeze();
    }
}
