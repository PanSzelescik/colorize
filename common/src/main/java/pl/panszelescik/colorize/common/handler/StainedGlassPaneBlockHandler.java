package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class StainedGlassPaneBlockHandler extends BaseBlockHandler {

    public StainedGlassPaneBlockHandler() {
        super("stainedGlassPane", STAINED_GLASS_PANES);
    }

    private static final RightClicker2BlockMap STAINED_GLASS_PANES = new RightClicker2BlockMap(17);

    static {
        STAINED_GLASS_PANES.put(Colors.CLEAR, Blocks.GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.WHITE, Blocks.WHITE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.ORANGE, Blocks.ORANGE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.MAGENTA, Blocks.MAGENTA_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.YELLOW, Blocks.YELLOW_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.LIME, Blocks.LIME_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.PINK, Blocks.PINK_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.GRAY, Blocks.GRAY_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.CYAN, Blocks.CYAN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.PURPLE, Blocks.PURPLE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.BLUE, Blocks.BLUE_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.BROWN, Blocks.BROWN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.GREEN, Blocks.GREEN_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.RED, Blocks.RED_STAINED_GLASS_PANE);
        STAINED_GLASS_PANES.put(Colors.BLACK, Blocks.BLACK_STAINED_GLASS_PANE);
    }
}
