package pl.panszelescik.colorize.fabric;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanMaps;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import org.apache.commons.io.FileUtils;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ColorizeFabricConfig implements ColorizeConfig {

    public static final String MODID = "colorize";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Object2BooleanMap<String> booleans;

    public ColorizeFabricConfig(File configDir) throws IOException {
        var file = new File(configDir, MODID + ".json");

        if (file.exists()) {
            this.booleans = loadConfigFile(file);
        } else {
            this.booleans = loadFromJson(new JsonObject());
        }

        saveConfig(file);
    }

    private Object2BooleanMap<String> loadConfigFile(File configFile) throws IOException {
        var string = FileUtils.readFileToString(configFile, StandardCharsets.UTF_8);
        var json = JsonParser.parseString(string).getAsJsonObject();
        return loadFromJson(json);
    }

    private Object2BooleanMap<String> loadFromJson(JsonObject json) {
        var map = new Object2BooleanOpenHashMap<String>();
        map.defaultReturnValue(false);

        var handlers = JsonUtils.getSafeJsonObject(json, "handlers");
        for (var name : this.handlersNames) {
            var key = ColorizeConfig.formatPath(name);
            map.put("handlers." + key, JsonUtils.getSafeBoolean(handlers, key, true));
            map.put("consume." + key, JsonUtils.getSafeBoolean(handlers, key, true));
        }

        var sneaking = JsonUtils.getSafeJsonObject(json, "sneaking");
        for (var name : this.sneakingFalseKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("sneaking." + key, JsonUtils.getSafeBoolean(sneaking, key, false));
        }
        for (var name : this.sneakingTrueKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("sneaking." + key, JsonUtils.getSafeBoolean(sneaking, key, true));
        }

        return Object2BooleanMaps.unmodifiable(map);
    }

    private void saveConfig(File configFile) throws IOException {
        var json = new JsonObject();

        for (var entry : this.booleans.object2BooleanEntrySet()) {
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
        return this.booleans.getBoolean(key);
    }
}
