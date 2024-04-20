package pl.panszelescik.colorize.neoforge;

import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.ColorizeCommonTagEventHandler;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

public class ColorizeNeoForgeHandler extends ColorizeCommonTagEventHandler {

    public ColorizeNeoForgeHandler(@NotNull ColorizeConfig config) {
        super(config);
    }

    @Override
    public boolean isForge() {
        return true;
    }
}
