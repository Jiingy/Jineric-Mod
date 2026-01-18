package jingy.jineric.potion;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class JinericPotions {
	public static final Holder<Potion> GLOWING = register("glowing", new Potion("glowing", new MobEffectInstance(
			MobEffects.GLOWING, 3600)));
	
	public static final Holder<Potion> LONG_GLOWING = register("long_glowing", new Potion("glowing", new MobEffectInstance(
			MobEffects.GLOWING, 9600)));
	
	public static final Holder<Potion> DARKNESS = register("darkness", new Potion("darkness", new MobEffectInstance(
			MobEffects.DARKNESS, 2160)));
	
	public static final Holder<Potion> LONG_DARKNESS = register("long_darkness", new Potion("darkness", new MobEffectInstance(
			MobEffects.DARKNESS, 5760)));
	
	public static Holder<Potion> register(String id, Potion potion) {
		return Registry.registerForHolder(BuiltInRegistries.POTION, JinericMain.ofJineric(id), potion);
	}
	
	public static void initialize() {
	}
}
