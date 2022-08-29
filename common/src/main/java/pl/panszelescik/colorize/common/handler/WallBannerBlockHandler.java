package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBannerBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.AbstractBannerBlockHandler;
import pl.panszelescik.colorize.common.api.ColorizeConfig;
import pl.panszelescik.colorize.common.api.Colors;

public class WallBannerBlockHandler extends AbstractBannerBlockHandler<WallBannerBlock> {

    public WallBannerBlockHandler(ColorizeConfig config) {
        super(config);
    }

    @Override
    protected @Nullable WallBannerBlock getOldBlock(BlockState state) {
        var block = state.getBlock();
        if (block instanceof WallBannerBlock bannerBlock && WALL_BANNERS.containsValue(bannerBlock)) {
            return bannerBlock;
        }
        return null;
    }

    @Override
    protected @Nullable Colors getOldColor(BlockState state, WallBannerBlock block) {
        return Colors.getByDyeColor(block.getColor());
    }

    @Override
    protected WallBannerBlock getNewBlock(Colors color) {
        return WALL_BANNERS.get(color);
    }

    @Override
    protected boolean isEnabled() {
        return this.config.bannerHandler();
    }

    @Override
    protected boolean requireSneaking() {
        return this.config.bannerSneaking();
    }

    private static final Object2ObjectOpenHashMap<Colors, WallBannerBlock> WALL_BANNERS = new Object2ObjectOpenHashMap<>(16);

    static {
        WALL_BANNERS.put(Colors.WHITE, (WallBannerBlock) Blocks.WHITE_WALL_BANNER);
        WALL_BANNERS.put(Colors.ORANGE, (WallBannerBlock) Blocks.ORANGE_WALL_BANNER);
        WALL_BANNERS.put(Colors.MAGENTA, (WallBannerBlock) Blocks.MAGENTA_WALL_BANNER);
        WALL_BANNERS.put(Colors.LIGHT_BLUE, (WallBannerBlock) Blocks.LIGHT_BLUE_WALL_BANNER);
        WALL_BANNERS.put(Colors.YELLOW, (WallBannerBlock) Blocks.YELLOW_WALL_BANNER);
        WALL_BANNERS.put(Colors.LIME, (WallBannerBlock) Blocks.LIME_WALL_BANNER);
        WALL_BANNERS.put(Colors.PINK, (WallBannerBlock) Blocks.PINK_WALL_BANNER);
        WALL_BANNERS.put(Colors.GRAY, (WallBannerBlock) Blocks.GRAY_WALL_BANNER);
        WALL_BANNERS.put(Colors.LIGHT_GRAY, (WallBannerBlock) Blocks.LIGHT_GRAY_WALL_BANNER);
        WALL_BANNERS.put(Colors.CYAN, (WallBannerBlock) Blocks.CYAN_WALL_BANNER);
        WALL_BANNERS.put(Colors.PURPLE, (WallBannerBlock) Blocks.PURPLE_WALL_BANNER);
        WALL_BANNERS.put(Colors.BLUE, (WallBannerBlock) Blocks.BLUE_WALL_BANNER);
        WALL_BANNERS.put(Colors.BROWN, (WallBannerBlock) Blocks.BROWN_WALL_BANNER);
        WALL_BANNERS.put(Colors.GREEN, (WallBannerBlock) Blocks.GREEN_WALL_BANNER);
        WALL_BANNERS.put(Colors.RED, (WallBannerBlock) Blocks.RED_WALL_BANNER);
        WALL_BANNERS.put(Colors.BLACK, (WallBannerBlock) Blocks.BLACK_WALL_BANNER);
    }
}
