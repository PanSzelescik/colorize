package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class TerracottaBlockHandler extends BaseBlockHandler {

    public TerracottaBlockHandler() {
        super("terracotta", TERRACOTTAS);
    }

    private static final RightClicker2BlockMap TERRACOTTAS = new RightClicker2BlockMap(17);

    static {
        TERRACOTTAS.put(Colors.CLEAR, Blocks.TERRACOTTA);
        TERRACOTTAS.put(Colors.WHITE, Blocks.WHITE_TERRACOTTA);
        TERRACOTTAS.put(Colors.ORANGE, Blocks.ORANGE_TERRACOTTA);
        TERRACOTTAS.put(Colors.MAGENTA, Blocks.MAGENTA_TERRACOTTA);
        TERRACOTTAS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_TERRACOTTA);
        TERRACOTTAS.put(Colors.YELLOW, Blocks.YELLOW_TERRACOTTA);
        TERRACOTTAS.put(Colors.LIME, Blocks.LIME_TERRACOTTA);
        TERRACOTTAS.put(Colors.PINK, Blocks.PINK_TERRACOTTA);
        TERRACOTTAS.put(Colors.GRAY, Blocks.GRAY_TERRACOTTA);
        TERRACOTTAS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_TERRACOTTA);
        TERRACOTTAS.put(Colors.CYAN, Blocks.CYAN_TERRACOTTA);
        TERRACOTTAS.put(Colors.PURPLE, Blocks.PURPLE_TERRACOTTA);
        TERRACOTTAS.put(Colors.BLUE, Blocks.BLUE_TERRACOTTA);
        TERRACOTTAS.put(Colors.BROWN, Blocks.BROWN_TERRACOTTA);
        TERRACOTTAS.put(Colors.GREEN, Blocks.GREEN_TERRACOTTA);
        TERRACOTTAS.put(Colors.RED, Blocks.RED_TERRACOTTA);
        TERRACOTTAS.put(Colors.BLACK, Blocks.BLACK_TERRACOTTA);
    }
}
