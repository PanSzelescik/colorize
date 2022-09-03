package pl.panszelescik.colorize.common.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public record ColorizeRecipe(Ingredient validBlocks, Ingredient item, ItemStack result) {
}
