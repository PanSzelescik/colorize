package pl.panszelescik.colorize.common.handler;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.gameevent.GameEvent;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.WoollyBlockHandler;

public class BedBlockHandler extends WoollyBlockHandler {

    public BedBlockHandler() {
        super("bed", BEDS);
    }

    @Override
    public boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, BlockState newState, Player player) {
        var part = state.getValue(BedBlock.PART);
        var direction = state.getValue(BedBlock.FACING);
        var pos2 = pos.relative(part == BedPart.FOOT ? direction : direction.getOpposite());

        var footPos = part == BedPart.FOOT ? pos : pos2;
        var headPos = part == BedPart.FOOT ? pos2 : pos;

        var footBlockState = level.getBlockState(footPos);
        var headBlockState = level.getBlockState(headPos);

        level.removeBlock(headPos, false);
        level.removeBlock(footPos, false);

        level.setBlock(footPos, newState.getBlock().withPropertiesOf(footBlockState), 0);
        level.setBlock(headPos, newState.getBlock().withPropertiesOf(headBlockState), 0);

        level.gameEvent(player, GameEvent.BLOCK_CHANGE, headPos);
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, footPos);

        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));

        return true;
    }

    private static final RightClicker2BlockMap BEDS = new RightClicker2BlockMap(16);

    static {
        BEDS.put(Colors.WHITE, Blocks.WHITE_BED);
        BEDS.put(Colors.ORANGE, Blocks.ORANGE_BED);
        BEDS.put(Colors.MAGENTA, Blocks.MAGENTA_BED);
        BEDS.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_BED);
        BEDS.put(Colors.YELLOW, Blocks.YELLOW_BED);
        BEDS.put(Colors.LIME, Blocks.LIME_BED);
        BEDS.put(Colors.PINK, Blocks.PINK_BED);
        BEDS.put(Colors.GRAY, Blocks.GRAY_BED);
        BEDS.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_BED);
        BEDS.put(Colors.CYAN, Blocks.CYAN_BED);
        BEDS.put(Colors.PURPLE, Blocks.PURPLE_BED);
        BEDS.put(Colors.BLUE, Blocks.BLUE_BED);
        BEDS.put(Colors.BROWN, Blocks.BROWN_BED);
        BEDS.put(Colors.GREEN, Blocks.GREEN_BED);
        BEDS.put(Colors.RED, Blocks.RED_BED);
        BEDS.put(Colors.BLACK, Blocks.BLACK_BED);
    }
}
