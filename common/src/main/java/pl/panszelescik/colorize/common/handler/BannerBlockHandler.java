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

    private static final Object2ObjectOpenHashMap<DyeColor, BannerBlock> BANNERS = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, (BannerBlock) Blocks.WHITE_BANNER);
        put(DyeColor.ORANGE, (BannerBlock) Blocks.ORANGE_BANNER);
        put(DyeColor.MAGENTA, (BannerBlock) Blocks.MAGENTA_BANNER);
        put(DyeColor.LIGHT_BLUE, (BannerBlock) Blocks.LIGHT_BLUE_BANNER);
        put(DyeColor.YELLOW, (BannerBlock) Blocks.YELLOW_BANNER);
        put(DyeColor.LIME, (BannerBlock) Blocks.LIME_BANNER);
        put(DyeColor.PINK, (BannerBlock) Blocks.PINK_BANNER);
        put(DyeColor.GRAY, (BannerBlock) Blocks.GRAY_BANNER);
        put(DyeColor.LIGHT_GRAY, (BannerBlock) Blocks.LIGHT_GRAY_BANNER);
        put(DyeColor.CYAN, (BannerBlock) Blocks.CYAN_BANNER);
        put(DyeColor.PURPLE, (BannerBlock) Blocks.PURPLE_BANNER);
        put(DyeColor.BLUE, (BannerBlock) Blocks.BLUE_BANNER);
        put(DyeColor.BROWN, (BannerBlock) Blocks.BROWN_BANNER);
        put(DyeColor.GREEN, (BannerBlock) Blocks.GREEN_BANNER);
        put(DyeColor.RED, (BannerBlock) Blocks.RED_BANNER);
        put(DyeColor.BLACK, (BannerBlock) Blocks.BLACK_BANNER);
    }};
}
