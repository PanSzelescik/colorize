package pl.panszelescik.colorize.common.recipes.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;

@JeiPlugin
public class ColorizeJEIPlugin implements IModPlugin {

    private static final ResourceLocation ID = new ResourceLocation("colorize", "jei");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registration) {
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new ColorizeJEICategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(ColorizeJEICategory.RECIPE_TYPE, ColorizeEventHandler.INSTANCE.getRecipes());
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
    }

    @Override
    public void registerAdvanced(IAdvancedRegistration registration) {
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
    }
}
