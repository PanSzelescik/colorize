package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class ColorizeCommonTagEventHandler extends ColorizeEventHandler {

    private final Object2ObjectMap<Colors, TagKey<Item>> tags;

    public ColorizeCommonTagEventHandler(@NotNull ColorizeConfig config) {
        super(config);
        var map = new Object2ObjectOpenHashMap<Colors, TagKey<Item>>();

        for (Colors c : Colors.values()) {
            var tag = c.getCommonTag();
            if (tag == null) {
                continue;
            }

            map.put(c, tag);
        }

        this.tags = Object2ObjectMaps.unmodifiable(map);
    }

    @Override
    protected @NotNull Optional<Colors> getDyeColor(@NotNull ItemStack stack) {
        var optional = super.getDyeColor(stack);
        if (optional.isPresent()) {
            return optional;
        }

        return this.tags
                .object2ObjectEntrySet()
                .stream()
                .filter(e -> stack.is(e.getValue()))
                .findFirst()
                .map(Map.Entry::getKey);
    }

    public @NotNull Ingredient getColorIngredient(@NotNull Colors color) {
        return Ingredient.of(this.tags
                .object2ObjectEntrySet()
                .stream()
                .filter(e -> e.getKey() == color)
                .findFirst()
                .stream()
                .map(t -> Ingredient.of(t.getValue()))
                .flatMap(i -> Arrays.stream(i.getItems())));
    }
}
