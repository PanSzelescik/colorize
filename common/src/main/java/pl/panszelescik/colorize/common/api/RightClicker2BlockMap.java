package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public class RightClicker2BlockMap extends Object2ObjectOpenHashMap<RightClicker, Block> {

    public RightClicker2BlockMap(int expected) {
        super(expected);
    }

    public @NotNull Block put(@NotNull ItemStack stack, @NotNull Block block) {
        return this.put(stack.getItem(), block);
    }

    public @NotNull Block put(@NotNull Item item, @NotNull Block block) {
        this.put(RightClicker.of(item), block);
        return block;
    }

    public @NotNull Block put(@NotNull TagKey<Item> tag, @NotNull Block block) {
        this.put(RightClicker.of(tag), block);
        return block;
    }

    public @NotNull Block put(@NotNull Colors color, @NotNull Block block) {
        this.put(RightClicker.of(color), block);
        return block;
    }

    public @NotNull @Unmodifiable Object2ObjectMap<RightClicker, Block> freeze() {
        return Object2ObjectMaps.unmodifiable(this);
    }
}
