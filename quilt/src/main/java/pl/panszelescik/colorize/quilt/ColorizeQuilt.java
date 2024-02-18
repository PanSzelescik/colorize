package pl.panszelescik.colorize.quilt;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import pl.panszelescik.colorize.common.api.config.BasicConfig;

import java.io.IOException;

public class ColorizeQuilt implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        BasicConfig config;
        try {
            config = new BasicConfig(QuiltLoader.getConfigDir().toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var handler = new ColorizeQuiltHandler(config);

        UseBlockCallback.EVENT.register((player, level, hand, hitResult)
                -> handler.handle(player, level, hand, hitResult.getBlockPos()) ? InteractionResult.SUCCESS : InteractionResult.PASS);
    }
}
