package pl.panszelescik.colorize.neoforge;

import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.ColorizeCommonTagEventHandler;
import pl.panszelescik.colorize.common.api.ColorizeConfig;

public class ColorizeForgeHandler extends ColorizeCommonTagEventHandler {

    public ColorizeForgeHandler(@NotNull ColorizeConfig config) {
        super(config);
    }

    @Override
    public boolean isForge() {
        return true;
    }
}
