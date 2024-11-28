package jingy.jineric.entity;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Optional;

//TODO: 1.21.3 WAS CAUSING CRASH
public class JinericPaintingVariants {
//   public static final RegistryKey<PaintingVariant> KROMER = of("kromer");
//   public static final RegistryKey<PaintingVariant> KEY_GEN = of("key_gen");
   /**
    * 'Peaceful Farm' by Adam.
    */
//   public static final RegistryKey<PaintingVariant> PEACEFUL_FARM = of("peaceful_farm");

   public static void bootstrap(Registerable<PaintingVariant> registry) {
//      register(registry, KROMER, 64, 32);
//      register(registry, KEY_GEN, 64, 32);
      //TODO: FIX AUTHOR IN TRANSLATION KEY
//      register(registry, PEACEFUL_FARM, 16, 16, true);
   }

   private static void register(Registerable<PaintingVariant> registry, RegistryKey<PaintingVariant> key, int width, int height) {
      register(registry, key, width, height, true);
   }

   private static void register(Registerable<PaintingVariant> registry, RegistryKey<PaintingVariant> key, int width, int height, boolean hasAuthor) {
      registry.register(
              key,
              new PaintingVariant(
                      width,
                      height,
                      key.getValue(),
                      Optional.of(Text.translatable(key.getValue().toTranslationKey("painting", "title")).formatted(Formatting.YELLOW)),
                      hasAuthor ? Optional.of(Text.translatable(key.getValue().toTranslationKey("painting", "author")).formatted(Formatting.GRAY)) : Optional.empty()
              )
      );
   }

   private static RegistryKey<PaintingVariant> of(String id) {
      return RegistryKey.of(RegistryKeys.PAINTING_VARIANT, JinericMain.ofJineric(id));
   }
}
