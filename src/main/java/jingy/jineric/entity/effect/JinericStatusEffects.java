package jingy.jineric.entity.effect;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class JinericStatusEffects {
	public static final MobEffect THORNS = new ThornsStatusEffect(MobEffectCategory.HARMFUL, 0);
	public static final MobEffect FAST_FALLING = new FastFallingEffect(MobEffectCategory.HARMFUL, 0);
	
	public static void registerStatusEffects() {
		Registry.register(BuiltInRegistries.MOB_EFFECT, JinericMain.ofJineric("thorns"), THORNS);
		Registry.register(BuiltInRegistries.MOB_EFFECT, JinericMain.ofJineric("fast_falling"), FAST_FALLING);
	}
}
