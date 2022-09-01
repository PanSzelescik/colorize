package pl.panszelescik.colorize.forge;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

public class ColorizeForgeConfig implements ColorizeConfig {

    private final Object2ObjectOpenHashMap<String, ForgeConfigSpec.BooleanValue> booleans = new Object2ObjectOpenHashMap<>();

    public ColorizeForgeConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Handlers settings");
        builder.push("handlers");
        for (var name : this.sneakingFalseKeys) {
            var key = ColorizeConfig.formatPath(name);
            booleans.put("handlers." + key, handler(builder, key, name));
        }
        for (var name : this.sneakingTrueKeys) {
            var key = ColorizeConfig.formatPath(name);
            booleans.put("handlers." + key, handlerMossy(builder, key, name));
        }
        builder.pop();

        builder.comment("Sneaking settings");
        builder.push("sneaking");
        for (var name : this.sneakingFalseKeys) {
            var key = ColorizeConfig.formatPath(name);
            booleans.put("sneaking." + key, sneaking(builder, key, name, false));
        }
        for (var name : this.sneakingTrueKeys) {
            var key = ColorizeConfig.formatPath(name);
            booleans.put("sneaking." + key, sneaking(builder, key, name, true));
        }
        builder.pop();

        builder.comment("Consume item settings");
        builder.push("consume");
        for (var name : this.handlersNames) {
            var key = ColorizeConfig.formatPath(name);
            booleans.put("consume." + key, consume(builder, key, name));
        }
        builder.pop();
    }

    private static ForgeConfigSpec.BooleanValue handler(ForgeConfigSpec.Builder builder, String key, String name) {
        return builder
                .comment("Enable colorizing " + name + " using one of valid dyes")
                .define(key, true);
    }

    private static ForgeConfigSpec.BooleanValue handlerMossy(ForgeConfigSpec.Builder builder, String key, String name) {
        return builder
                .comment("Enable colorizing " + name + " to Mossy variant using Vines")
                .define(key, true);
    }

    private static ForgeConfigSpec.BooleanValue sneaking(ForgeConfigSpec.Builder builder, String key, String name, boolean defaultValue) {
        return builder
                .comment("Require sneaking for colorizing " + name)
                .define(key, defaultValue);
    }

    private static ForgeConfigSpec.BooleanValue consume(ForgeConfigSpec.Builder builder, String key, String name) {
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
    public boolean getBoolean(String key) {
        var value = this.booleans.get(key);
        return value != null ? value.get() : false;
    }
}
