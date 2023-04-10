package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class TerracottaBlockHandler extends BaseBlockHandler {

    public TerracottaBlockHandler() {
        super("terracotta", TERRACOTTAS);
    }

    private static final Object2ObjectMap<RightClicker, Block> TERRACOTTAS;

    static {
        var map = new RightClicker2BlockMap(17);

        map.put(Colors.CLEAR, Blocks.TERRACOTTA);
        map.put(Colors.WHITE, Blocks.WHITE_TERRACOTTA);
        map.put(Colors.ORANGE, Blocks.ORANGE_TERRACOTTA);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_TERRACOTTA);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_TERRACOTTA);
        map.put(Colors.YELLOW, Blocks.YELLOW_TERRACOTTA);
        map.put(Colors.LIME, Blocks.LIME_TERRACOTTA);
        map.put(Colors.PINK, Blocks.PINK_TERRACOTTA);
        map.put(Colors.GRAY, Blocks.GRAY_TERRACOTTA);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_TERRACOTTA);
        map.put(Colors.CYAN, Blocks.CYAN_TERRACOTTA);
        map.put(Colors.PURPLE, Blocks.PURPLE_TERRACOTTA);
        map.put(Colors.BLUE, Blocks.BLUE_TERRACOTTA);
        map.put(Colors.BROWN, Blocks.BROWN_TERRACOTTA);
        map.put(Colors.GREEN, Blocks.GREEN_TERRACOTTA);
        map.put(Colors.RED, Blocks.RED_TERRACOTTA);
        map.put(Colors.BLACK, Blocks.BLACK_TERRACOTTA);

        TERRACOTTAS = map.freeze();
    }
}
