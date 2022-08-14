package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.MaterialBlockHandler;

public class ConcreteBlockHandler extends MaterialBlockHandler {

    public ConcreteBlockHandler() {
        super(CONCRETES);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, Block> CONCRETES = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, Blocks.WHITE_CONCRETE);
        put(DyeColor.ORANGE, Blocks.ORANGE_CONCRETE);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_CONCRETE);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE);
        put(DyeColor.YELLOW, Blocks.YELLOW_CONCRETE);
        put(DyeColor.LIME, Blocks.LIME_CONCRETE);
        put(DyeColor.PINK, Blocks.PINK_CONCRETE);
        put(DyeColor.GRAY, Blocks.GRAY_CONCRETE);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE);
        put(DyeColor.CYAN, Blocks.CYAN_CONCRETE);
        put(DyeColor.PURPLE, Blocks.PURPLE_CONCRETE);
        put(DyeColor.BLUE, Blocks.BLUE_CONCRETE);
        put(DyeColor.BROWN, Blocks.BROWN_CONCRETE);
        put(DyeColor.GREEN, Blocks.GREEN_CONCRETE);
        put(DyeColor.RED, Blocks.RED_CONCRETE);
        put(DyeColor.BLACK, Blocks.BLACK_CONCRETE);
    }};
}
