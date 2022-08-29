package pl.panszelescik.colorize.forge;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

import java.util.Locale;

public class ColorizeForgeConfig implements ColorizeConfig {

    public final ForgeConfigSpec.BooleanValue bannerHandler;
    public final ForgeConfigSpec.BooleanValue bedHandler;
    public final ForgeConfigSpec.BooleanValue candleHandler;
    public final ForgeConfigSpec.BooleanValue carpetHandler;
    public final ForgeConfigSpec.BooleanValue concreteHandler;
    public final ForgeConfigSpec.BooleanValue concretePowderHandler;
    public final ForgeConfigSpec.BooleanValue glazedTerracottaHandler;
    public final ForgeConfigSpec.BooleanValue shulkerBoxHandler;
    public final ForgeConfigSpec.BooleanValue stainedGlassHandler;
    public final ForgeConfigSpec.BooleanValue stainedGlassPaneHandler;
    public final ForgeConfigSpec.BooleanValue terracottaHandler;
    public final ForgeConfigSpec.BooleanValue woolHandler;

    public final ForgeConfigSpec.BooleanValue bannerSneaking;
    public final ForgeConfigSpec.BooleanValue bedSneaking;
    public final ForgeConfigSpec.BooleanValue candleSneaking;
    public final ForgeConfigSpec.BooleanValue carpetSneaking;
    public final ForgeConfigSpec.BooleanValue concreteSneaking;
    public final ForgeConfigSpec.BooleanValue concretePowderSneaking;
    public final ForgeConfigSpec.BooleanValue glazedTerracottaSneaking;
    public final ForgeConfigSpec.BooleanValue shulkerBoxSneaking;
    public final ForgeConfigSpec.BooleanValue stainedGlassSneaking;
    public final ForgeConfigSpec.BooleanValue stainedGlassPaneSneaking;
    public final ForgeConfigSpec.BooleanValue terracottaSneaking;
    public final ForgeConfigSpec.BooleanValue woolSneaking;

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
    public boolean bannerHandler() {
        return bannerHandler.get();
    }

    @Override
    public boolean bedHandler() {
        return bedHandler.get();
    }

    @Override
    public boolean candleHandler() {
        return candleHandler.get();
    }

    @Override
    public boolean carpetHandler() {
        return carpetHandler.get();
    }

    @Override
    public boolean concreteHandler() {
        return concreteHandler.get();
    }

    @Override
    public boolean concretePowderHandler() {
        return concretePowderHandler.get();
    }

    @Override
    public boolean glazedTerracottaHandler() {
        return glazedTerracottaHandler.get();
    }

    @Override
    public boolean shulkerBoxHandler() {
        return shulkerBoxHandler.get();
    }

    @Override
    public boolean stainedGlassHandler() {
        return stainedGlassHandler.get();
    }

    @Override
    public boolean stainedGlassPaneHandler() {
        return stainedGlassPaneHandler.get();
    }

    @Override
    public boolean terracottaHandler() {
        return terracottaHandler.get();
    }

    @Override
    public boolean woolHandler() {
        return woolHandler.get();
    }


    @Override
    public boolean bannerSneaking() {
        return bannerSneaking.get();
    }

    @Override
    public boolean bedSneaking() {
        return bedSneaking.get();
    }

    @Override
    public boolean candleSneaking() {
        return candleSneaking.get();
    }

    @Override
    public boolean carpetSneaking() {
        return carpetSneaking.get();
    }

    @Override
    public boolean concreteSneaking() {
        return concreteSneaking.get();
    }

    @Override
    public boolean concretePowderSneaking() {
        return concretePowderSneaking.get();
    }

    @Override
    public boolean glazedTerracottaSneaking() {
        return glazedTerracottaSneaking.get();
    }

    @Override
    public boolean shulkerBoxSneaking() {
        return shulkerBoxSneaking.get();
    }

    @Override
    public boolean stainedGlassSneaking() {
        return stainedGlassSneaking.get();
    }

    @Override
    public boolean stainedGlassPaneSneaking() {
        return stainedGlassPaneSneaking.get();
    }

    @Override
    public boolean terracottaSneaking() {
        return terracottaSneaking.get();
    }

    @Override
    public boolean woolSneaking() {
        return woolSneaking.get();
    }
}
