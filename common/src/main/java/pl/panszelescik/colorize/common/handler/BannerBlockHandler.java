package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.AbstractBannerBlockHandler;

public class BannerBlockHandler extends AbstractBannerBlockHandler<BannerBlock> {

    @Override
    protected @Nullable BannerBlock getOldBlock(BlockState state) {
        var block = state.getBlock();
        if (block instanceof BannerBlock bannerBlock && BANNERS.containsValue(bannerBlock)) {
            return bannerBlock;
        }
        return null;
    }

    @Override
    protected @Nullable DyeColor getOldColor(BlockState state, BannerBlock block) {
        return block.getColor();
    }

    @Override
    protected BannerBlock getNewBlock(DyeColor color) {
        return BANNERS.get(color);
    }

    private static final Object2ObjectOpenHashMap<DyeColor, BannerBlock> BANNERS = new Object2ObjectOpenHashMap<>(16);

    static {
        BANNERS.put(DyeColor.WHITE, (BannerBlock) Blocks.WHITE_BANNER);
        BANNERS.put(DyeColor.ORANGE, (BannerBlock) Blocks.ORANGE_BANNER);
        BANNERS.put(DyeColor.MAGENTA, (BannerBlock) Blocks.MAGENTA_BANNER);
        BANNERS.put(DyeColor.LIGHT_BLUE, (BannerBlock) Blocks.LIGHT_BLUE_BANNER);
        BANNERS.put(DyeColor.YELLOW, (BannerBlock) Blocks.YELLOW_BANNER);
        BANNERS.put(DyeColor.LIME, (BannerBlock) Blocks.LIME_BANNER);
        BANNERS.put(DyeColor.PINK, (BannerBlock) Blocks.PINK_BANNER);
        BANNERS.put(DyeColor.GRAY, (BannerBlock) Blocks.GRAY_BANNER);
        BANNERS.put(DyeColor.LIGHT_GRAY, (BannerBlock) Blocks.LIGHT_GRAY_BANNER);
        BANNERS.put(DyeColor.CYAN, (BannerBlock) Blocks.CYAN_BANNER);
        BANNERS.put(DyeColor.PURPLE, (BannerBlock) Blocks.PURPLE_BANNER);
        BANNERS.put(DyeColor.BLUE, (BannerBlock) Blocks.BLUE_BANNER);
        BANNERS.put(DyeColor.BROWN, (BannerBlock) Blocks.BROWN_BANNER);
        BANNERS.put(DyeColor.GREEN, (BannerBlock) Blocks.GREEN_BANNER);
        BANNERS.put(DyeColor.RED, (BannerBlock) Blocks.RED_BANNER);
        BANNERS.put(DyeColor.BLACK, (BannerBlock) Blocks.BLACK_BANNER);
    }
}
