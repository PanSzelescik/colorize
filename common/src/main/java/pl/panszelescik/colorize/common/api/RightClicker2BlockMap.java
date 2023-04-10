package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class RightClicker2BlockMap extends Object2ObjectOpenHashMap<RightClicker, Block> {

    public RightClicker2BlockMap(int expected) {
        super(expected);
    }

    public Block put(ItemStack stack, Block block) {
        return this.put(stack.getItem(), block);
    }

    public Block put(Item item, Block block) {
        return super.put(RightClicker.of(item), block);
    }

    public Block put(TagKey<Item> tag, Block block) {
        return super.put(RightClicker.of(tag), block);
    }

    public Block put(Colors color, Block block) {
        return super.put(RightClicker.of(color), block);
    }

    public Object2ObjectMap<RightClicker, Block> freeze() {
        return Object2ObjectMaps.unmodifiable(this);
    }
}
