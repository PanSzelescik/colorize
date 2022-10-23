package pl.panszelescik.colorize.common.api.handler;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public abstract class BaseBlockEntityHandler<T extends BlockEntity> extends BaseBlockHandler {

    private final Class<T> clazz;

    protected BaseBlockEntityHandler(String key, RightClicker2BlockMap blocks, Class<T> clazz) {
        super(key, blocks);
        this.clazz = clazz;
    }

    @Override
    protected boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, BlockState newState, Player player) {
        var blockEntity = level.getBlockEntity(pos);
        if (this.clazz.isInstance(blockEntity)) {
            var tag = blockEntity.saveWithoutMetadata();

            super.replace(level, pos, state, stack, newState.getBlock().withPropertiesOf(state), player);

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
