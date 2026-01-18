package jingy.jineric.entity;

import jingy.jineric.base.JinericMain;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import java.util.Optional;

public class JinericPaintingVariants {
	public static final ResourceKey<PaintingVariant> KROMER = keyOf("kromer");
	public static final ResourceKey<PaintingVariant> KEY_GEN = keyOf("key_gen");
	public static final ResourceKey<PaintingVariant> PEACEFUL_FARM = keyOf("peaceful_farm");
	
	public static void bootstrap(BootstrapContext<PaintingVariant> registry) {
		register(registry, KROMER, 4, 2);
		register(registry, KEY_GEN, 4, 2);
		register(registry, PEACEFUL_FARM, 1, 1, true);
	}
	
	private static void register(BootstrapContext<PaintingVariant> registry, ResourceKey<PaintingVariant> key, int width, int height) {
		register(registry, key, width, height, true);
	}
	
	private static void register(BootstrapContext<PaintingVariant> registry, ResourceKey<PaintingVariant> key, int width, int height, boolean hasAuthor) {
		registry.register(
				key,
				new PaintingVariant(
						width, height,
						key.identifier(),
						Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW)),
						hasAuthor ? Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY)) : Optional.empty()
				)
		);
	}
	
	private static ResourceKey<PaintingVariant> keyOf(String id) {
		return ResourceKey.create(Registries.PAINTING_VARIANT, JinericMain.ofJineric(id));
	}
}
