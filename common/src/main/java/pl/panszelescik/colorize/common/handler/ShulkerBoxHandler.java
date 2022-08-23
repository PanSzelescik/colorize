package pl.panszelescik.colorize.common.handler;

import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.BaseBlockEntityHandler;
import pl.panszelescik.colorize.common.api.Colors;

public class ShulkerBoxHandler extends BaseBlockEntityHandler<ShulkerBoxBlock, ShulkerBoxBlockEntity> {

    public ShulkerBoxHandler() {
        super(ShulkerBoxBlockEntity.class);
    }

    @Override
    protected @Nullable ShulkerBoxBlock getOldBlock(BlockState state) {
        var block = state.getBlock();
        if (block instanceof ShulkerBoxBlock shulkerBoxBlock && this.getNewBlock(Colors.getByDyeColor(shulkerBoxBlock.getColor())) == shulkerBoxBlock) {
            return shulkerBoxBlock;
        }
        return null;
    }

    @Override
    protected @Nullable Colors getOldColor(BlockState state, ShulkerBoxBlock block) {
        return Colors.getByDyeColor(block.getColor());
    }

    @Override
    protected ShulkerBoxBlock getNewBlock(Colors color) {
        return ((ShulkerBoxBlock) ShulkerBoxBlock.getBlockByColor(color.getDyeColor()));
    }
}
