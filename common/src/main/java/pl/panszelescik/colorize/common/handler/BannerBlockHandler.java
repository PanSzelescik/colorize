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

        map.put(Colors.WHITE, Blocks.WHITE_BANNER);
        map.put(Colors.ORANGE, Blocks.ORANGE_BANNER);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_BANNER);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_BANNER);
        map.put(Colors.YELLOW, Blocks.YELLOW_BANNER);
        map.put(Colors.LIME, Blocks.LIME_BANNER);
        map.put(Colors.PINK, Blocks.PINK_BANNER);
        map.put(Colors.GRAY, Blocks.GRAY_BANNER);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_BANNER);
        map.put(Colors.CYAN, Blocks.CYAN_BANNER);
        map.put(Colors.PURPLE, Blocks.PURPLE_BANNER);
        map.put(Colors.BLUE, Blocks.BLUE_BANNER);
        map.put(Colors.BROWN, Blocks.BROWN_BANNER);
        map.put(Colors.GREEN, Blocks.GREEN_BANNER);
        map.put(Colors.RED, Blocks.RED_BANNER);
        map.put(Colors.BLACK, Blocks.BLACK_BANNER);

        BANNERS = map.freeze();
    }
}
