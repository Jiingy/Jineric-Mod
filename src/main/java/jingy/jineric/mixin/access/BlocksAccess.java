package jingy.jineric.mixin.access;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Blocks.class)
public interface BlocksAccess {
	
	@Invoker("copyLootTable")
	static AbstractBlock.Settings copyLootTable(Block block, boolean copyTranslationKey) {
		throw new IllegalStateException("Could not invoke <init>() in LeavesParticle!");
	}
}
