package jingy.jineric.mixin.access;

import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(BlockFamilies.class)
public interface BaseBlocksToFamiliesAccess {

    @Accessor("BASE_BLOCKS_TO_FAMILIES")
    static Map<Block, BlockFamily> getBlockFamilies() {
        throw new AssertionError();
    }
}
