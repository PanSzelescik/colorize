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

    private static final Object2ObjectOpenHashMap<DyeColor, Block> CONCRETES = new Object2ObjectOpenHashMap<>(16);

    static {
        CONCRETES.put(DyeColor.WHITE, Blocks.WHITE_CONCRETE);
        CONCRETES.put(DyeColor.ORANGE, Blocks.ORANGE_CONCRETE);
        CONCRETES.put(DyeColor.MAGENTA, Blocks.MAGENTA_CONCRETE);
        CONCRETES.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE);
        CONCRETES.put(DyeColor.YELLOW, Blocks.YELLOW_CONCRETE);
        CONCRETES.put(DyeColor.LIME, Blocks.LIME_CONCRETE);
        CONCRETES.put(DyeColor.PINK, Blocks.PINK_CONCRETE);
        CONCRETES.put(DyeColor.GRAY, Blocks.GRAY_CONCRETE);
        CONCRETES.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE);
        CONCRETES.put(DyeColor.CYAN, Blocks.CYAN_CONCRETE);
        CONCRETES.put(DyeColor.PURPLE, Blocks.PURPLE_CONCRETE);
        CONCRETES.put(DyeColor.BLUE, Blocks.BLUE_CONCRETE);
        CONCRETES.put(DyeColor.BROWN, Blocks.BROWN_CONCRETE);
        CONCRETES.put(DyeColor.GREEN, Blocks.GREEN_CONCRETE);
        CONCRETES.put(DyeColor.RED, Blocks.RED_CONCRETE);
        CONCRETES.put(DyeColor.BLACK, Blocks.BLACK_CONCRETE);
    }
}
