package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class TerracottaBlockHandler extends MaterialBlockHandler {

    public TerracottaBlockHandler() {
        super(TERRACOTTAS, TERRACOTTA_COLORS);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, Block> TERRACOTTAS = new Object2ObjectOpenHashMap<>(16);
    private static final Int2ObjectOpenHashMap<DyeColor> TERRACOTTA_COLORS = new Int2ObjectOpenHashMap<>(16);

    static {
        TERRACOTTAS.put(DyeColor.WHITE, Blocks.WHITE_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.ORANGE, Blocks.ORANGE_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.MAGENTA, Blocks.MAGENTA_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.YELLOW, Blocks.YELLOW_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.LIME, Blocks.LIME_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.PINK, Blocks.PINK_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.GRAY, Blocks.GRAY_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.CYAN, Blocks.CYAN_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.PURPLE, Blocks.PURPLE_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.BLUE, Blocks.BLUE_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.BROWN, Blocks.BROWN_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.GREEN, Blocks.GREEN_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.RED, Blocks.RED_TERRACOTTA);
        TERRACOTTAS.put(DyeColor.BLACK, Blocks.BLACK_TERRACOTTA);

        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_WHITE.id, DyeColor.WHITE);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_ORANGE.id, DyeColor.ORANGE);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_MAGENTA.id, DyeColor.MAGENTA);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_LIGHT_BLUE.id, DyeColor.LIGHT_BLUE);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_YELLOW.id, DyeColor.YELLOW);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_LIGHT_GREEN.id, DyeColor.LIME);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_PINK.id, DyeColor.PINK);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_GRAY.id, DyeColor.GRAY);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_LIGHT_GRAY.id, DyeColor.LIGHT_GRAY);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_CYAN.id, DyeColor.CYAN);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_PURPLE.id, DyeColor.PURPLE);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_BLUE.id, DyeColor.BLUE);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_BROWN.id, DyeColor.BROWN);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_GREEN.id, DyeColor.GREEN);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_RED.id, DyeColor.RED);
        TERRACOTTA_COLORS.put(MaterialColor.TERRACOTTA_BLACK.id, DyeColor.BLACK);
    }
}
