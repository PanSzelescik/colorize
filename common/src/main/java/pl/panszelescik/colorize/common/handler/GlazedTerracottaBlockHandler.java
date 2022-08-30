package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class GlazedTerracottaBlockHandler extends BaseBlockHandler {

    public GlazedTerracottaBlockHandler() {
        super("glazedTerracotta", GlAZED_TERRACOTTAS);
    }

    private static final RightClicker2BlockMap GlAZED_TERRACOTTAS = new RightClicker2BlockMap(16);

    static {
        GlAZED_TERRACOTTAS.put(Colors.WHITE, Blocks.WHITE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.ORANGE, Blocks.ORANGE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.MAGENTA, Blocks.MAGENTA_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.YELLOW, Blocks.YELLOW_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.LIME, Blocks.LIME_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.PINK, Blocks.PINK_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.GRAY, Blocks.GRAY_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.CYAN, Blocks.CYAN_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.PURPLE, Blocks.PURPLE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.BLUE, Blocks.BLUE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.BROWN, Blocks.BROWN_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.GREEN, Blocks.GREEN_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.RED, Blocks.RED_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(Colors.BLACK, Blocks.BLACK_GLAZED_TERRACOTTA);
    }
}
