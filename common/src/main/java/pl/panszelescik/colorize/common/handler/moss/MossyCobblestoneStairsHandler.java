package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class MossyCobblestoneStairsHandler extends BaseBlockHandler {

    public MossyCobblestoneStairsHandler() {
        super("mossyCobblestoneStairs", MOSSY_COBBLESTONE_STAIRS);
    }

    private static final RightClicker2BlockMap MOSSY_COBBLESTONE_STAIRS = new RightClicker2BlockMap(2);

    static {
        MOSSY_COBBLESTONE_STAIRS.put(Colors.CLEAR, Blocks.COBBLESTONE_STAIRS);
        MOSSY_COBBLESTONE_STAIRS.put(Items.VINE, Blocks.MOSSY_COBBLESTONE_STAIRS);
    }
}
