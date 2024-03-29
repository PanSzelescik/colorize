package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.handler.BaseBlockEntityHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class ShulkerBoxHandler extends BaseBlockEntityHandler<ShulkerBoxBlockEntity> {

    public ShulkerBoxHandler() {
        super("shulkerBox", SHULKER_BOXES, ShulkerBoxBlockEntity.class);
    }

    private static final Object2ObjectMap<RightClicker, Block> SHULKER_BOXES;

    static {
        var map = new RightClicker2BlockMap(16);

        map.put(Colors.CLEAR, Blocks.SHULKER_BOX);
        map.put(Colors.WHITE, Blocks.WHITE_SHULKER_BOX);
        map.put(Colors.ORANGE, Blocks.ORANGE_SHULKER_BOX);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_SHULKER_BOX);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_SHULKER_BOX);
        map.put(Colors.YELLOW, Blocks.YELLOW_SHULKER_BOX);
        map.put(Colors.LIME, Blocks.LIME_SHULKER_BOX);
        map.put(Colors.PINK, Blocks.PINK_SHULKER_BOX);
        map.put(Colors.GRAY, Blocks.GRAY_SHULKER_BOX);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_SHULKER_BOX);
        map.put(Colors.CYAN, Blocks.CYAN_SHULKER_BOX);
        map.put(Colors.PURPLE, Blocks.PURPLE_SHULKER_BOX);
        map.put(Colors.BLUE, Blocks.BLUE_SHULKER_BOX);
        map.put(Colors.BROWN, Blocks.BROWN_SHULKER_BOX);
        map.put(Colors.GREEN, Blocks.GREEN_SHULKER_BOX);
        map.put(Colors.RED, Blocks.RED_SHULKER_BOX);
        map.put(Colors.BLACK, Blocks.BLACK_SHULKER_BOX);

        SHULKER_BOXES = map.freeze();
    }
}
