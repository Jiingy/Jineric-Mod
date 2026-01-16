package jingy.jineric.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityFastFallingMixin extends Entity {
	public LivingEntityFastFallingMixin(EntityType<?> type, Level world) {
		super(type, world);
	}
	
	@Shadow
	public abstract boolean hasEffect(Holder<MobEffect> effect);

//   @ModifyConstant(
//           method = "travel",
//           constant = @Constant(
//                   doubleValue = 0.08,
//                   ordinal = 0
//           )
//   )
//   private double jineric$alterTravel(double constant, Vec3d movementInput) {
//      boolean bl = getVelocity().y <= 0.0;
//      if (bl && hasStatusEffect(JinericStatusEffects.FAST_FALLING)) {
//         return 0.64;
//      } else {
//         return constant;
//      }
//   }
	// CHANGE TO ModifyExpressionValue?
	// DISCORD https://discord.com/channels/507304429255393322/807617700734042122/1069560661501296660
}
