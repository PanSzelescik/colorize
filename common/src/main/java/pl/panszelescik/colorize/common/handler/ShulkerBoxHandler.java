package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.BaseBlockEntityHandler;

public class ShulkerBoxHandler extends BaseBlockEntityHandler<ShulkerBoxBlock, ShulkerBoxBlockEntity> {

    public ShulkerBoxHandler() {
        super(ShulkerBoxBlockEntity.class);
    }

    @Override
    protected @Nullable ShulkerBoxBlock getOldBlock(BlockState state) {
        var block = state.getBlock();
        if (block instanceof ShulkerBoxBlock shulkerBoxBlock && this.getNewBlock(shulkerBoxBlock.getColor()) == shulkerBoxBlock) {
            return shulkerBoxBlock;
        }
        return null;
    }

    @Override
    protected @Nullable DyeColor getOldColor(BlockState state, ShulkerBoxBlock block) {
        return block.getColor();
    }

    @Override
    protected ShulkerBoxBlock getNewBlock(DyeColor color) {
        return ((ShulkerBoxBlock) ShulkerBoxBlock.getBlockByColor(color));
    }
}
