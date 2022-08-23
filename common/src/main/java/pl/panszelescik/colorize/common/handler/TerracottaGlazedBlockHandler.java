package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class TerracottaGlazedBlockHandler extends MaterialBlockHandler {

    public TerracottaGlazedBlockHandler() {
        super(GlAZED_TERRACOTTAS);
    }

    private static final Object2ObjectOpenHashMap<Colors, Block> GlAZED_TERRACOTTAS = new Object2ObjectOpenHashMap<>(16);

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
