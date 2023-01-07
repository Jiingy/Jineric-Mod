package jingy.jineric.sound;

import jingy.jineric.base.JinericMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class JinericSoundEvents {

   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_BREAK = register("block.soul_sandstone_block.break");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_FALL = register("block.soul_sandstone.fall");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_HIT = register("block.soul_sandstone.hit");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_PLACE = register("block.soul_sandstone.place");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_STEP = register("block.soul_sandstone.step");

   private static SoundEvent register(String id) {
      return Registry.register(Registries.SOUND_EVENT, new Identifier(JinericMain.MOD_ID, id), SoundEvent.of(new Identifier(id)));
   }
}
