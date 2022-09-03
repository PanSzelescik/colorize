package pl.panszelescik.colorize.common.handler;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import pl.panszelescik.colorize.common.api.handler.BaseBlockEntityHandler;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

import java.util.stream.Stream;

public class WallBannerBlockHandler extends BaseBlockEntityHandler<BannerBlockEntity> {

    public WallBannerBlockHandler() {
        super("banner", WALL_BANNERS, BannerBlockEntity.class);
    }

    @Override
    protected SoundEvent getSound() {
        return SoundEvents.WOOL_HIT;
    }

    @Override
    public Stream<ColorizeRecipe> getRecipes() {
        return Stream.empty(); // Don't duplicate recipes
    }

    private static final RightClicker2BlockMap WALL_BANNERS = new RightClicker2BlockMap(16);

    static {
        WALL_BANNERS.put(Colors.WHITE, Blocks.WHITE_WALL_BANNER);
        WALL_BANNERS.put(Colors.ORANGE, Blocks.ORANGE_WALL_BANNER);
        WALL_BANNERS.put(Colors.MAGENTA, Blocks.MAGENTA_WALL_BANNER);
        WALL_BANNERS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_WALL_BANNER);
        WALL_BANNERS.put(Colors.YELLOW, Blocks.YELLOW_WALL_BANNER);
        WALL_BANNERS.put(Colors.LIME, Blocks.LIME_WALL_BANNER);
        WALL_BANNERS.put(Colors.PINK, Blocks.PINK_WALL_BANNER);
        WALL_BANNERS.put(Colors.GRAY, Blocks.GRAY_WALL_BANNER);
        WALL_BANNERS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_WALL_BANNER);
        WALL_BANNERS.put(Colors.CYAN, Blocks.CYAN_WALL_BANNER);
        WALL_BANNERS.put(Colors.PURPLE, Blocks.PURPLE_WALL_BANNER);
        WALL_BANNERS.put(Colors.BLUE, Blocks.BLUE_WALL_BANNER);
        WALL_BANNERS.put(Colors.BROWN, Blocks.BROWN_WALL_BANNER);
        WALL_BANNERS.put(Colors.GREEN, Blocks.GREEN_WALL_BANNER);
        WALL_BANNERS.put(Colors.RED, Blocks.RED_WALL_BANNER);
        WALL_BANNERS.put(Colors.BLACK, Blocks.BLACK_WALL_BANNER);
    }
}
