package pl.panszelescik.colorize.common.api;

import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public enum Colors {

    CLEAR(null),
    WHITE(DyeColor.WHITE),
    ORANGE(DyeColor.ORANGE),
    MAGENTA(DyeColor.MAGENTA),
    LIGHT_BLUE(DyeColor.LIGHT_BLUE),
    YELLOW(DyeColor.YELLOW),
    LIME(DyeColor.LIME),
    PINK(DyeColor.PINK),
    GRAY(DyeColor.GRAY),
    LIGHT_GRAY(DyeColor.LIGHT_GRAY),
    CYAN(DyeColor.CYAN),
    PURPLE(DyeColor.PURPLE),
    BLUE(DyeColor.BLUE),
    BROWN(DyeColor.BROWN),
    GREEN(DyeColor.GREEN),
    RED(DyeColor.RED),
    BLACK(DyeColor.BLACK),
    ;

    private final @Nullable DyeColor dyeColor;

    Colors(@Nullable DyeColor dyeColor) {
        this.dyeColor = dyeColor;
    }

    public @Nullable DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public static @NotNull Colors getByDyeColor(@Nullable DyeColor dyeColor) {
        return Arrays
                .stream(Colors.values())
                .filter(x -> x.getDyeColor() == dyeColor)
                .findFirst()
                .orElse(Colors.CLEAR);
    }
}
