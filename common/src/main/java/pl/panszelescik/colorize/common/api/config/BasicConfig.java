package pl.panszelescik.colorize.common.api.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanMaps;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import pl.panszelescik.colorize.common.Colorize;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BasicConfig implements ColorizeConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final Object2BooleanMap<String> booleans;

    public BasicConfig(@NotNull File configDir) throws IOException {
        var file = new File(configDir, Colorize.MODID + ".json");

        if (file.exists()) {
            this.booleans = loadConfigFile(file);
        } else {
            this.booleans = loadFromJson(new JsonObject());
        }

        saveConfig(file);
    }

    private @NotNull Object2BooleanMap<String> loadConfigFile(@NotNull File configFile) throws IOException {
        var string = FileUtils.readFileToString(configFile, StandardCharsets.UTF_8);
        var json = JsonParser.parseString(string).getAsJsonObject();
        return loadFromJson(json);
    }

    private @NotNull @Unmodifiable Object2BooleanMap<String> loadFromJson(@NotNull JsonObject json) {
        var map = new Object2BooleanOpenHashMap<String>();
        map.defaultReturnValue(false);

        var handlers = JsonUtils.getJsonObject(json, "handlers").orElseGet(JsonObject::new);
        for (var name : this.handlersNames) {
            var key = ColorizeConfig.formatPath(name);
            map.put("handlers." + key, JsonUtils.getBoolean(handlers, key).orElse(true).booleanValue());
            map.put("consume." + key, JsonUtils.getBoolean(handlers, key).orElse(true).booleanValue());
        }

        var sneaking = JsonUtils.getJsonObject(json, "sneaking").orElseGet(JsonObject::new);
        for (var name : this.sneakingFalseKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("sneaking." + key, JsonUtils.getBoolean(sneaking, key).orElse(false).booleanValue());
        }
        for (var name : this.sneakingTrueKeys) {
            var key = ColorizeConfig.formatPath(name);
            map.put("sneaking." + key, JsonUtils.getBoolean(sneaking, key).orElse(true).booleanValue());
        }

        return Object2BooleanMaps.unmodifiable(map);
    }

    private void saveConfig(@NotNull File configFile) throws IOException {
        var json = new JsonObject();

        for (var entry : this.booleans.object2BooleanEntrySet()) {
            var object = json;
            var splitted = entry.getKey().split("\\.");

            for (int i = 0; i < splitted.length; i++) {
                var subKey = splitted[i];

                if (i == splitted.length - 1) {
                    object.addProperty(subKey, entry.getBooleanValue());
                } else {
                    var subObject = JsonUtils.getJsonObject(object, subKey);
                    if (subObject.isEmpty()) {
                        var newObject = new JsonObject();
                        object.add(subKey, newObject);
                        object = newObject;
                    } else {
                        object = subObject.get();
                    }
                }
            }
        }

        var string = GSON.toJson(json);
        FileUtils.writeStringToFile(configFile, string, StandardCharsets.UTF_8);
    }

    @Override
    public boolean getBoolean(@NotNull String key) {
        return this.booleans.getBoolean(key);
    }
}
