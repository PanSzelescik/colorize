package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class BaseBlockHandler {

    private final String key;
    private final Object2ObjectMap<RightClicker, Block> blocks;

    protected BaseBlockHandler(String key, Object2ObjectMap<RightClicker, Block> blocks) {
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

    protected boolean isDisabled() {
        return !ColorizeEventHandler.CONFIG.getBoolean("handlers." + key);
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

    public boolean handle(Level level, BlockPos pos, BlockState state, ItemStack stack, Player player) {
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

        var result = this.replace(level, pos, state, stack, newBlock.get().withPropertiesOf(state), player);
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

    protected boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, BlockState newState, Player player) {
        level.setBlockAndUpdate(pos, newState);
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);

        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));

        return true;
    }

    public Stream<ColorizeRecipe> getRecipes() {
        return this.isDisabled() ? Stream.empty() : this.blocks
                .object2ObjectEntrySet()
                .stream()
                .filter(e -> !e.getKey().isEmpty())
                .map(entry -> {
                    var block = entry.getValue();
                    var result = new ItemStack(block);
                    var item = entry.getKey().asIngredient();
                    var validBlocks = Ingredient.of(this.blocks
                            .object2ObjectEntrySet()
                            .stream()
                            .filter(e -> e.getValue() != block)
                            .map(Map.Entry::getValue)
                            .map(ItemStack::new));

                    return new ColorizeRecipe(validBlocks, item, result, this.requireSneaking(), this.consumeItem());
                });
    }
}
