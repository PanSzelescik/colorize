package pl.panszelescik.colorize.neoforge;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

@Mod(ColorizeNeoForge.MODID)
public class ColorizeNeoForge {

    public static final String MODID = "colorize";
    private final ColorizeNeoForgeHandler handler = new ColorizeNeoForgeHandler(ColorizeNeoForgeConfig.CONFIG);

    public ColorizeNeoForge() {
        NeoForge.EVENT_BUS.addListener(this::onRightClickBlock);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ColorizeNeoForgeConfig.SPEC);
    }

    private void onRightClickBlock(@NotNull PlayerInteractEvent.RightClickBlock event) {
        if (this.handler.handle(event.getEntity(), event.getLevel(), event.getHand(), event.getPos())) {
            event.setCanceled(true);
        }
    }
}
