package pl.panszelescik.colorize.fabric;

import com.google.gson.JsonObject;

import java.util.function.Supplier;

public class JsonUtils {

    public static JsonObject getSafeJsonObject(JsonObject object, String key, Supplier<JsonObject> ifNotFound) {
        if (object.has(key)) {
            var element = object.get(key);
            if (element.isJsonObject()) {
                return element.getAsJsonObject();
            }
        }
        return ifNotFound.get();
    }

    public static JsonObject getSafeJsonObject(JsonObject object, String key) {
        return getSafeJsonObject(object, key, JsonObject::new);
    }

    public static boolean getSafeBoolean(JsonObject object, String key, boolean ifNotFound) {
        if (object.has(key)) {
            var element = object.get(key);
            if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isBoolean()) {
                return element.getAsBoolean();
            }
        }
        return ifNotFound;
    }
}
