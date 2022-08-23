package pl.panszelescik.colorize.forge;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;
import pl.panszelescik.colorize.common.api.Colors;

public class ColorizeForgeHandler extends ColorizeEventHandler {

    @Override
    protected @Nullable Colors getDyeColor(ItemStack stack) {
        var color = DyeColor.getColor(stack);
        return color == null ? null : Colors.getByDyeColor(color);
    }
}
