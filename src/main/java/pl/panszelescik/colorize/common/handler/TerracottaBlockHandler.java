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

    private static final Object2ObjectOpenHashMap<DyeColor, Block> TERRACOTTAS = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, Blocks.WHITE_TERRACOTTA);
        put(DyeColor.ORANGE, Blocks.ORANGE_TERRACOTTA);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_TERRACOTTA);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_TERRACOTTA);
        put(DyeColor.YELLOW, Blocks.YELLOW_TERRACOTTA);
        put(DyeColor.LIME, Blocks.LIME_TERRACOTTA);
        put(DyeColor.PINK, Blocks.PINK_TERRACOTTA);
        put(DyeColor.GRAY, Blocks.GRAY_TERRACOTTA);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_TERRACOTTA);
        put(DyeColor.CYAN, Blocks.CYAN_TERRACOTTA);
        put(DyeColor.PURPLE, Blocks.PURPLE_TERRACOTTA);
        put(DyeColor.BLUE, Blocks.BLUE_TERRACOTTA);
        put(DyeColor.BROWN, Blocks.BROWN_TERRACOTTA);
        put(DyeColor.GREEN, Blocks.GREEN_TERRACOTTA);
        put(DyeColor.RED, Blocks.RED_TERRACOTTA);
        put(DyeColor.BLACK, Blocks.BLACK_TERRACOTTA);
    }};

    private static final Int2ObjectOpenHashMap<DyeColor> TERRACOTTA_COLORS = new Int2ObjectOpenHashMap<>(16) {{
        put(MaterialColor.TERRACOTTA_WHITE.id, DyeColor.WHITE);
        put(MaterialColor.TERRACOTTA_ORANGE.id, DyeColor.ORANGE);
        put(MaterialColor.TERRACOTTA_MAGENTA.id, DyeColor.MAGENTA);
        put(MaterialColor.TERRACOTTA_LIGHT_BLUE.id, DyeColor.LIGHT_BLUE);
        put(MaterialColor.TERRACOTTA_YELLOW.id, DyeColor.YELLOW);
        put(MaterialColor.TERRACOTTA_LIGHT_GREEN.id, DyeColor.LIME);
        put(MaterialColor.TERRACOTTA_PINK.id, DyeColor.PINK);
        put(MaterialColor.TERRACOTTA_GRAY.id, DyeColor.GRAY);
        put(MaterialColor.TERRACOTTA_LIGHT_GRAY.id, DyeColor.LIGHT_GRAY);
        put(MaterialColor.TERRACOTTA_CYAN.id, DyeColor.CYAN);
        put(MaterialColor.TERRACOTTA_PURPLE.id, DyeColor.PURPLE);
        put(MaterialColor.TERRACOTTA_BLUE.id, DyeColor.BLUE);
        put(MaterialColor.TERRACOTTA_BROWN.id, DyeColor.BROWN);
        put(MaterialColor.TERRACOTTA_GREEN.id, DyeColor.GREEN);
        put(MaterialColor.TERRACOTTA_RED.id, DyeColor.RED);
        put(MaterialColor.TERRACOTTA_BLACK.id, DyeColor.BLACK);
    }};
}
