package pl.panszelescik.colorize.fabric;

import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class JsonUtils {

    public static @NotNull Optional<JsonObject> getJsonObject(@NotNull JsonObject object, @NotNull String key) {
        if (object.has(key)) {
            var element = object.get(key);
            if (element.isJsonObject()) {
                return Optional.of(element.getAsJsonObject());
            }
        }
        return Optional.empty();
    }

    public static Optional<Boolean> getBoolean(@NotNull JsonObject object, @NotNull String key) {
        if (object.has(key)) {
            var element = object.get(key);
            if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isBoolean()) {
                return Optional.of(element.getAsBoolean());
            }
        }
        return Optional.empty();
    }
}
