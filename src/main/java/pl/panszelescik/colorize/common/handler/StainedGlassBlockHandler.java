package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class StainedGlassBlockHandler extends MaterialBlockHandler {

    public StainedGlassBlockHandler() {
        super(STAINED_GLASSES);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, Block> STAINED_GLASSES = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, Blocks.WHITE_STAINED_GLASS);
        put(DyeColor.ORANGE, Blocks.ORANGE_STAINED_GLASS);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_STAINED_GLASS);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS);
        put(DyeColor.YELLOW, Blocks.YELLOW_STAINED_GLASS);
        put(DyeColor.LIME, Blocks.LIME_STAINED_GLASS);
        put(DyeColor.PINK, Blocks.PINK_STAINED_GLASS);
        put(DyeColor.GRAY, Blocks.GRAY_STAINED_GLASS);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS);
        put(DyeColor.CYAN, Blocks.CYAN_STAINED_GLASS);
        put(DyeColor.PURPLE, Blocks.PURPLE_STAINED_GLASS);
        put(DyeColor.BLUE, Blocks.BLUE_STAINED_GLASS);
        put(DyeColor.BROWN, Blocks.BROWN_STAINED_GLASS);
        put(DyeColor.GREEN, Blocks.GREEN_STAINED_GLASS);
        put(DyeColor.RED, Blocks.RED_STAINED_GLASS);
        put(DyeColor.BLACK, Blocks.BLACK_STAINED_GLASS);
    }};
}
