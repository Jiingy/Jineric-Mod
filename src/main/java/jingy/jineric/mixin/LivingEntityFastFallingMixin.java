package jingy.jineric.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LivingEntity.class)
public abstract class LivingEntityFastFallingMixin extends Entity {
	public LivingEntityFastFallingMixin(EntityType<?> type, World world) {
		super(type, world);
	}
	
	@Shadow
	public abstract boolean hasStatusEffect(RegistryEntry<StatusEffect> effect);

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
