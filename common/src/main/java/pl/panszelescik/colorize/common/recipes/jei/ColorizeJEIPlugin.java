/*package pl.panszelescik.colorize.common.recipes.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;

@JeiPlugin
public class ColorizeJEIPlugin implements IModPlugin {

    private static final Identifier ID = Identifier.fromNamespaceAndPath("colorize", "jei");

    @Override
    public @NotNull Identifier getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new ColorizeJEICategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(ColorizeJEICategory.RECIPE_TYPE, ColorizeEventHandler.INSTANCE.getRecipes());
    }
}*/
