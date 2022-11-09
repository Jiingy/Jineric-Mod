package jingy.jineric.sound;

import jingy.jineric.base.JinericMain;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericSoundEvents {

   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_BREAK = register("block.soul_sandstone_block.break");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_FALL = register("block.soul_sandstone.fall");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_HIT = register("block.soul_sandstone.hit");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_PLACE = register("block.soul_sandstone.place");
   public static final SoundEvent BLOCK_SOUL_SANDSTONE_BLOCK_STEP = register("block.soul_sandstone.step");

   private static SoundEvent register(String id) {
      return Registry.register(Registry.SOUND_EVENT, new Identifier(JinericMain.MOD_ID, id), new SoundEvent(new Identifier(id)));
   }
}
