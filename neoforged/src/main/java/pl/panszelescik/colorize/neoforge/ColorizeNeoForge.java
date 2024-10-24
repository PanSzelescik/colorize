package pl.panszelescik.colorize.neoforge;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.Colorize;

@Mod(Colorize.MODID)
public class ColorizeNeoForge {

    private final ColorizeNeoForgeHandler handler = new ColorizeNeoForgeHandler(ColorizeNeoForgeConfig.CONFIG);

    public ColorizeNeoForge(ModContainer modContainer) {
        NeoForge.EVENT_BUS.addListener(this::onRightClickBlock);

        modContainer.registerConfig(ModConfig.Type.COMMON, ColorizeNeoForgeConfig.SPEC);
    }

    private void onRightClickBlock(@NotNull PlayerInteractEvent.RightClickBlock event) {
        if (this.handler.handle(event.getEntity(), event.getLevel(), event.getHand(), event.getPos())) {
            event.setCanceled(true);
        }
    }
}
