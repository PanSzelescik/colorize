package pl.panszelescik.colorize.common.recipes;

import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record ColorizeRecipe(@NotNull List<ItemStack> validBlocks, @NotNull List<ItemStack> item, @NotNull ItemStack result, boolean sneaking, boolean consume) {
}
