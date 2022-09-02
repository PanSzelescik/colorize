package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyCobblestoneWallHandler extends MossyBlockHandler {

    public MossyCobblestoneWallHandler() {
        super("mossyCobblestoneWall", MOSSY_COBBLESTONE_WALLS);
    }

    private static final RightClicker2BlockMap MOSSY_COBBLESTONE_WALLS = new RightClicker2BlockMap(2);

    static {
        MOSSY_COBBLESTONE_WALLS.put(Colors.CLEAR, Blocks.COBBLESTONE_WALL);
        MOSSY_COBBLESTONE_WALLS.put(Items.VINE, Blocks.MOSSY_COBBLESTONE_WALL);
    }
}
