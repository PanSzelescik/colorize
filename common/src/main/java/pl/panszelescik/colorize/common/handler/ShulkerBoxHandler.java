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
        var map = new RightClicker2BlockMap(17);

        map.put(Colors.CLEAR, Blocks.SHULKER_BOX);
        map.putColors(Blocks.DYED_SHULKER_BOX);

        SHULKER_BOXES = map.freeze();
    }
}
