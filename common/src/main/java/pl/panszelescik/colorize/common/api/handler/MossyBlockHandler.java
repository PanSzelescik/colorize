package pl.panszelescik.colorize.common.api.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.RightClicker;

public abstract class MossyBlockHandler extends BaseBlockHandler {

    protected MossyBlockHandler(@NotNull String key, @NotNull Object2ObjectMap<RightClicker, Block> blocks) {
        super(key, blocks);
    }

    @Override
    protected @NotNull SoundEvent getSound() {
        return SoundEvents.VINE_HIT;
    }
}
