package pl.panszelescik.colorize.common.api.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.RightClicker;

public abstract class BaseBlockEntityHandler<T extends BlockEntity> extends BaseBlockHandler {

    private final @NotNull Class<T> clazz;

    protected BaseBlockEntityHandler(@NotNull String key, @NotNull Object2ObjectMap<RightClicker, Block> blocks, @NotNull Class<T> clazz) {
        super(key, blocks);
        this.clazz = clazz;
    }

    @Override
    protected boolean replace(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ItemStack stack, @NotNull BlockState newState, @NotNull Player player) {
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
