package pl.panszelescik.bedcolorer.fabric;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.bedcolorer.common.BedColorerBaseHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BedColorerFabricHandler extends BedColorerBaseHandler {

    private final Map<DyeColor, List<TagKey<Item>>> tags;

    public BedColorerFabricHandler() {
        tags = new HashMap<>();

        for (DyeColor color : DyeColor.values()) {
            var list = new ArrayList<TagKey<Item>>();

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
            for (var entry : tags.entrySet()) {
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
