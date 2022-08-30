package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.handler.*;
import pl.panszelescik.colorize.common.handler.moss.*;

public abstract class ColorizeEventHandler {

    public static ColorizeEventHandler INSTANCE;
    public static ColorizeConfig CONFIG;
    private final ObjectArrayList<BaseBlockHandler> handlers = new ObjectArrayList<>();

    public ColorizeEventHandler(ColorizeConfig config) {
        INSTANCE = this;
        CONFIG = config;

        this.handlers.add(new BannerBlockHandler());
        this.handlers.add(new BedBlockHandler());
        this.handlers.add(new CandleBlockHandler());
        this.handlers.add(new CarpetBlockHandler());
        this.handlers.add(new ConcreteBlockHandler());
        this.handlers.add(new ConcretePowderBlockHandler());
        this.handlers.add(new GlazedTerracottaBlockHandler());
        this.handlers.add(new ShulkerBoxHandler());
        this.handlers.add(new StainedGlassBlockHandler());
        this.handlers.add(new StainedGlassPaneBlockHandler());
        this.handlers.add(new TerracottaBlockHandler());
        this.handlers.add(new WallBannerBlockHandler());
        this.handlers.add(new WoolBlockHandler());

        this.handlers.add(new MossyCobblestoneHandler());
        this.handlers.add(new MossyCobblestoneSlabHandler());
        this.handlers.add(new MossyCobblestoneStairsHandler());
        this.handlers.add(new MossyCobblestoneWallHandler());
        this.handlers.add(new MossyStoneBricksHandler());
        this.handlers.add(new MossyStoneBrickSlabHandler());
        this.handlers.add(new MossyStoneBrickStairsHandler());
        this.handlers.add(new MossyStoneBrickWallHandler());
    }

    public boolean handle(Player player, Level level, InteractionHand hand, BlockPos pos) {
        var stack = player.getItemInHand(hand);
        var state = level.getBlockState(pos);
        for (var handler : handlers) {
            if (!handler.isEnabled()) {
                continue;
            }

            if (handler.requireSneaking() && !player.isShiftKeyDown()) {
                continue;
            }

            if (handler.handle(level, pos, state, stack)) {
                return true;
            }
        }

        return false;
    }

    protected @Nullable Colors getDyeColor(ItemStack stack) {
        if (stack.getItem() instanceof DyeItem dyeStack) {
            return Colors.getByDyeColor(dyeStack.getDyeColor());
        }
        return null;
    }
}
