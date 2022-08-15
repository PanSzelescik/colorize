package pl.panszelescik.colorize.common.api;

import net.minecraft.world.level.block.AbstractBannerBlock;
import net.minecraft.world.level.block.entity.BannerBlockEntity;

public abstract class AbstractBannerBlockHandler<B extends AbstractBannerBlock> extends BaseBlockEntityHandler<B, BannerBlockEntity> {

    public AbstractBannerBlockHandler() {
        super(BannerBlockEntity.class);
    }
}
