package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.BannerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.AbstractBannerBlockHandler;
import pl.panszelescik.colorize.common.api.Colors;

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
    protected @Nullable Colors getOldColor(BlockState state, BannerBlock block) {
        return Colors.getByDyeColor(block.getColor());
    }

    @Override
    protected BannerBlock getNewBlock(Colors color) {
        return BANNERS.get(color);
    }

    private static final Object2ObjectOpenHashMap<Colors, BannerBlock> BANNERS = new Object2ObjectOpenHashMap<>(16);

    static {
        BANNERS.put(Colors.WHITE, (BannerBlock) Blocks.WHITE_BANNER);
        BANNERS.put(Colors.ORANGE, (BannerBlock) Blocks.ORANGE_BANNER);
        BANNERS.put(Colors.MAGENTA, (BannerBlock) Blocks.MAGENTA_BANNER);
        BANNERS.put(Colors.LIGHT_BLUE, (BannerBlock) Blocks.LIGHT_BLUE_BANNER);
        BANNERS.put(Colors.YELLOW, (BannerBlock) Blocks.YELLOW_BANNER);
        BANNERS.put(Colors.LIME, (BannerBlock) Blocks.LIME_BANNER);
        BANNERS.put(Colors.PINK, (BannerBlock) Blocks.PINK_BANNER);
        BANNERS.put(Colors.GRAY, (BannerBlock) Blocks.GRAY_BANNER);
        BANNERS.put(Colors.LIGHT_GRAY, (BannerBlock) Blocks.LIGHT_GRAY_BANNER);
        BANNERS.put(Colors.CYAN, (BannerBlock) Blocks.CYAN_BANNER);
        BANNERS.put(Colors.PURPLE, (BannerBlock) Blocks.PURPLE_BANNER);
        BANNERS.put(Colors.BLUE, (BannerBlock) Blocks.BLUE_BANNER);
        BANNERS.put(Colors.BROWN, (BannerBlock) Blocks.BROWN_BANNER);
        BANNERS.put(Colors.GREEN, (BannerBlock) Blocks.GREEN_BANNER);
        BANNERS.put(Colors.RED, (BannerBlock) Blocks.RED_BANNER);
        BANNERS.put(Colors.BLACK, (BannerBlock) Blocks.BLACK_BANNER);
    }
}
