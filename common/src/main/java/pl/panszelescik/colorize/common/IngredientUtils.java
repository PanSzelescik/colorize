package pl.panszelescik.colorize.common;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IngredientUtils {

    public static Ingredient createIngredientFromTag(TagKey<Item> tag) {
        return Ingredient.of(getItemsInTag(tag));
    }

    public static Stream<Item> getItemsInTag(TagKey<Item> tag) {
        var items = BuiltInRegistries.ITEM.getTagOrEmpty(tag);
        return StreamSupport
                .stream(items.spliterator(), false)
                .map(Holder::value);
    }
}
