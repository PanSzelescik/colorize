package pl.panszelescik.colorize.common.api.handler;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public abstract class MossyBlockHandler extends BaseBlockHandler {

    protected MossyBlockHandler(String key, RightClicker2BlockMap blocks) {
        super(key, blocks);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundEvents.VINE_HIT;
    }
}
