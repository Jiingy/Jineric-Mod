package jingy.jineric.entity;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Optional;

public class JinericPaintingVariants {
	public static final RegistryKey<PaintingVariant> KROMER = keyOf("kromer");
	public static final RegistryKey<PaintingVariant> KEY_GEN = keyOf("key_gen");
	public static final RegistryKey<PaintingVariant> PEACEFUL_FARM = keyOf("peaceful_farm");
	
	public static void bootstrap(Registerable<PaintingVariant> registry) {
		register(registry, KROMER, 4, 2);
		register(registry, KEY_GEN, 4, 2);
		register(registry, PEACEFUL_FARM, 1, 1, true);
	}
	
	private static void register(Registerable<PaintingVariant> registry, RegistryKey<PaintingVariant> key, int width, int height) {
		register(registry, key, width, height, true);
	}
	
	private static void register(Registerable<PaintingVariant> registry, RegistryKey<PaintingVariant> key, int width, int height, boolean hasAuthor) {
		registry.register(
				key,
				new PaintingVariant(
						width, height,
						key.getValue(),
						Optional.of(Text.translatable(key.getValue().toTranslationKey("painting", "title")).formatted(Formatting.YELLOW)),
						hasAuthor ? Optional.of(Text.translatable(key.getValue().toTranslationKey("painting", "author")).formatted(Formatting.GRAY)) : Optional.empty()
				)
		);
	}
	
	private static RegistryKey<PaintingVariant> keyOf(String id) {
		return RegistryKey.of(RegistryKeys.PAINTING_VARIANT, JinericMain.ofJineric(id));
	}
}
