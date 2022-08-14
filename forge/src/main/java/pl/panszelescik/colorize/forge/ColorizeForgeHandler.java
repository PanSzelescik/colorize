package pl.panszelescik.colorize.forge;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.ColorizeEventHandler;

public class ColorizeForgeHandler extends ColorizeEventHandler {

    @Override
    protected @Nullable DyeColor getDyeColor(ItemStack stack) {
        return DyeColor.getColor(stack);
    }
}
