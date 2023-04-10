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
        map.put(Colors.WHITE, Blocks.WHITE_STAINED_GLASS_PANE);
        map.put(Colors.ORANGE, Blocks.ORANGE_STAINED_GLASS_PANE);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_STAINED_GLASS_PANE);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
        map.put(Colors.YELLOW, Blocks.YELLOW_STAINED_GLASS_PANE);
        map.put(Colors.LIME, Blocks.LIME_STAINED_GLASS_PANE);
        map.put(Colors.PINK, Blocks.PINK_STAINED_GLASS_PANE);
        map.put(Colors.GRAY, Blocks.GRAY_STAINED_GLASS_PANE);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
        map.put(Colors.CYAN, Blocks.CYAN_STAINED_GLASS_PANE);
        map.put(Colors.PURPLE, Blocks.PURPLE_STAINED_GLASS_PANE);
        map.put(Colors.BLUE, Blocks.BLUE_STAINED_GLASS_PANE);
        map.put(Colors.BROWN, Blocks.BROWN_STAINED_GLASS_PANE);
        map.put(Colors.GREEN, Blocks.GREEN_STAINED_GLASS_PANE);
        map.put(Colors.RED, Blocks.RED_STAINED_GLASS_PANE);
        map.put(Colors.BLACK, Blocks.BLACK_STAINED_GLASS_PANE);

        STAINED_GLASS_PANES = map.freeze();
    }
}
