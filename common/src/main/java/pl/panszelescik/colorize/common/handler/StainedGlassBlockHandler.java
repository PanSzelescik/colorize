package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.GlassBlockHandler;

public class StainedGlassBlockHandler extends GlassBlockHandler {

    public StainedGlassBlockHandler() {
        super("stainedGlass", STAINED_GLASSES);
    }

    private static final Object2ObjectMap<RightClicker, Block> STAINED_GLASSES;

    static {
        var map = new RightClicker2BlockMap(18);

        map.put(Colors.CLEAR, Blocks.GLASS);

        map.put(Colors.WHITE, Blocks.WHITE_STAINED_GLASS);
        map.put(Colors.ORANGE, Blocks.ORANGE_STAINED_GLASS);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_STAINED_GLASS);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS);
        map.put(Colors.YELLOW, Blocks.YELLOW_STAINED_GLASS);
        map.put(Colors.LIME, Blocks.LIME_STAINED_GLASS);
        map.put(Colors.PINK, Blocks.PINK_STAINED_GLASS);
        map.put(Colors.GRAY, Blocks.GRAY_STAINED_GLASS);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS);
        map.put(Colors.CYAN, Blocks.CYAN_STAINED_GLASS);
        map.put(Colors.PURPLE, Blocks.PURPLE_STAINED_GLASS);
        map.put(Colors.BLUE, Blocks.BLUE_STAINED_GLASS);
        map.put(Colors.BROWN, Blocks.BROWN_STAINED_GLASS);
        map.put(Colors.GREEN, Blocks.GREEN_STAINED_GLASS);
        map.put(Colors.RED, Blocks.RED_STAINED_GLASS);
        map.put(Colors.BLACK, Blocks.BLACK_STAINED_GLASS);

        map.put(Items.AMETHYST_SHARD, Blocks.TINTED_GLASS);

        STAINED_GLASSES = map.freeze();
    }
}
