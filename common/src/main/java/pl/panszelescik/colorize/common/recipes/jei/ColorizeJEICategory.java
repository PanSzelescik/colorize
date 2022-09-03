package pl.panszelescik.colorize.common.recipes.jei;

import mezz.jei.api.constants.ModIds;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

public class ColorizeJEICategory implements IRecipeCategory<ColorizeRecipe> {

    public static final RecipeType<ColorizeRecipe> RECIPE_TYPE = RecipeType.create("colorize", "colorize", ColorizeRecipe.class);

    public static final String TEXTURE_GUI_PATH = "textures/gui/";
    public static final String TEXTURE_GUI_VANILLA = TEXTURE_GUI_PATH + "gui_vanilla.png";
    public static final ResourceLocation RECIPE_GUI_VANILLA = new ResourceLocation(ModIds.JEI_ID, TEXTURE_GUI_VANILLA);

    private final IDrawableStatic background;
    private final IDrawable icon;
    private final Component title = new TextComponent("Colorize");

    public ColorizeJEICategory(IGuiHelper guiHelper) {
        // Use Anvil texture
        this.background = guiHelper.createDrawable(RECIPE_GUI_VANILLA, 0, 168, 125, 18);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.PINK_DYE));
    }

    @Override
    public RecipeType<ColorizeRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return this.title;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ColorizeRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.CATALYST, 1, 1)
                .setSlotName("input")
                .addIngredients(recipe.validBlocks());

        builder.addSlot(RecipeIngredientRole.INPUT, 50, 1)
                .setSlotName("item")
                .addIngredients(recipe.item());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 1)
                .setSlotName("output")
                .addItemStack(recipe.result());
    }

    @Override
    public ResourceLocation getUid() {
        return RECIPE_TYPE.getUid();
    }

    @Override
    public Class<? extends ColorizeRecipe> getRecipeClass() {
        return RECIPE_TYPE.getRecipeClass();
    }
}
