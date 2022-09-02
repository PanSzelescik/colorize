package pl.panszelescik.colorize.common.api;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;
import java.util.Optional;

public abstract class BaseBlockHandler {

    private final String key;
    private final RightClicker2BlockMap blocks;

    protected BaseBlockHandler(String key, RightClicker2BlockMap blocks) {
        this.key = key;
        this.blocks = blocks;
    }

    protected Optional<Block> getOldBlock(BlockState state) {
        var block = state.getBlock();
        return this.blocks.containsValue(block) ? Optional.of(block) : Optional.empty();
    }

    protected Optional<Block> getNewBlock(ItemStack stack) {
        return this.blocks
                .object2ObjectEntrySet()
                .stream()
                .filter(e -> e.getKey().canUse(stack))
                .findFirst()
                .map(Map.Entry::getValue);
    }

    protected boolean isEnabled() {
        return ColorizeEventHandler.CONFIG.getBoolean("handlers." + key);
    }

    protected boolean requireSneaking() {
        return ColorizeEventHandler.CONFIG.getBoolean("sneaking." + key);
    }

    protected boolean consumeItem() {
        return ColorizeEventHandler.CONFIG.getBoolean("consume." + key);
    }

    protected SoundEvent getSound() {
        return SoundEvents.STONE_HIT;
    }

    public boolean handle(Level level, BlockPos pos, BlockState state, ItemStack stack) {
        var oldBlock = this.getOldBlock(state);
        if (oldBlock.isEmpty()) {
            return false;
        }

        var newBlock = this.getNewBlock(stack);
        if (newBlock.isEmpty()) {
            return false;
        }

        if (oldBlock.equals(newBlock)) {
            return false;
        }

        var result = this.replace(level, pos, state, stack, newBlock.get());
        if (result) {
            if (this.consumeItem()) {
                stack.shrink(1);
            }
            if (!level.isClientSide) {
                level.playSound(null, pos, this.getSound(), SoundSource.BLOCKS, 1f, 1f);
            }
        }

        return result;
    }

    protected boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, Block newBlock) {
        level.removeBlock(pos, false);

        level.setBlock(pos, newBlock.withPropertiesOf(state), 0);

        return true;
    }
}
