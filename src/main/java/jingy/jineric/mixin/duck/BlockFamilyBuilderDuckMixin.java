package jingy.jineric.mixin.duck;

import jingy.jineric.access.BlockFamilyBuilderDuckAccess;
import jingy.jineric.access.BlockFamilyDuckAccess;
import net.minecraft.data.family.BlockFamily;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockFamily.Builder.class)
public abstract class BlockFamilyBuilderDuckMixin implements BlockFamilyBuilderDuckAccess {
	@Shadow @Final private BlockFamily family;
	
	@Override
	public BlockFamily.Builder jineric_mod$modded() {
		((BlockFamilyDuckAccess)this.family).jineric_mod$setModded(true);
		return (BlockFamily.Builder)(Object)this;
	}
}
