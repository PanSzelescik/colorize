package pl.panszelescik.colorize.common.handler.moss;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.MossyBlockHandler;

public class MossyCobblestoneHandler extends MossyBlockHandler {

    public MossyCobblestoneHandler() {
        super("mossyCobblestone", MOSSY_COBBLESTONES);
    }

    private static final Object2ObjectMap<RightClicker, Block> MOSSY_COBBLESTONES;

    static {
        var map = new RightClicker2BlockMap(2);

        map.put(Colors.CLEAR, Blocks.COBBLESTONE);
        map.put(Items.VINE, Blocks.MOSSY_COBBLESTONE);

        MOSSY_COBBLESTONES = map.freeze();
    }
}
