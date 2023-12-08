package pl.panszelescik.colorize.neoforge;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

public class ColorizeForgeConfig implements ColorizeConfig {

    private final Object2ObjectMap<String, ForgeConfigSpec.BooleanValue> booleans;

    public ColorizeForgeConfig(@NotNull ForgeConfigSpec.Builder builder) {
        var map =  new Object2ObjectOpenHashMap<String, ForgeConfigSpec.BooleanValue>();

        builder.comment("Handlers settings");
        builder.push("handlers");
        for (var name : this.sneakingFalseKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("handlers." + key, handler(builder, key, name));
        }
        for (var name : this.sneakingTrueKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("handlers." + key, handlerMossy(builder, key, name));
        }
        builder.pop();

        builder.comment("Sneaking settings");
        builder.push("sneaking");
        for (var name : this.sneakingFalseKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("sneaking." + key, sneaking(builder, key, name, false));
        }
        for (var name : this.sneakingTrueKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("sneaking." + key, sneaking(builder, key, name, true));
        }
        builder.pop();

        builder.comment("Consume item settings");
        builder.push("consume");
        for (var name : this.handlersNames) {
            var key = ColorizeConfig.formatPath(name);
            map.put("consume." + key, consume(builder, key, name));
        }
        builder.pop();

        this.booleans = Object2ObjectMaps.unmodifiable(map);
    }

    private static @NotNull ForgeConfigSpec.BooleanValue handler(@NotNull ForgeConfigSpec.Builder builder, @NotNull String key, @NotNull String name) {
        return builder
                .comment("Enable colorizing " + name + " using one of valid dyes")
                .define(key, true);
    }

    private static @NotNull ForgeConfigSpec.BooleanValue handlerMossy(@NotNull ForgeConfigSpec.Builder builder, @NotNull String key, @NotNull String name) {
        return builder
                .comment("Enable colorizing " + name + " to Mossy variant using Vines")
                .define(key, true);
    }

    private static @NotNull ForgeConfigSpec.BooleanValue sneaking(@NotNull ForgeConfigSpec.Builder builder, @NotNull String key, @NotNull String name, boolean defaultValue) {
        return builder
                .comment("Require sneaking for colorizing " + name)
                .define(key, defaultValue);
    }

    private static @NotNull ForgeConfigSpec.BooleanValue consume(@NotNull ForgeConfigSpec.Builder builder, @NotNull String key, @NotNull String name) {
        return builder
                .comment("Enable consuming item when colorizing " + name)
                .define(key, true);
    }

    public static final ColorizeForgeConfig CONFIG;
    public static final ForgeConfigSpec SPEC;

    static {
        final Pair<ColorizeForgeConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ColorizeForgeConfig::new);
        SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    @Override
    public boolean getBoolean(@NotNull String key) {
        var value = this.booleans.get(key);
        return value != null ? value.get() : false;
    }
}
