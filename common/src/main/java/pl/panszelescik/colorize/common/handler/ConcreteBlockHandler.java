package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class ConcreteBlockHandler extends BaseBlockHandler {

    public ConcreteBlockHandler() {
        super("concrete", CONCRETES);
    }

    private static final Object2ObjectMap<RightClicker, Block> CONCRETES;

    static {
        var map = new RightClicker2BlockMap(16);

        map.putColors(Blocks.CONCRETE);

        CONCRETES = map.freeze();
    }
}
