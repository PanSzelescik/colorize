package pl.panszelescik.colorize.fabric;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;

public class ColorizeFabricHandler extends ColorizeEventHandler {

    private final Object2ObjectOpenHashMap<DyeColor, ObjectArrayList<TagKey<Item>>> tags;

    public ColorizeFabricHandler() {
        tags = new Object2ObjectOpenHashMap<>();

        for (DyeColor color : ColorizeEventHandler.DYE_COLORS) {
            var list = new ObjectArrayList<TagKey<Item>>(3);

            list.add(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", color.getName() + "_dye")));
            list.add(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", color.getName() + "_dyes")));
            list.add(TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("c", "dye_" + color.getName())));

            tags.put(color, list);
        }
    }

    @Override
    protected @Nullable DyeColor getDyeColor(ItemStack stack) {
        var color = super.getDyeColor(stack);

        if (color == null) {
            for (var entry : tags.object2ObjectEntrySet()) {
                for (var tag : entry.getValue()) {
                    if (stack.is(tag)) {
                        return entry.getKey();
                    }
                }
            }
        }

        return color;
    }
}
