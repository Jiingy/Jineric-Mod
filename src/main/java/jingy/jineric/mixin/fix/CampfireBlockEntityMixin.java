package jingy.jineric.mixin.fix;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CampfireBlockEntity.class)
public abstract class CampfireBlockEntityMixin extends BlockEntity {
	
	public CampfireBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}
	
}
