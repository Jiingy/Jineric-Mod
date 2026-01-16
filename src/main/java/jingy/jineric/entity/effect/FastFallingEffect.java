package jingy.jineric.entity.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FastFallingEffect extends MobEffect {
	protected FastFallingEffect(MobEffectCategory category, int color) {
		super(MobEffectCategory.HARMFUL, color);
	}
}
