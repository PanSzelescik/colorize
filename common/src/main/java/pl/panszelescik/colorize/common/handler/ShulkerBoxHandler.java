package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import pl.panszelescik.colorize.common.api.BaseBlockEntityHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class ShulkerBoxHandler extends BaseBlockEntityHandler<ShulkerBoxBlockEntity> {

    public ShulkerBoxHandler() {
        super("shulkerBox", SHULKER_BOXES, ShulkerBoxBlockEntity.class);
    }

    private static final RightClicker2BlockMap SHULKER_BOXES = new RightClicker2BlockMap(16);

    static {
        SHULKER_BOXES.put(Colors.WHITE, Blocks.WHITE_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.ORANGE, Blocks.ORANGE_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.MAGENTA, Blocks.MAGENTA_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.YELLOW, Blocks.YELLOW_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.LIME, Blocks.LIME_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.PINK, Blocks.PINK_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.GRAY, Blocks.GRAY_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.CYAN, Blocks.CYAN_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.PURPLE, Blocks.PURPLE_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.BLUE, Blocks.BLUE_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.BROWN, Blocks.BROWN_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.GREEN, Blocks.GREEN_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.RED, Blocks.RED_SHULKER_BOX);
        SHULKER_BOXES.put(Colors.BLACK, Blocks.BLACK_SHULKER_BOX);
    }
}
