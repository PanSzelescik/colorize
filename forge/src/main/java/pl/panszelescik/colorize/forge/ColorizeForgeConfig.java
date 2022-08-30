package pl.panszelescik.colorize.forge;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

import java.util.Locale;

public class ColorizeForgeConfig implements ColorizeConfig {

    private final ForgeConfigSpec.BooleanValue bannerHandler;
    private final ForgeConfigSpec.BooleanValue bedHandler;
    private final ForgeConfigSpec.BooleanValue candleHandler;
    private final ForgeConfigSpec.BooleanValue carpetHandler;
    private final ForgeConfigSpec.BooleanValue concreteHandler;
    private final ForgeConfigSpec.BooleanValue concretePowderHandler;
    private final ForgeConfigSpec.BooleanValue glazedTerracottaHandler;
    private final ForgeConfigSpec.BooleanValue shulkerBoxHandler;
    private final ForgeConfigSpec.BooleanValue stainedGlassHandler;
    private final ForgeConfigSpec.BooleanValue stainedGlassPaneHandler;
    private final ForgeConfigSpec.BooleanValue terracottaHandler;
    private final ForgeConfigSpec.BooleanValue woolHandler;

    private final ForgeConfigSpec.BooleanValue bannerSneaking;
    private final ForgeConfigSpec.BooleanValue bedSneaking;
    private final ForgeConfigSpec.BooleanValue candleSneaking;
    private final ForgeConfigSpec.BooleanValue carpetSneaking;
    private final ForgeConfigSpec.BooleanValue concreteSneaking;
    private final ForgeConfigSpec.BooleanValue concretePowderSneaking;
    private final ForgeConfigSpec.BooleanValue glazedTerracottaSneaking;
    private final ForgeConfigSpec.BooleanValue shulkerBoxSneaking;
    private final ForgeConfigSpec.BooleanValue stainedGlassSneaking;
    private final ForgeConfigSpec.BooleanValue stainedGlassPaneSneaking;
    private final ForgeConfigSpec.BooleanValue terracottaSneaking;
    private final ForgeConfigSpec.BooleanValue woolSneaking;

    public ColorizeForgeConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Handlers settings");
        builder.push("handlers");
        bannerHandler = handler(builder, "Banner");
        bedHandler = handler(builder, "Bed");
        candleHandler = handler(builder, "Candle");
        carpetHandler = handler(builder, "Carpet");
        concreteHandler = handler(builder, "Concrete");
        concretePowderHandler = handler(builder, "Concrete Powder");
        glazedTerracottaHandler = handler(builder, "Glazed Terracotta");
        shulkerBoxHandler = handler(builder, "Shulker Box");
        stainedGlassHandler = handler(builder, "Stained Glass");
        stainedGlassPaneHandler = handler(builder, "Stained Glass Pane");
        terracottaHandler = handler(builder, "Terracotta");
        woolHandler = handler(builder, "Wool");
        builder.pop();

        builder.comment("Sneaking settings");
        builder.push("sneaking");
        bannerSneaking = sneaking(builder, "Banner");
        bedSneaking = sneaking(builder, "Bed");
        candleSneaking = sneaking(builder, "Candle");
        carpetSneaking = sneaking(builder, "Carpet");
        concreteSneaking = sneaking(builder, "Concrete");
        concretePowderSneaking = sneaking(builder, "Concrete Powder");
        glazedTerracottaSneaking = sneaking(builder, "Glazed Terracotta");
        shulkerBoxSneaking = sneaking(builder, "Shulker Box");
        stainedGlassSneaking = sneaking(builder, "Stained Glass");
        stainedGlassPaneSneaking = sneaking(builder, "Stained Glass Pane");
        terracottaSneaking = sneaking(builder, "Terracotta");
        woolSneaking = sneaking(builder, "Wool");
        builder.pop();
    }

    private ForgeConfigSpec.BooleanValue handler(ForgeConfigSpec.Builder builder, String name) {
        return builder
                .comment("Enable colorizing " + name + " using one of valid dyes")
                .define(formatPath(name), true);
    }

    private ForgeConfigSpec.BooleanValue sneaking(ForgeConfigSpec.Builder builder, String name) {
        return builder
                .comment("Require sneaking for colorizing " + name)
                .define(formatPath(name), false);
    }

    private static String formatPath(String name) {
        return String.valueOf(name.charAt(0)).toLowerCase(Locale.ROOT) + name.substring(1).replace(" ", "");
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
        return switch (key) {
            case "handlers.banner" -> bannerHandler.get();
            case "handlers.bed" -> bedHandler.get();
            case "handlers.candle" -> candleHandler.get();
            case "handlers.carpet" -> carpetHandler.get();
            case "handlers.concrete" -> concreteHandler.get();
            case "handlers.concretePowder" -> concretePowderHandler.get();
            case "handlers.glazedTerracotta" -> glazedTerracottaHandler.get();
            case "handlers.shulkerBox" -> shulkerBoxHandler.get();
            case "handlers.stainedGlass" -> stainedGlassHandler.get();
            case "handlers.stainedGlassPane" -> stainedGlassPaneHandler.get();
            case "handlers.terracotta" -> terracottaHandler.get();
            case "handlers.wool" -> woolHandler.get();

            case "sneaking.banner" -> bannerSneaking.get();
            case "sneaking.bed" -> bedSneaking.get();
            case "sneaking.candle" -> candleSneaking.get();
            case "sneaking.carpet" -> carpetSneaking.get();
            case "sneaking.concrete" -> concreteSneaking.get();
            case "sneaking.concretePowder" -> concretePowderSneaking.get();
            case "sneaking.glazedTerracotta" -> glazedTerracottaSneaking.get();
            case "sneaking.shulkerBox" -> shulkerBoxSneaking.get();
            case "sneaking.stainedGlass" -> stainedGlassSneaking.get();
            case "sneaking.stainedGlassPane" -> stainedGlassPaneSneaking.get();
            case "sneaking.terracotta" -> terracottaSneaking.get();
            case "sneaking.wool" -> woolSneaking.get();

            default -> false;
        };
    }
}
