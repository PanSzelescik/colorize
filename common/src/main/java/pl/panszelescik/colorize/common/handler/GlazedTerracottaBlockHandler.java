package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class GlazedTerracottaBlockHandler extends BaseBlockHandler {

    public GlazedTerracottaBlockHandler() {
        super("glazedTerracotta", GlAZED_TERRACOTTAS);
    }

    private static final Object2ObjectMap<RightClicker, Block> GlAZED_TERRACOTTAS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.put(Colors.WHITE, Blocks.WHITE_GLAZED_TERRACOTTA);
        map.put(Colors.ORANGE, Blocks.ORANGE_GLAZED_TERRACOTTA);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_GLAZED_TERRACOTTA);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        map.put(Colors.YELLOW, Blocks.YELLOW_GLAZED_TERRACOTTA);
        map.put(Colors.LIME, Blocks.LIME_GLAZED_TERRACOTTA);
        map.put(Colors.PINK, Blocks.PINK_GLAZED_TERRACOTTA);
        map.put(Colors.GRAY, Blocks.GRAY_GLAZED_TERRACOTTA);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        map.put(Colors.CYAN, Blocks.CYAN_GLAZED_TERRACOTTA);
        map.put(Colors.PURPLE, Blocks.PURPLE_GLAZED_TERRACOTTA);
        map.put(Colors.BLUE, Blocks.BLUE_GLAZED_TERRACOTTA);
        map.put(Colors.BROWN, Blocks.BROWN_GLAZED_TERRACOTTA);
        map.put(Colors.GREEN, Blocks.GREEN_GLAZED_TERRACOTTA);
        map.put(Colors.RED, Blocks.RED_GLAZED_TERRACOTTA);
        map.put(Colors.BLACK, Blocks.BLACK_GLAZED_TERRACOTTA);

        GlAZED_TERRACOTTAS = map.freeze();
    }
}
