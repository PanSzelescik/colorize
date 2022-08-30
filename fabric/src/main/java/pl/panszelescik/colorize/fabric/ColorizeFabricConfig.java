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
    public boolean getBoolean(String key) {
        return booleans.getBoolean(key);
    }
}
