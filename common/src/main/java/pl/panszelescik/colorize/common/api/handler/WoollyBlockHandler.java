package pl.panszelescik.colorize.common.api.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.RightClicker;

public abstract class WoollyBlockHandler extends BaseBlockHandler {

    protected WoollyBlockHandler(String key, Object2ObjectMap<RightClicker, Block> blocks) {
        super(key, blocks);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundEvents.WOOL_HIT;
    }
}
