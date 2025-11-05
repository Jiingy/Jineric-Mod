package jingy.jineric.mixin.add;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CampfireBlock.class)
public abstract class ScreenForCampfireBlockMixin extends BlockWithEntity implements Waterloggable {
	protected ScreenForCampfireBlockMixin(Settings settings) {
		super(settings);
	}
	
	//  IMPLEMENTED CLASS OVERRIDES
	@Override
	protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (!world.isClient() && blockEntity instanceof CampfireBlockEntity campfireBlockEntity) {
			player.openHandledScreen(campfireBlockEntity);
			player.incrementStat(Stats.INTERACT_WITH_CAMPFIRE);
		}
		return ActionResult.SUCCESS;
	}
}
