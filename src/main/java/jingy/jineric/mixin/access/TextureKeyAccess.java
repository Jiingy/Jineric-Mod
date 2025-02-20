package jingy.jineric.mixin.access;

import net.minecraft.client.data.TextureKey;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TextureKey.class)
public interface TextureKeyAccess {
	
	@Invoker("<init>")
	static TextureKey initTextureKey(String name, @Nullable TextureKey parent) {
		throw new IllegalStateException("Could not invoke <init> in TextureKey!");
	}
}
