package pl.panszelescik.colorize.fabric;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import org.apache.commons.io.FileUtils;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ColorizeFabricConfig implements ColorizeConfig {

    public static final String MODID = "colorize";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Object2BooleanOpenHashMap<String> booleans = new Object2BooleanOpenHashMap<>();

    public void loadConfig(File configDir) throws IOException {
        booleans.defaultReturnValue(false);

        var file = new File(configDir, MODID + ".json");

        if (file.exists()) {
            loadConfigFile(file);
        } else {
            loadFromJson(new JsonObject());
        }

        saveConfig(file);
    }

    private void loadConfigFile(File configFile) throws IOException {
        var string = FileUtils.readFileToString(configFile, StandardCharsets.UTF_8);
        var json = JsonParser.parseString(string).getAsJsonObject();
        loadFromJson(json);
    }

    private void loadFromJson(JsonObject json) {
        var blocksKeys = new String[] {
                "banner",
                "bed",
                "candle",
                "carpet",
                "concrete",
                "concretePowder",
                "glazedTerracotta",
                "shulkerBox",
                "stainedGlass",
                "stainedGlassPane",
                "terracotta",
                "wool"
        };

        var handlers = JsonUtils.getSafeJsonObject(json, "handlers");
        for (var key : blocksKeys) {
            booleans.put("handlers." + key, JsonUtils.getSafeBoolean(handlers, key, () -> true));
        }

        var sneaking = JsonUtils.getSafeJsonObject(json, "sneaking");
        for (var key : blocksKeys) {
            booleans.put("sneaking." + key, JsonUtils.getSafeBoolean(sneaking, key, () -> false));
        }
    }

    private void saveConfig(File configFile) throws IOException {
        var json = new JsonObject();

        for (var entry : booleans.object2BooleanEntrySet()) {
            var object = json;
            var splitted = entry.getKey().split("\\.");

            for (int i = 0; i < splitted.length; i++) {
                var subKey = splitted[i];

                if (i == splitted.length - 1) {
                    object.addProperty(subKey, entry.getBooleanValue());
                } else {
                    var subObject = JsonUtils.getSafeJsonObject(object, subKey, () -> null);
                    if (subObject == null) {
                        subObject = new JsonObject();
                        object.add(subKey, subObject);
                    }

                    object = subObject;
                }
            }
        }

        var string = GSON.toJson(json);
        FileUtils.writeStringToFile(configFile, string, StandardCharsets.UTF_8);
    }

    @Override
    public boolean bannerHandler() {
        return booleans.getBoolean("handlers.banner");
    }

    @Override
    public boolean bedHandler() {
        return booleans.getBoolean("handlers.bed");
    }

    @Override
    public boolean candleHandler() {
        return booleans.getBoolean("handlers.candle");
    }

    @Override
    public boolean carpetHandler() {
        return booleans.getBoolean("handlers.carpet");
    }

    @Override
    public boolean concreteHandler() {
        return booleans.getBoolean("handlers.concrete");
    }

    @Override
    public boolean concretePowderHandler() {
        return booleans.getBoolean("handlers.concretePowder");
    }

    @Override
    public boolean glazedTerracottaHandler() {
        return booleans.getBoolean("handlers.glazedTerracotta");
    }

    @Override
    public boolean shulkerBoxHandler() {
        return booleans.getBoolean("handlers.shulkerBox");
    }

    @Override
    public boolean stainedGlassHandler() {
        return booleans.getBoolean("handlers.stainedGlass");
    }

    @Override
    public boolean stainedGlassPaneHandler() {
        return booleans.getBoolean("handlers.stainedGlassPane");
    }

    @Override
    public boolean terracottaHandler() {
        return booleans.getBoolean("handlers.terracotta");
    }

    @Override
    public boolean woolHandler() {
        return booleans.getBoolean("handlers.wool");
    }


    @Override
    public boolean bannerSneaking() {
        return booleans.getBoolean("sneaking.banner");
    }

    @Override
    public boolean bedSneaking() {
        return booleans.getBoolean("sneaking.bed");
    }

    @Override
    public boolean candleSneaking() {
        return booleans.getBoolean("sneaking.candle");
    }

    @Override
    public boolean carpetSneaking() {
        return booleans.getBoolean("sneaking.carpet");
    }

    @Override
    public boolean concreteSneaking() {
        return booleans.getBoolean("sneaking.concrete");
    }

    @Override
    public boolean concretePowderSneaking() {
        return booleans.getBoolean("sneaking.concretePowder");
    }

    @Override
    public boolean glazedTerracottaSneaking() {
        return booleans.getBoolean("sneaking.glazedTerracotta");
    }

    @Override
    public boolean shulkerBoxSneaking() {
        return booleans.getBoolean("sneaking.shulkerBox");
    }

    @Override
    public boolean stainedGlassSneaking() {
        return booleans.getBoolean("sneaking.stainedGlass");
    }

    @Override
    public boolean stainedGlassPaneSneaking() {
        return booleans.getBoolean("sneaking.stainedGlassPane");
    }

    @Override
    public boolean terracottaSneaking() {
        return booleans.getBoolean("sneaking.terracotta");
    }

    @Override
    public boolean woolSneaking() {
        return booleans.getBoolean("sneaking.wool");
    }
}
