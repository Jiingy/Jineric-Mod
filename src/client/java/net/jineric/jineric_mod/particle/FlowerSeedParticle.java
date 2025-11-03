package net.jineric.jineric_mod.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.BillboardParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;

@Environment(EnvType.CLIENT)
public class FlowerSeedParticle extends BillboardParticle {
	private final float randomNextFloat;
	private final float field_55127;
	private double field_55130;
	private double field_55131;
	
	public FlowerSeedParticle(ClientWorld clientWorld, double x, double y, double z, Sprite sprite, double velocityX, double velocityY, double velocityZ) {
		super(clientWorld, x, y, z, velocityX, velocityY, velocityZ, sprite);
		this.randomNextFloat = this.random.nextFloat();
		this.field_55127 = 2.0F;
		this.field_55130 = Math.cos(Math.toRadians(this.randomNextFloat * 60.0F)) * this.field_55127;
		this.field_55131 = Math.sin(Math.toRadians(this.randomNextFloat * 60.0F)) * this.field_55127;
		this.maxAge = 300;
		this.velocityMultiplier = 0.9F;
		this.velocityY = 0.02;
		this.scale = (this.random.nextBoolean() ? 0.05F : 0.075F);
	}
	
	@Override
	public void tick() {
		this.lastX = this.x;
		this.lastY = this.y;
		this.lastZ = this.z;
		
		if (this.maxAge-- <= 0) {
			this.markDead();
		}
		
		if (!this.dead) {
			float ageUsed = 300 - this.maxAge;
			float ageUsedPercent = Math.min(ageUsed / 300.0F, 1.0F);
			double d = 0.0;
			double e = 0.0;
			d += this.field_55130 * Math.pow(ageUsedPercent, 1.25);
			e += this.field_55131 * Math.pow(ageUsedPercent, 1.25);
//			System.out.println(d);

			this.velocityX += d * 0.0025F;
			this.velocityZ += e * 0.0025F;
			this.velocityY = this.velocityY - this.gravityStrength;
			this.move(this.velocityX, this.velocityY, this.velocityZ);
			if (this.onGround || this.age > 299) {
				this.markDead();
			}

			if (!this.dead) {
				this.velocityX = this.velocityX * this.velocityMultiplier;
				this.velocityY = this.velocityY * this.velocityMultiplier;
				this.velocityZ = this.velocityZ * this.velocityMultiplier;
			}
		}
	}
	
	@Override
	protected RenderType getRenderType() {
		return RenderType.PARTICLE_ATLAS_OPAQUE;
	}
	
	@Environment(EnvType.CLIENT)
	public static class Factory implements ParticleFactory<SimpleParticleType> {
		private final SpriteProvider spriteProvider;
		
		public Factory(SpriteProvider spriteProvider) {
			this.spriteProvider = spriteProvider;
		}
		
		@Override
		public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ, Random random) {
			return new FlowerSeedParticle(world, x, y, z, this.spriteProvider.getSprite(random), velocityX, velocityY, velocityZ);
		}
	}
}
