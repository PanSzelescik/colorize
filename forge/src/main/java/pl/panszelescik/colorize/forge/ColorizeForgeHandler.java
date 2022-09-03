package pl.panszelescik.colorize.forge;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;
import pl.panszelescik.colorize.common.api.Colors;

public class ColorizeForgeHandler extends ColorizeEventHandler {

    public ColorizeForgeHandler(ColorizeConfig config) {
        super(config);
    }

    @Override
    protected @Nullable Colors getDyeColor(ItemStack stack) {
        var color = DyeColor.getColor(stack);
        return color == null ? null : Colors.getByDyeColor(color);
    }

    @Override
    public boolean isForge() {
        return true;
    }

    public Ingredient getColorIngredient(Colors color) {
        return Ingredient.of(color.getDyeColor().getTag());
    }
}
