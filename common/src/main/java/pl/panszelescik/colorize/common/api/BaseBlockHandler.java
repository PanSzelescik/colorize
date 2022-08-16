package pl.panszelescik.colorize.common.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class BaseBlockHandler<B extends Block> {

    protected BaseBlockHandler() {
    }

    protected abstract @Nullable B getOldBlock(BlockState state);

    protected abstract @Nullable DyeColor getOldColor(BlockState state, B block);

    protected abstract B getNewBlock(DyeColor color);

    public boolean handle(Level level, BlockPos pos, BlockState state, ItemStack stack, DyeColor newColor) {
        var oldBlock = this.getOldBlock(state);
        if (oldBlock == null) {
            return false;
        }

        var oldColor = this.getOldColor(state, oldBlock);
        if (oldColor == null || oldColor == newColor) {
            return false;
        }

        var result = this.replace(level, pos, state, stack, newColor);
        if (result) {
            stack.shrink(1);
        }

        return result;
    }

    protected boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, DyeColor newColor) {
        level.removeBlock(pos, false);

        var newBlock = this.getNewBlock(newColor);
        level.setBlock(pos, newBlock.withPropertiesOf(state), 0);

        return true;
    }
}
