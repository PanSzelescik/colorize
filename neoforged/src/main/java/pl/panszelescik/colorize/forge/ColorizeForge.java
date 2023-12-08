package pl.panszelescik.colorize.forge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

@Mod(ColorizeForge.MODID)
public class ColorizeForge {

    public static final String MODID = "colorize";
    private final ColorizeForgeHandler handler = new ColorizeForgeHandler(ColorizeForgeConfig.CONFIG);

    public ColorizeForge(IEventBus modEventBus) {
        modEventBus.addListener(this::onRightClickBlock);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ColorizeForgeConfig.SPEC);
    }

    private void onRightClickBlock(@NotNull PlayerInteractEvent.RightClickBlock event) {
        if (this.handler.handle(event.getEntity(), event.getLevel(), event.getHand(), event.getPos())) {
            event.setCanceled(true);
        }
    }
}
