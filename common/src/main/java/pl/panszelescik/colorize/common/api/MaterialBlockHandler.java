package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

public abstract class MaterialBlockHandler extends BaseBlockHandler<Block> {

    private final Object2ObjectOpenHashMap<DyeColor, Block> blocks;
    private final Int2ObjectOpenHashMap<DyeColor> colors;

    protected MaterialBlockHandler(Object2ObjectOpenHashMap<DyeColor, Block> blocks, Int2ObjectOpenHashMap<DyeColor> colors) {
        this.blocks = blocks;
        this.colors = colors;
    }

    protected MaterialBlockHandler(Object2ObjectOpenHashMap<DyeColor, Block> blocks) {
        this(blocks, null);
    }

    @Override
    protected @Nullable Block getOldBlock(BlockState state) {
        var block = state.getBlock();
        return this.blocks.containsValue(block) ? block : null;
    }

    @Override
    protected @Nullable DyeColor getOldColor(BlockState state, Block block) {
        return this.getDyeFromMaterial(state.getMapColor(null, null));
    }

    @Override
    protected Block getNewBlock(DyeColor color) {
        return this.blocks.get(color);
    }

    protected @Nullable DyeColor getDyeFromMaterial(MaterialColor materialColor) {
        if (this.colors == null) {
            for (DyeColor color : ColorizeEventHandler.DYE_COLORS) {
                if (color.getMaterialColor() == materialColor) {
                    return color;
                }
            }
            return null;
        }
        return this.colors.get(materialColor.id);
    }
}
