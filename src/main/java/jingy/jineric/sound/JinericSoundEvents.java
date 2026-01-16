package jingy.jineric.sound;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class JinericSoundEvents {
	public static SoundEvent BLOCK_SOUL_SANDSTONE_PLACE = register("block.soul_sandstone.place");
	public static SoundEvent BLOCK_SOUL_SANDSTONE_STEP = register("block.soul_sandstone.step");
	
	private static SoundEvent register(String name) {
		Identifier id = JinericMain.ofJineric(name);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
	}
}
