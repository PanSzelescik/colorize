package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.handler.BaseBlockEntityHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class BannerBlockHandler extends BaseBlockEntityHandler<BannerBlockEntity> {

    public BannerBlockHandler() {
        super("banner", BANNERS, BannerBlockEntity.class);
    }

    @Override
    protected @NotNull SoundEvent getSound() {
        return SoundEvents.WOOL_HIT;
    }

    private static final Object2ObjectMap<RightClicker, Block> BANNERS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.putColors(Blocks.BANNER);

        BANNERS = map.freeze();
    }
}
