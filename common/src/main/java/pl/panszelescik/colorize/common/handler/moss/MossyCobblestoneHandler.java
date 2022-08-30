package pl.panszelescik.colorize.common.handler.moss;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class MossyCobblestoneHandler extends BaseBlockHandler {

    public MossyCobblestoneHandler() {
        super("mossyCobblestone", MOSSY_COBBLESTONES);
    }

    private static final RightClicker2BlockMap MOSSY_COBBLESTONES = new RightClicker2BlockMap(2);

    static {
        MOSSY_COBBLESTONES.put(Colors.CLEAR, Blocks.COBBLESTONE);
        MOSSY_COBBLESTONES.put(Items.VINE, Blocks.MOSSY_COBBLESTONE);
    }
}
