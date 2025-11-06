package jingy.jineric.data.generators.tag;

import jingy.jineric.tag.JinericEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JinericEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	public JinericEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		//  Non-farm animals which provide no value for killing, or are passive.
		this.valueLookupBuilder(JinericEntityTypeTags.LEVELS_WEAPON_NONE)
				.add(EntityType.ALLAY)
				.add(EntityType.ARMADILLO)
				.add(EntityType.AXOLOTL)
				.add(EntityType.BAT)
				.add(EntityType.BEE)
				.add(EntityType.CAMEL)
				.add(EntityType.CAT)
				.add(EntityType.DOLPHIN)
				.add(EntityType.DONKEY)
				.add(EntityType.FOX)
				.add(EntityType.FROG)
				.add(EntityType.GOAT)
				.add(EntityType.HORSE)
				.add(EntityType.LLAMA)
				.add(EntityType.MULE)
				.add(EntityType.OCELOT)
				.add(EntityType.PANDA)
				.add(EntityType.PARROT)
				.add(EntityType.POLAR_BEAR)
				.add(EntityType.SNIFFER)
				.add(EntityType.SNOW_GOLEM)
				.add(EntityType.STRIDER)
				.add(EntityType.TADPOLE)
				.add(EntityType.TRADER_LLAMA)
				.add(EntityType.TROPICAL_FISH)
				.add(EntityType.TURTLE)
				.add(EntityType.VILLAGER)
				.add(EntityType.WOLF);
		
		//  Farm animals or easy to kill mobs
		this.valueLookupBuilder(JinericEntityTypeTags.LEVELS_WEAPON_LOW)
				.add(EntityType.CHICKEN)
				.add(EntityType.COD)
				.add(EntityType.COW)
				.add(EntityType.GLOW_SQUID)
				.add(EntityType.MOOSHROOM)
				.add(EntityType.PIG)
				.add(EntityType.PUFFERFISH)
				.add(EntityType.RABBIT)
				.add(EntityType.SALMON)
				.add(EntityType.SHEEP)
				.add(EntityType.SILVERFISH)
				.add(EntityType.SQUID)
				//  Wandering trader is only here because it's funny. Kill all traders.
				.add(EntityType.WANDERING_TRADER)
				.add(EntityType.ZOMBIE_HORSE);
		
		//  Mobs that are hostile but relatively easy to kill
		this.valueLookupBuilder(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM)
				.add(EntityType.ZOMBIE)
				.add(EntityType.DROWNED)
				.add(EntityType.ZOMBIE_VILLAGER)
				.add(EntityType.ZOMBIFIED_PIGLIN)
				.add(EntityType.SKELETON)
				.add(EntityType.PILLAGER)
				.add(EntityType.PIGLIN)
				.add(EntityType.CREEPER)
				.add(EntityType.SPIDER)
				.add(EntityType.PHANTOM)
				.add(EntityType.SLIME)
				.add(EntityType.ENDERMITE)
				.add(EntityType.VEX);
		
		//  Mobs that do high damage or provide some kind of difficulty to kill (like applying an affect to the player on attack)
		this.valueLookupBuilder(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM_PLUS)
				.add(EntityType.STRAY)
				.add(EntityType.BOGGED)
				.add(EntityType.WITCH)
				.add(EntityType.BLAZE)
				.add(EntityType.GUARDIAN)
				.add(EntityType.HUSK)
				.add(EntityType.WITHER_SKELETON)
				.add(EntityType.CAVE_SPIDER)
				.add(EntityType.VINDICATOR)
				.add(EntityType.GHAST)
				.add(EntityType.HOGLIN)
				.add(EntityType.ZOGLIN)
				.add(EntityType.BREEZE)
				.add(EntityType.MAGMA_CUBE)
				.add(EntityType.ENDERMAN);
		
		//  Mobs with high health-pools that pose a major threat or are difficult to kill
		this.valueLookupBuilder(JinericEntityTypeTags.LEVELS_WEAPON_HIGH)
				.add(EntityType.IRON_GOLEM)
				.add(EntityType.RAVAGER)
				.add(EntityType.SHULKER)
				.add(EntityType.PIGLIN_BRUTE)
				.add(EntityType.EVOKER);
		
		//  Reserved for "Boss" mobs or very rare mobs
		this.valueLookupBuilder(JinericEntityTypeTags.LEVELS_WEAPON_EXTREME)
				.add(EntityType.ELDER_GUARDIAN)
				.add(EntityType.ENDER_DRAGON)
				.add(EntityType.WARDEN);
		
		//  Entities that can increase the level of a weapon
		this.valueLookupBuilder(JinericEntityTypeTags.LEVELS_WEAPON)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_LOW)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM_PLUS)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_HIGH)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_EXTREME);
		
	}
	
	@Override
	public String getName() {
		return "entity_type";
	}
}
