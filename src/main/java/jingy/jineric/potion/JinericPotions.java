package jingy.jineric.potion;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public class JinericPotions {
	public static final RegistryEntry<Potion> GLOWING = register("glowing", new Potion("glowing", new StatusEffectInstance(
			StatusEffects.GLOWING, 3600)));
	
	public static final RegistryEntry<Potion> LONG_GLOWING = register("long_glowing", new Potion("glowing", new StatusEffectInstance(
			StatusEffects.GLOWING, 9600)));
	
	public static final RegistryEntry<Potion> DARKNESS = register("darkness", new Potion("darkness", new StatusEffectInstance(
			StatusEffects.DARKNESS, 2160)));
	
	public static final RegistryEntry<Potion> LONG_DARKNESS = register("long_darkness", new Potion("darkness", new StatusEffectInstance(
			StatusEffects.DARKNESS, 5760)));
	
	public static RegistryEntry<Potion> register(String id, Potion potion) {
		return Registry.registerReference(Registries.POTION, JinericMain.ofJineric(id), potion);
	}
	
	public static void initialize() {
	}
}
