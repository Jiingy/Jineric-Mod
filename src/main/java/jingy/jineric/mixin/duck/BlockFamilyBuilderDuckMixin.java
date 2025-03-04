package jingy.jineric.mixin.duck;

import jingy.jineric.access.BlockFamilyBuilderDuckAccess;
import jingy.jineric.data.family.JinericBlockFamilyVariants;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockFamily.Builder.class)
public abstract class BlockFamilyBuilderDuckMixin implements BlockFamilyBuilderDuckAccess {
	@Shadow @Final private BlockFamily family;
	
	@Override
	public BlockFamily.Builder jineric_mod$modded() {
		this.family.jineric_mod$setModded(true);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder jineric_mod$pillar(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.PILLAR, block);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder jineric_mod$bookshelf(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.BOOKSHELF, block);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder jineric_mod$chest(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.CHEST, block);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder jineric_mod$trappedChest(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.TRAPPED_CHEST, block);
		return (BlockFamily.Builder)(Object)this;
	}
	
	@Override
	public BlockFamily.Builder jineric_mod$ladder(Block block) {
		this.family.getVariants().put(JinericBlockFamilyVariants.LADDER, block);
		return (BlockFamily.Builder)(Object)this;
	}
}
