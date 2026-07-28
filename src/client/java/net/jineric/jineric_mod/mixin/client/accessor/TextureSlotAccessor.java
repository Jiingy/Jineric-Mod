package net.jineric.jineric_mod.mixin.client.accessor;

import net.minecraft.client.data.models.model.TextureSlot;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TextureSlot.class)
public interface TextureSlotAccessor {
	
	@Invoker("<init>")
	static TextureSlot invokeInit(String name, @Nullable TextureSlot parent) {
		throw new IllegalStateException("Could not invoke <init> in TextureSlot!");
	}
}
