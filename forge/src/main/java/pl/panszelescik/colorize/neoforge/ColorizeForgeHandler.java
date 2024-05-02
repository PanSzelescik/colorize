package pl.panszelescik.colorize.neoforge;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;
import pl.panszelescik.colorize.common.api.Colors;

import java.util.Optional;

public class ColorizeForgeHandler extends ColorizeEventHandler {

    public ColorizeForgeHandler(@NotNull ColorizeConfig config) {
        super(config);
    }

    @Override
    protected @NotNull Optional<Colors> getDyeColor(@NotNull ItemStack stack) {
        return Optional
                .ofNullable(DyeColor.getColor(stack))
                .map(Colors::getByDyeColor);
    }

    @Override
    public boolean isForge() {
        return true;
    }

    public @NotNull Ingredient getColorIngredient(@NotNull Colors color) {
        var dyeColor = color.getDyeColor();
        return dyeColor == null ? Ingredient.EMPTY : Ingredient.of(dyeColor.getTag());
    }
}
