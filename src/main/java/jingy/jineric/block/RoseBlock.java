package jingy.jineric.block;

import net.minecraft.block.FlowerBlock;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;

public class RoseBlock extends FlowerBlock {
	public RoseBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
		super(stewEffect, effectLengthInSeconds, settings);
	}
	
	public RoseBlock(SuspiciousStewEffectsComponent stewEffects, Settings settings) {
		super(stewEffects, settings);
	}
}
