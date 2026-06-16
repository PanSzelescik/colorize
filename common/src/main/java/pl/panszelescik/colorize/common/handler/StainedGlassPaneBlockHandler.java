package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.GlassBlockHandler;

public class StainedGlassPaneBlockHandler extends GlassBlockHandler {

    public StainedGlassPaneBlockHandler() {
        super("stainedGlassPane", STAINED_GLASS_PANES);
    }

    private static final Object2ObjectMap<RightClicker, Block> STAINED_GLASS_PANES;

    static {
        var map = new RightClicker2BlockMap(17);

        map.put(Colors.CLEAR, Blocks.GLASS_PANE);
        map.putColors(Blocks.STAINED_GLASS_PANE);

        STAINED_GLASS_PANES = map.freeze();
    }
}
