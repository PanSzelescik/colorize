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
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

import java.util.stream.Stream;

public class WallBannerBlockHandler extends BaseBlockEntityHandler<BannerBlockEntity> {

    public WallBannerBlockHandler() {
        super("banner", WALL_BANNERS, BannerBlockEntity.class);
    }

    @Override
    protected @NotNull SoundEvent getSound() {
        return SoundEvents.WOOL_HIT;
    }

    @Override
    public @NotNull Stream<ColorizeRecipe> getRecipes() {
        return Stream.empty(); // Don't duplicate recipes
    }

    private static final Object2ObjectMap<RightClicker, Block> WALL_BANNERS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.putColors(Blocks.WALL_BANNER);

        WALL_BANNERS = map.freeze();
    }
}
