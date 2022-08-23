package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class TerracottaBlockHandler extends MaterialBlockHandler {

    public TerracottaBlockHandler() {
        super(TERRACOTTAS);
    }

    private static final Object2ObjectOpenHashMap<Colors, Block> TERRACOTTAS = new Object2ObjectOpenHashMap<>(16);

    static {
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
