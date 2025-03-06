package jingy.jineric.mixin.access;

import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LeavesParticle.class)
public interface LeavesParticleAccess {
	
	@Invoker("<init>")
	static LeavesParticle invokeInit(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float f, float g, boolean bl, boolean bl2, float h, float i) {
		throw new IllegalStateException("Could not invoke <init>() in LeavesParticle!");
	}
}
