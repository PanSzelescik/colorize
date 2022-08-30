package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class StainedGlassBlockHandler extends BaseBlockHandler {

    public StainedGlassBlockHandler() {
        super("stainedGlass", STAINED_GLASSES);
    }

    private static final RightClicker2BlockMap STAINED_GLASSES = new RightClicker2BlockMap(18);

    static {
        STAINED_GLASSES.put(Colors.CLEAR, Blocks.GLASS);

        STAINED_GLASSES.put(Colors.WHITE, Blocks.WHITE_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.ORANGE, Blocks.ORANGE_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.MAGENTA, Blocks.MAGENTA_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.YELLOW, Blocks.YELLOW_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.LIME, Blocks.LIME_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.PINK, Blocks.PINK_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.GRAY, Blocks.GRAY_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.CYAN, Blocks.CYAN_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.PURPLE, Blocks.PURPLE_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.BLUE, Blocks.BLUE_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.BROWN, Blocks.BROWN_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.GREEN, Blocks.GREEN_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.RED, Blocks.RED_STAINED_GLASS);
        STAINED_GLASSES.put(Colors.BLACK, Blocks.BLACK_STAINED_GLASS);

        STAINED_GLASSES.put(Items.AMETHYST_SHARD, Blocks.TINTED_GLASS);
    }
}
