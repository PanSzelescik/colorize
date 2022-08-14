package pl.panszelescik.colorize.common.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractBannerBlockHandler<B extends AbstractBannerBlock> extends BaseBlockHandler<B> {

    @Override
    protected boolean replace(Level level, BlockPos pos, BlockState state, ItemStack stack, DyeColor newColor) {
        var blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BannerBlockEntity bannerBlockEntity) {
            var tag = bannerBlockEntity.getUpdateTag();

            level.removeBlock(pos, false);

            var newBlock = this.getNewBlock(newColor);
            level.setBlock(pos, newBlock.withPropertiesOf(state), 0);

            var newBlockEntity = level.getBlockEntity(pos);
            if (newBlockEntity instanceof BannerBlockEntity newBannerBlockEntity) {
                newBannerBlockEntity.load(tag);
                newBannerBlockEntity.setChanged();
                return true;
            }
        }

        return false;
    }
}
