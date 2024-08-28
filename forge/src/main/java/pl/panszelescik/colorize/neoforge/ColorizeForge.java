package pl.panszelescik.colorize.neoforge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.Colorize;

@Mod(Colorize.MODID)
public class ColorizeForge {

    private final ColorizeForgeHandler handler = new ColorizeForgeHandler(ColorizeForgeConfig.CONFIG);

    public ColorizeForge(ModLoadingContext modLoadingContext) {
        MinecraftForge.EVENT_BUS.addListener(this::onRightClickBlock);

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ColorizeForgeConfig.SPEC);
    }

    private void onRightClickBlock(@NotNull PlayerInteractEvent.RightClickBlock event) {
        if (this.handler.handle(event.getEntity(), event.getLevel(), event.getHand(), event.getPos())) {
            event.setCanceled(true);
        }
    }
}
