package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.handler.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ColorizeEventHandler {

    public static final ObjectArrayList<DyeColor> DYE_COLORS = Arrays.stream(DyeColor.values()).collect(Collectors.toCollection(ObjectArrayList::new));
    private final ObjectArrayList<BaseBlockHandler<?>> handlers = new ObjectArrayList<>();

    public ColorizeEventHandler() {
        this.registerHandler(new BannerBlockHandler());
        this.registerHandler(new BedBlockHandler());
        this.registerHandler(new CandleBlockHandler());
        this.registerHandler(new CarpetBlockHandler());
        this.registerHandler(new ConcreteBlockHandler());
        this.registerHandler(new ConcretePowderBlockHandler());
        this.registerHandler(new ShulkerBoxHandler());
        this.registerHandler(new StainedGlassBlockHandler());
        this.registerHandler(new StainedGlassPaneBlockHandler());
        this.registerHandler(new TerracottaBlockHandler());
        this.registerHandler(new TerracottaGlazedBlockHandler());
        this.registerHandler(new WallBannerBlockHandler());
        this.registerHandler(new WoolBlockHandler());
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
            if (handler.handle(level, pos, state, stack, color)) {
                return true;
            }
        }

        return false;
    }

    protected @Nullable DyeColor getDyeColor(ItemStack stack) {
        if (stack.getItem() instanceof DyeItem dyeStack) {
            return dyeStack.getDyeColor();
        }
        return null;
    }

    public void registerHandler(BaseBlockHandler<?> handler) {
        this.handlers.add(handler);
    }
}
