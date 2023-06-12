package pl.panszelescik.colorize.common.api;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.stream.Stream;

public interface ColorizeConfig {

    boolean getBoolean(@NotNull String key);

    static @NotNull String formatPath(@NotNull String name) {
        return String.valueOf(name.charAt(0)).toLowerCase(Locale.ROOT) + name.substring(1).replace(" ", "");
    }

    String[] sneakingFalseKeys = new String[] {
            "Banner",
            "Bed",
            "Candle",
            "Carpet",
            "Concrete",
            "Concrete Powder",
            "Glazed Terracotta",
            "Shulker Box",
            "Stained Glass",
            "Stained Glass Pane",
            "Terracotta",
            "Wool"
    };
    String[] sneakingTrueKeys = new String[] {
            "Mossy Cobblestone",
            "Mossy Cobblestone Slab",
            "Mossy Cobblestone Stairs",
            "Mossy Cobblestone Wall",
            "Mossy Stone Bricks",
            "Mossy Stone Brick Slab",
            "Mossy Stone Brick Stairs",
            "Mossy Stone Brick Wall"
    };
    String[] handlersNames = Stream.of(sneakingFalseKeys, sneakingTrueKeys).flatMap(Stream::of).toArray(String[]::new);
}
