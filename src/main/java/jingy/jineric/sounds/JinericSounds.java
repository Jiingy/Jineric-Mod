package jingy.jineric.sounds;

import jingy.jineric.Jineric;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericSounds {

	public static final Identifier SOUL_SANDSTONE_ID = Jineric.id("soul_sandstone");
	public static SoundEvent SOUL_SANDSTONE_INTERACT = new SoundEvent(SOUL_SANDSTONE_ID);

	public static final BlockSoundGroup SOUL_SANDSTONE = new BlockSoundGroup(
			0.75f,
			1,
			SOUL_SANDSTONE_INTERACT,
			SOUL_SANDSTONE_INTERACT,
			SOUL_SANDSTONE_INTERACT,
			SOUL_SANDSTONE_INTERACT,
			SOUL_SANDSTONE_INTERACT);

	public static void init() {
		Registry.register(Registry.SOUND_EVENT, JinericSounds.SOUL_SANDSTONE_ID, SOUL_SANDSTONE_INTERACT);

	}
}
