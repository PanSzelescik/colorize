package pl.panszelescik.colorize.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.InteractionResult;
import pl.panszelescik.colorize.common.api.config.BasicConfig;

import java.io.IOException;

public class ColorizeFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        BasicConfig config;
        try {
            config = new BasicConfig(FabricLoader.getInstance().getConfigDir().toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var handler = new ColorizeFabricHandler(config);

        UseBlockCallback.EVENT.register((player, level, hand, hitResult)
                -> handler.handle(player, level, hand, hitResult.getBlockPos()) ? InteractionResult.SUCCESS : InteractionResult.PASS);
    }
}
