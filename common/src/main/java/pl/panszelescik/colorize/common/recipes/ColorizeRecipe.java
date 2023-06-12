package pl.panszelescik.colorize.common.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public record ColorizeRecipe(@NotNull Ingredient validBlocks, @NotNull Ingredient item, @NotNull ItemStack result, boolean sneaking, boolean consume) {
}
