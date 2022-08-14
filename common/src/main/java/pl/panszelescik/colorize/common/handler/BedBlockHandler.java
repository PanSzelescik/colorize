package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import org.jetbrains.annotations.Nullable;
import pl.panszelescik.colorize.common.api.BaseBlockHandler;

public class BedBlockHandler extends BaseBlockHandler<BedBlock> {

    @Override
    protected @Nullable BedBlock getOldBlock(BlockState state) {
        var block = state.getBlock();
        if (block instanceof BedBlock bedBlock && BEDS.containsValue(bedBlock)) {
            return bedBlock;
        }
        return null;
    }

    @Override
    public @Nullable DyeColor getOldColor(BlockState state, BedBlock block) {
        return block.getColor();
    }

    @Override
    public BedBlock getNewBlock(DyeColor color) {
        return BEDS.get(color);
    }

    @Override
    public boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, DyeColor newColor) {
        var part = state.getValue(BedBlock.PART);
        var direction = state.getValue(BedBlock.FACING);
        var pos2 = pos.relative(part == BedPart.FOOT ? direction : direction.getOpposite());

        var footPos = part == BedPart.FOOT ? pos : pos2;
        var headPos = part == BedPart.FOOT ? pos2 : pos;

        var footBlockState = level.getBlockState(footPos);
        var headBlockState = level.getBlockState(headPos);

        level.removeBlock(headPos, false);
        level.removeBlock(footPos, false);

        var newBlock = this.getNewBlock(newColor);
        level.setBlock(footPos, newBlock.withPropertiesOf(footBlockState), 0);
        level.setBlock(headPos, newBlock.withPropertiesOf(headBlockState), 0);

        return true;
    }

    private static final Object2ObjectOpenHashMap<DyeColor, BedBlock> BEDS = new Object2ObjectOpenHashMap<>(16) {{
        put(DyeColor.WHITE, (BedBlock) Blocks.WHITE_BED);
        put(DyeColor.ORANGE, (BedBlock) Blocks.ORANGE_BED);
        put(DyeColor.MAGENTA, (BedBlock) Blocks.MAGENTA_BED);
        put(DyeColor.LIGHT_BLUE, (BedBlock) Blocks.LIGHT_BLUE_BED);
        put(DyeColor.YELLOW, (BedBlock) Blocks.YELLOW_BED);
        put(DyeColor.LIME, (BedBlock) Blocks.LIME_BED);
        put(DyeColor.PINK, (BedBlock) Blocks.PINK_BED);
        put(DyeColor.GRAY, (BedBlock) Blocks.GRAY_BED);
        put(DyeColor.LIGHT_GRAY, (BedBlock) Blocks.LIGHT_GRAY_BED);
        put(DyeColor.CYAN, (BedBlock) Blocks.CYAN_BED);
        put(DyeColor.PURPLE, (BedBlock) Blocks.PURPLE_BED);
        put(DyeColor.BLUE, (BedBlock) Blocks.BLUE_BED);
        put(DyeColor.BROWN, (BedBlock) Blocks.BROWN_BED);
        put(DyeColor.GREEN, (BedBlock) Blocks.GREEN_BED);
        put(DyeColor.RED, (BedBlock) Blocks.RED_BED);
        put(DyeColor.BLACK, (BedBlock) Blocks.BLACK_BED);
    }};
}
