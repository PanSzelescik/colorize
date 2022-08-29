package pl.panszelescik.colorize.common.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class BaseBlockHandler<B extends Block> {

    protected final ColorizeConfig config;

    protected BaseBlockHandler(ColorizeConfig config) {
        this.config = config;
    }

    protected abstract @Nullable B getOldBlock(BlockState state);

    protected abstract @Nullable Colors getOldColor(BlockState state, B block);

    protected abstract B getNewBlock(Colors color);

    protected abstract boolean isEnabled();

    protected abstract boolean requireSneaking();

    public boolean handle(Level level, BlockPos pos, BlockState state, ItemStack stack, Colors newColor) {
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

    protected boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, Colors newColor) {
        level.removeBlock(pos, false);

        var newBlock = this.getNewBlock(newColor);
        level.setBlock(pos, newBlock.withPropertiesOf(state), 0);

        return true;
    }
}
