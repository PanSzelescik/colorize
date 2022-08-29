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

public abstract class ColorizeEventHandler {

    private final ObjectArrayList<BaseBlockHandler<?>> handlers = new ObjectArrayList<>();

    public ColorizeEventHandler(ColorizeConfig config) {
        this.registerHandler(new BannerBlockHandler(config));
        this.registerHandler(new BedBlockHandler(config));
        this.registerHandler(new CandleBlockHandler(config));
        this.registerHandler(new CarpetBlockHandler(config));
        this.registerHandler(new ConcreteBlockHandler(config));
        this.registerHandler(new ConcretePowderBlockHandler(config));
        this.registerHandler(new GlazedTerracottaBlockHandler(config));
        this.registerHandler(new ShulkerBoxHandler(config));
        this.registerHandler(new StainedGlassBlockHandler(config));
        this.registerHandler(new StainedGlassPaneBlockHandler(config));
        this.registerHandler(new TerracottaBlockHandler(config));
        this.registerHandler(new WallBannerBlockHandler(config));
        this.registerHandler(new WoolBlockHandler(config));
    }

    public boolean handle(Player player, Level level, InteractionHand hand, BlockPos pos) {
        if (level.isClientSide) {
            return false;
        }

        var stack = player.getItemInHand(hand);
        var color = this.getDyeColor(stack);
        if (color == null) {
            return false;
        }

        var state = level.getBlockState(pos);
        for (var handler : handlers) {
            if (!handler.isEnabled()) {
                continue;
            }

            if (handler.requireSneaking() && !player.isShiftKeyDown()) {
                continue;
            }

            if (handler.handle(level, pos, state, stack, color)) {
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

    public void registerHandler(BaseBlockHandler<?> handler) {
        this.handlers.add(handler);
    }
}
