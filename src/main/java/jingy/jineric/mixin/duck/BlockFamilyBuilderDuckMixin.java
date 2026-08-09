package jingy.jineric.mixin.duck;

import jingy.jineric.base.injected_interfaces.JmBlockFamilyBuilder;
import jingy.jineric.data.family.JinericBlockFamilyVariants;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockFamily.Builder.class)
public abstract class BlockFamilyBuilderDuckMixin implements JmBlockFamilyBuilder {
	@Shadow @Final private BlockFamily family;
	
	@Override
	public BlockFamily.Builder modded$Jineric() {
		this.family.setModded$jineric(true);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder bookshelf$jineric(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.BOOKSHELF, block);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder chest$jineric(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.CHEST, block);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder trappedChest$jineric(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.TRAPPED_CHEST, block);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder ladder$jineric(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.LADDER, block);
		return (BlockFamily.Builder)(Object)this;
	}
}
