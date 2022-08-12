package pl.panszelescik.bedcolorer.common;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BedPart;
import org.jetbrains.annotations.Nullable;

public class BedColorerBaseHandler {

    public boolean handle(Player player, Level level, InteractionHand hand, BlockPos pos) {
        if (level.isClientSide) {
            return false;
        }

        var stack = player.getItemInHand(hand);
        var color = this.getDyeColor(stack);

        if (color == null) {
            return false;
        }

        var blockState = level.getBlockState(pos);
        var block = blockState.getBlock();

        if (block instanceof BedBlock bedBlock) {
            if (bedBlock.getColor() == color) {
                return false;
            }

            var part = blockState.getValue(BedBlock.PART);
            var direction = blockState.getValue(BedBlock.FACING);
            var pos2 = pos.relative(part == BedPart.FOOT ? direction : direction.getOpposite());

            var footPos = part == BedPart.FOOT ? pos : pos2;
            var headPos = part == BedPart.FOOT ? pos2 : pos;

            var footBlockState = level.getBlockState(footPos);
            var headBlockState = level.getBlockState(headPos);

            level.removeBlock(headPos, false);
            level.removeBlock(footPos, false);

            var newBedBlock = this.getBedBlock(color);
            level.setBlock(footPos, newBedBlock.withPropertiesOf(footBlockState), 0);
            level.setBlock(headPos, newBedBlock.withPropertiesOf(headBlockState), 0);

            stack.shrink(1);

            return true;
        }

        return false;
    }

    protected @Nullable DyeColor getDyeColor(ItemStack stack) {
        if (stack.getItem() instanceof DyeItem dyeStack) {
            return dyeStack.getDyeColor();
        }
        return null;
    }

    private Block getBedBlock(DyeColor color) {
        return switch (color) {
            case WHITE -> Blocks.WHITE_BED;
            case ORANGE -> Blocks.ORANGE_BED;
            case MAGENTA -> Blocks.MAGENTA_BED;
            case LIGHT_BLUE -> Blocks.LIGHT_BLUE_BED;
            case YELLOW -> Blocks.YELLOW_BED;
            case LIME -> Blocks.LIME_BED;
            case PINK -> Blocks.PINK_BED;
            case GRAY -> Blocks.GRAY_BED;
            case LIGHT_GRAY -> Blocks.LIGHT_GRAY_BED;
            case CYAN -> Blocks.CYAN_BED;
            case PURPLE -> Blocks.PURPLE_BED;
            case BLUE -> Blocks.BLUE_BED;
            case BROWN -> Blocks.BROWN_BED;
            case GREEN -> Blocks.GREEN_BED;
            case RED -> Blocks.RED_BED;
            case BLACK -> Blocks.BLACK_BED;
        };
    }
}
