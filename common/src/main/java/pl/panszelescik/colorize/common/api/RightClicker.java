package pl.panszelescik.colorize.common.api;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RightClicker {

    private @Nullable Item item;
    private @Nullable TagKey<Item> tag;
    private @Nullable Colors color;

    private RightClicker() {
    }

    public static @NotNull RightClicker of(@NotNull Item item) {
        var rightClicker = new RightClicker();
        rightClicker.item = item;
        return rightClicker;
    }

    public static @NotNull RightClicker of(@NotNull TagKey<Item> tag) {
        var rightClicker = new RightClicker();
        rightClicker.tag = tag;
        return rightClicker;
    }

    public static @NotNull RightClicker of(@NotNull Colors color) {
        var rightClicker = new RightClicker();
        rightClicker.color = color;
        return rightClicker;
    }

    public boolean canUse(@NotNull ItemStack stack) {
        if (this.item != null && stack.is(this.item)) {
            return true;
        }

        if (this.tag != null && stack.is(this.tag)) {
            return true;
        }

        if (this.color != null) {
            var optional = ColorizeEventHandler.INSTANCE.getDyeColor(stack);
            return optional.isPresent() && optional.get() == this.color;
        }

        return false;
    }

    public boolean isEmpty() {
        return this.item == null && this.tag == null && (this.color == null || this.color == Colors.CLEAR);
    }

    public @NotNull Ingredient asIngredient() {
        if (this.item != null) {
            return Ingredient.of(this.item);
        }

        if (this.tag != null) {
            return Ingredient.of(this.tag);
        }

        if (this.color != null) {
            return ColorizeEventHandler.INSTANCE.getColorIngredient(this.color);
        }

        return Ingredient.of();
    }
}
