package pl.panszelescik.colorize.common.api;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.IngredientUtils;

import java.util.List;

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

    public @NotNull List<ItemStack> asStackList() {
        if (this.item != null) {
            return List.of(new ItemStack(this.item));
        }

        if (this.tag != null) {
            return IngredientUtils.getItemStacksInTag(this.tag).toList();
        }

        if (this.color != null) {
            return ColorizeEventHandler.INSTANCE.getColorItemStacks(this.color);
        }

        return List.of();
    }
}
