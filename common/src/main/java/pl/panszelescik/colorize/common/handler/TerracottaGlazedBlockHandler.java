package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class TerracottaGlazedBlockHandler extends MaterialBlockHandler {

    public TerracottaGlazedBlockHandler() {
        super(GlAZED_TERRACOTTAS);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, Block> GlAZED_TERRACOTTAS = new Object2ObjectOpenHashMap<>(16);

    static {
        GlAZED_TERRACOTTAS.put(DyeColor.WHITE, Blocks.WHITE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.ORANGE, Blocks.ORANGE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.MAGENTA, Blocks.MAGENTA_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.YELLOW, Blocks.YELLOW_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.LIME, Blocks.LIME_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.PINK, Blocks.PINK_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.GRAY, Blocks.GRAY_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.CYAN, Blocks.CYAN_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.PURPLE, Blocks.PURPLE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.BLUE, Blocks.BLUE_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.BROWN, Blocks.BROWN_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.GREEN, Blocks.GREEN_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.RED, Blocks.RED_GLAZED_TERRACOTTA);
        GlAZED_TERRACOTTAS.put(DyeColor.BLACK, Blocks.BLACK_GLAZED_TERRACOTTA);
    }
}
