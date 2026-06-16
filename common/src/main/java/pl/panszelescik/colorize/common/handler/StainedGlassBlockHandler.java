package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.GlassBlockHandler;

public class StainedGlassBlockHandler extends GlassBlockHandler {

    public StainedGlassBlockHandler() {
        super("stainedGlass", STAINED_GLASSES);
    }

    private static final Object2ObjectMap<RightClicker, Block> STAINED_GLASSES;

    static {
        var map = new RightClicker2BlockMap(18);

        map.put(Colors.CLEAR, Blocks.GLASS);
        map.putColors(Blocks.STAINED_GLASS);
        map.put(Items.AMETHYST_SHARD, Blocks.TINTED_GLASS);

        STAINED_GLASSES = map.freeze();
    }
}
