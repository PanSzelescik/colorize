package pl.panszelescik.colorize.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import pl.panszelescik.colorize.common.Colorize;

@Mod(value = Colorize.MODID, dist = Dist.CLIENT)
public class ColorizeNeoForgeClient {

    public ColorizeNeoForgeClient(ModContainer modContainer) {
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, (mc, parent) -> new ConfigurationScreen(modContainer, parent));
    }
}
