package pl.panszelescik.bedcolorer.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;

public class BedColorerFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        var handler = new BedColorerFabricHandler();

        UseBlockCallback.EVENT.register((player, level, hand, hitResult)
                -> handler.handle(player, level, hand, hitResult.getBlockPos()) ? InteractionResult.SUCCESS : InteractionResult.PASS);
    }
}
