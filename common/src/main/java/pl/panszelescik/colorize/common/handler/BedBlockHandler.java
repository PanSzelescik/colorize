package pl.panszelescik.colorize.common.handler;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import pl.panszelescik.colorize.common.api.Colors;
import pl.panszelescik.colorize.common.api.RightClicker;
import pl.panszelescik.colorize.common.api.RightClicker2BlockMap;
import pl.panszelescik.colorize.common.api.handler.WoollyBlockHandler;

public class BedBlockHandler extends WoollyBlockHandler {

    public BedBlockHandler() {
        super("bed", BEDS);
    }

    @Override
    public boolean replace(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull ItemStack stack, @NotNull BlockState newState, @NotNull Player player) {
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

    private static final Object2ObjectMap<RightClicker, Block> BEDS;

    static {
        var map = new RightClicker2BlockMap(16);

        map.put(Colors.WHITE, Blocks.WHITE_BED);
        map.put(Colors.ORANGE, Blocks.ORANGE_BED);
        map.put(Colors.MAGENTA, Blocks.MAGENTA_BED);
        map.put(Colors.LIGHT_BLUE, Blocks.LIGHT_BLUE_BED);
        map.put(Colors.YELLOW, Blocks.YELLOW_BED);
        map.put(Colors.LIME, Blocks.LIME_BED);
        map.put(Colors.PINK, Blocks.PINK_BED);
        map.put(Colors.GRAY, Blocks.GRAY_BED);
        map.put(Colors.LIGHT_GRAY, Blocks.LIGHT_GRAY_BED);
        map.put(Colors.CYAN, Blocks.CYAN_BED);
        map.put(Colors.PURPLE, Blocks.PURPLE_BED);
        map.put(Colors.BLUE, Blocks.BLUE_BED);
        map.put(Colors.BROWN, Blocks.BROWN_BED);
        map.put(Colors.GREEN, Blocks.GREEN_BED);
        map.put(Colors.RED, Blocks.RED_BED);
        map.put(Colors.BLACK, Blocks.BLACK_BED);

        BEDS = map.freeze();
    }
}
