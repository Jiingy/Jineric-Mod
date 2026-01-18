package jingy.jineric.mixin.add;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CampfireBlock.class)
public abstract class ScreenForCampfireBlockMixin extends BaseEntityBlock implements SimpleWaterloggedBlock {
	@Shadow public static boolean canLight(BlockState state) {
		return false;
	}
	
	protected ScreenForCampfireBlockMixin(Properties settings) {
		super(settings);
	}
	
	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if ((player.isHolding(itemStack -> itemStack.getItem() instanceof FlintAndSteelItem) || player.isHolding(Items.FIRE_CHARGE)) && canLight(state)) {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		} else {
			if (!level.isClientSide() && blockEntity instanceof CampfireBlockEntity campfireBlockEntity) {
				player.openMenu(campfireBlockEntity);
				player.awardStat(Stats.INTERACT_WITH_CAMPFIRE);
			}
		}
		return InteractionResult.SUCCESS;
	}
}
