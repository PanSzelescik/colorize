package pl.panszelescik.colorize.common.handler;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import pl.panszelescik.colorize.common.api.handler.BaseBlockEntityHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;

public class BannerBlockHandler extends BaseBlockEntityHandler<BannerBlockEntity> {

    public BannerBlockHandler() {
        super("banner", BANNERS, BannerBlockEntity.class);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundEvents.WOOL_HIT;
    }

    private static final RightClicker2BlockMap BANNERS = new RightClicker2BlockMap(16);

    static {
        BANNERS.put(Colors.WHITE, Blocks.WHITE_BANNER);
        BANNERS.put(Colors.ORANGE, Blocks.ORANGE_BANNER);
        BANNERS.put(Colors.MAGENTA, Blocks.MAGENTA_BANNER);
        BANNERS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_BANNER);
        BANNERS.put(Colors.YELLOW, Blocks.YELLOW_BANNER);
        BANNERS.put(Colors.LIME, Blocks.LIME_BANNER);
        BANNERS.put(Colors.PINK, Blocks.PINK_BANNER);
        BANNERS.put(Colors.GRAY, Blocks.GRAY_BANNER);
        BANNERS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_BANNER);
        BANNERS.put(Colors.CYAN, Blocks.CYAN_BANNER);
        BANNERS.put(Colors.PURPLE, Blocks.PURPLE_BANNER);
        BANNERS.put(Colors.BLUE, Blocks.BLUE_BANNER);
        BANNERS.put(Colors.BROWN, Blocks.BROWN_BANNER);
        BANNERS.put(Colors.GREEN, Blocks.GREEN_BANNER);
        BANNERS.put(Colors.RED, Blocks.RED_BANNER);
        BANNERS.put(Colors.BLACK, Blocks.BLACK_BANNER);
    }
}
