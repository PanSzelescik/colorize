package pl.panszelescik.colorize.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

@Mod(ColorizeNeoForge.MODID)
public class ColorizeNeoForge {

    public static final String MODID = "colorize";
    private final ColorizeNeoForgeHandler handler = new ColorizeNeoForgeHandler(ColorizeNeoForgeConfig.CONFIG);

    public ColorizeNeoForge(ModContainer modContainer, IEventBus bus) {
        bus.addListener(this::onRightClickBlock);

        modContainer.registerConfig(ModConfig.Type.COMMON, ColorizeNeoForgeConfig.SPEC);
    }

    private void onRightClickBlock(@NotNull PlayerInteractEvent.RightClickBlock event) {
        if (this.handler.handle(event.getEntity(), event.getLevel(), event.getHand(), event.getPos())) {
            event.setCanceled(true);
        }
    }
}
