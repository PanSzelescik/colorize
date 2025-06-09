package pl.panszelescik.colorize.common.recipes.jei;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotRichTooltipCallback;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

public class ColorizeJEICategory extends AbstractRecipeCategory<ColorizeRecipe> {

    public static final IRecipeType<ColorizeRecipe> RECIPE_TYPE = IRecipeType.create("colorize", "colorize", ColorizeRecipe.class);

    private static final Component TITLE = Component.translatable("gui.colorize.jei.name");
    private static final Component SNEAKING = Component.translatable("gui.colorize.jei.sneaking").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY);
    private static final Component CONSUME = Component.translatable("gui.colorize.jei.consume").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY);

    public ColorizeJEICategory(IGuiHelper guiHelper) {
        super(
                RECIPE_TYPE,
                TITLE,
                guiHelper.createDrawableItemLike(Items.PINK_DYE),
                125,
                18
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ColorizeRecipe recipe, IFocusGroup focuses) {
        IRecipeSlotRichTooltipCallback callback = (recipeSlotView, tooltip) -> {
            if (recipe.sneaking()) {
                tooltip.add(SNEAKING);
            }
        };
        IRecipeSlotRichTooltipCallback callback2 = (recipeSlotView, tooltip) -> {
            callback.onRichTooltip(recipeSlotView, tooltip);
            if (recipe.consume()) {
                tooltip.add(CONSUME);
            }
        };

        var leftInputs = recipe.validBlocks();
        var rightInputs = recipe.item();
        var outputs = recipe.result();

        var leftInputSlot = builder.addSlot(RecipeIngredientRole.CRAFTING_STATION, 1, 1)
                .setSlotName("input")
                .addItemStacks(leftInputs)
                .addRichTooltipCallback(callback)
                .setStandardSlotBackground();

        var rightInputSlot = builder.addSlot(RecipeIngredientRole.INPUT, 50, 1)
                .setSlotName("item")
                .addItemStacks(rightInputs)
                .addRichTooltipCallback(callback2)
                .setStandardSlotBackground();

        var outputSlot = builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 1)
                .setSlotName("output")
                .add(outputs)
                .addRichTooltipCallback(callback)
                .setStandardSlotBackground();

        if (leftInputs.size() == rightInputs.size()) {
            if (leftInputs.size() == 1) {
                builder.createFocusLink(leftInputSlot, rightInputSlot, outputSlot);
            }
        }
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, ColorizeRecipe recipe, IFocusGroup focuses) {
        builder.addRecipePlusSign().setPosition(27, 3);
        builder.addRecipeArrow().setPosition(76, 1);
    }
}
