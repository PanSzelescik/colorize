package pl.panszelescik.colorize.common.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BaseBlockEntityHandler<T extends BlockEntity> extends BaseBlockHandler {

    private final Class<T> clazz;

    protected BaseBlockEntityHandler(String key, RightClicker2BlockMap blocks, Class<T> clazz) {
        super(key, blocks);
        this.clazz = clazz;
    }

    @Override
    protected boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, Block newBlock) {
        var blockEntity = level.getBlockEntity(pos);
        if (this.clazz.isInstance(blockEntity)) {
            var tag = blockEntity.saveWithoutMetadata();

            level.removeBlock(pos, false);

            level.setBlock(pos, newBlock.withPropertiesOf(state), 0);

            var newBlockEntity = level.getBlockEntity(pos);
            if (this.clazz.isInstance(newBlockEntity)) {
                newBlockEntity.load(tag);
                newBlockEntity.setChanged();
                return true;
            }
        }

        return false;
    }
}
