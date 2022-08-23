package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    public static final ObjectArrayList<Colors> VALUES = Arrays.stream(Colors.values()).collect(Collectors.toCollection(ObjectArrayList::new));
    private final @Nullable DyeColor dyeColor;

    Colors(@Nullable DyeColor dyeColor) {
        this.dyeColor = dyeColor;
    }

    public @Nullable DyeColor getDyeColor() {
        return this.dyeColor;
    }

    public @Nullable MaterialColor getMaterialColor() {
        var dyeColor = this.getDyeColor();
        return dyeColor == null ? null : dyeColor.getMaterialColor();
    }

    public static Colors getByDyeColor(DyeColor dyeColor) {
        for (Colors color : VALUES) {
            if (color.getDyeColor() == dyeColor) {
                return color;
            }
        }
        return Colors.CLEAR;
    }

    public static Colors getByMaterialColor(MaterialColor materialColor) {
        for (Colors color : VALUES) {
            if (color.getMaterialColor() == materialColor) {
                return color;
            }
        }
        return Colors.CLEAR;
    }
}
