package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.ObjectImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import pl.panszelescik.colorize.common.handler.*;
import pl.panszelescik.colorize.common.handler.moss.*;
import pl.panszelescik.colorize.common.recipes.ColorizeRecipe;

import java.util.List;
import java.util.Optional;

public abstract class ColorizeEventHandler {

    public static ColorizeEventHandler INSTANCE;
    public static ColorizeConfig CONFIG;
    private final ObjectImmutableList<BaseBlockHandler> handlers;

    public ColorizeEventHandler(ColorizeConfig config) {
        INSTANCE = this;
        CONFIG = config;

        this.handlers = ObjectImmutableList.of(
                new BannerBlockHandler(),
                new BedBlockHandler(),
                new CandleBlockHandler(),
                new CandleCakeBlockHandler(),
                new CarpetBlockHandler(),
                new ConcreteBlockHandler(),
                new ConcretePowderBlockHandler(),
                new GlazedTerracottaBlockHandler(),
                new ShulkerBoxHandler(),
                new StainedGlassBlockHandler(),
                new StainedGlassPaneBlockHandler(),
                new TerracottaBlockHandler(),
                new WallBannerBlockHandler(),
                new WoolBlockHandler(),

                new MossyCobblestoneHandler(),
                new MossyCobblestoneSlabHandler(),
                new MossyCobblestoneStairsHandler(),
                new MossyCobblestoneWallHandler(),
                new MossyStoneBricksHandler(),
                new MossyStoneBrickSlabHandler(),
                new MossyStoneBrickStairsHandler(),
                new MossyStoneBrickWallHandler()
        );
    }

    public boolean handle(Player player, Level level, InteractionHand hand, BlockPos pos) {
        if (this.isForge() && level.isClientSide) {
            return false;
        }

        var stack = player.getItemInHand(hand);
        var state = level.getBlockState(pos);
        for (var handler : handlers) {
            if (handler.isDisabled()) {
                continue;
            }

            if (handler.requireSneaking() && !player.isShiftKeyDown()) {
                continue;
            }

            if (handler.handle(level, pos, state, stack, player)) {
                return true;
            }
        }

        return false;
    }

    protected Optional<Colors> getDyeColor(ItemStack stack) {
        if (stack.getItem() instanceof DyeItem dyeStack) {
            return Optional.of(Colors.getByDyeColor(dyeStack.getDyeColor()));
        }
        return Optional.empty();
    }

    public abstract Ingredient getColorIngredient(Colors color);

    public List<ColorizeRecipe> getRecipes() {
        return this.handlers
                .stream()
                .flatMap(BaseBlockHandler::getRecipes)
                .collect(ObjectImmutableList.toList());
    }

    public boolean isForge() {
        return false;
    }
}
