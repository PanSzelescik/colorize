package pl.panszelescik.colorize.quilt;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;
import pl.panszelescik.colorize.common.api.Colors;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class ColorizeQuiltHandler extends ColorizeEventHandler {

    private final Object2ObjectMap<Colors, ObjectImmutableList<TagKey<Item>>> tags;

    public ColorizeQuiltHandler(@NotNull ColorizeConfig config) {
        super(config);
        var map = new Object2ObjectOpenHashMap<Colors, ObjectImmutableList<TagKey<Item>>>();

        for (Colors c : Colors.values()) {
            var dyeColor = c.getDyeColor();
            if (dyeColor == null) {
                continue;
            }

            var list = ObjectImmutableList.of(
                    TagKey.create(Registries.ITEM, new ResourceLocation("c", dyeColor.getName() + "_dye")),
                    TagKey.create(Registries.ITEM, new ResourceLocation("c", dyeColor.getName() + "_dyes")),
                    TagKey.create(Registries.ITEM, new ResourceLocation("c", "dye_" + dyeColor.getName()))
            );

            map.put(c, list);
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
                .filter(e -> e
                        .getValue()
                        .stream()
                        .anyMatch(stack::is))
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
                .flatMap(t -> t.getValue().stream())
                .map(Ingredient::of)
                .flatMap(i -> Arrays.stream(i.getItems())));
    }
}
