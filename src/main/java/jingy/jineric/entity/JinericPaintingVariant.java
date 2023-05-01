package jingy.jineric.entity;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JinericPaintingVariant {
   public static final PaintingVariant KROMER = register("kromer", 64, 32);
   public static final PaintingVariant KEY_GEN = register("key_gen", 64, 32);
   /**
    * 'Peaceful Farm' by Adam.
    */
   public static final PaintingVariant PEACEFUL_FARM = register("peaceful_farm", 16, 16);

   private static PaintingVariant register(String id, int width, int height) {
      return Registry.register(Registries.PAINTING_VARIANT, new Identifier(JinericMain.MOD_ID, id), new PaintingVariant(width, height));
   }

   public static void registerPaintingMotives() {
   }
}
