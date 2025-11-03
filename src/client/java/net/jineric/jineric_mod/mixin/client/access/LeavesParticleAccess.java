package net.jineric.jineric_mod.mixin.client.access;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Environment(EnvType.CLIENT)
@Mixin(LeavesParticle.class)
public interface LeavesParticleAccess {
	
	@Invoker("<init>")
	static LeavesParticle invokeInit(ClientWorld world, double x, double y, double z, Sprite sprite, float gravity, float f, boolean bl, boolean bl2, float size, float initialYVelocity) {
		throw new IllegalStateException("Could not invoke <init>() in LeavesParticle!");
	}
}
