package pl.panszelescik.colorize.fabric;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;
import pl.panszelescik.colorize.common.api.Colors;

import java.util.Arrays;
import java.util.Map;

public class ColorizeFabricHandler extends ColorizeEventHandler {

    private final Object2ObjectOpenHashMap<Colors, ObjectArrayList<TagKey<Item>>> tags;

    public ColorizeFabricHandler(ColorizeConfig config) {
        super(config);
        this.tags = new Object2ObjectOpenHashMap<>();

        for (Colors c : Colors.VALUES) {
            var dyeColor = c.getDyeColor();
            if (dyeColor == null) {
                continue;
            }

            var list = new ObjectArrayList<TagKey<Item>>(3);

            list.add(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", dyeColor.getName() + "_dye")));
            list.add(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", dyeColor.getName() + "_dyes")));
            list.add(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "dye_" + dyeColor.getName())));

            this.tags.put(c, list);
        }
    }

    @Override
    protected @Nullable Colors getDyeColor(ItemStack stack) {
        var color = super.getDyeColor(stack);
        if (color != null) {
            return color;
        }

        return this.tags.object2ObjectEntrySet()
                .stream()
                .filter(entry -> entry
                        .getValue()
                        .stream()
                        .anyMatch(stack::is))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Ingredient getColorIngredient(Colors color) {
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
