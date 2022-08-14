package pl.panszelescik.colorize.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(ColorizeForge.MODID)
public class ColorizeForge {

    public static final String MODID = "colorize";
    private final ColorizeForgeHandler handler = new ColorizeForgeHandler();

    public ColorizeForge() {
        MinecraftForge.EVENT_BUS.addListener(this::onRightClickBlock);
    }

    private void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (this.handler.handle(event.getEntity(), event.getLevel(), event.getHand(), event.getPos())) {
            event.setCanceled(true);
        }
    }
}
