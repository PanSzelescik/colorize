package pl.panszelescik.colorize.common.api;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

public abstract class MaterialBlockHandler extends BaseBlockHandler<Block> {

    private final Object2ObjectOpenHashMap<Colors, Block> blocks;

    protected MaterialBlockHandler(Object2ObjectOpenHashMap<Colors, Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    protected @Nullable Block getOldBlock(BlockState state) {
        var block = state.getBlock();
        return this.blocks.containsValue(block) ? block : null;
    }

    @Override
    protected @Nullable Colors getOldColor(BlockState state, Block block) {
        return this.getColorFromMaterial(state.getMapColor(null, null));
    }

    @Override
    protected Block getNewBlock(Colors color) {
        return this.blocks.get(color);
    }

    protected @Nullable Colors getColorFromMaterial(MaterialColor materialColor) {
        return Colors.getByMaterialColor(materialColor);
    }
}
