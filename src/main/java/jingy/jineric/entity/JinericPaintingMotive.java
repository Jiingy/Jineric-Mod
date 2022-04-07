package jingy.jineric.entity;

import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JinericPaintingMotive extends PaintingMotive {

   public static final PaintingMotive KROMER = register("kromer", 64, 32);
   public static final PaintingMotive KEY_GEN = register("key_gen", 64, 32);

   private static PaintingMotive register(String name, int width, int height) {
      return Registry.register(Registry.PAINTING_MOTIVE, new Identifier("jineric", name), new PaintingMotive(width, height));
   }

   public JinericPaintingMotive(int width, int height) {
      super(width, height);
   }

   public static void init() {
   }
}
