package jingy.jineric.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class FlowerSeedParticle extends SpriteBillboardParticle {
	protected FlowerSeedParticle(ClientWorld clientWorld, double x, double y, double z) {
		super(clientWorld, x, y, z);
	}
	
	public FlowerSeedParticle(ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
		super(clientWorld, x, y, z, velocityX, velocityY, velocityZ);
//		this.velocityX = 0d;
//		this.velocityY = 0d;
//		this.velocityZ = 0d;
		this.maxAge = 300;
		this.scale = this.random.nextFloat();
	}
	
	@Override
	public void tick() {
		System.out.println(this.random.nextFloat());
		this.prevPosX = this.x;
		this.prevPosY = this.y;
		this.prevPosZ = this.z;
		
		if (this.maxAge-- <= 0) {
			this.markDead();
		}
	}
	
	
	
	@Override
	public ParticleTextureSheet getType() {
		return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
	}
	
	@Environment(EnvType.CLIENT)
	public static class Factory implements ParticleFactory<SimpleParticleType> {
		private final SpriteProvider spriteProvider;
		
		public Factory(SpriteProvider spriteProvider) {
			this.spriteProvider = spriteProvider;
		}
		
		@Override
		public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
			FlowerSeedParticle seedParticle = new FlowerSeedParticle(world, x, y, z, velocityX, velocityY, velocityZ);
			seedParticle.setSprite(this.spriteProvider);
			return seedParticle;
		}
	}
}
