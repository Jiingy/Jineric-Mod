package jingy.jineric.data.generators.tag;

import jingy.jineric.tag.JinericEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.entity.EntityTypeIds;

import java.util.concurrent.CompletableFuture;

public class JinericEntityTypeTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
	public JinericEntityTypeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider holderLookupProvider) {
		//  Non-farm animals which provide no value for killing, or are passive.
		this.tag(JinericEntityTypeTags.LEVELS_WEAPON_NONE)
				.add(EntityTypeIds.ALLAY)
				.add(EntityTypeIds.ARMADILLO)
				.add(EntityTypeIds.AXOLOTL)
				.add(EntityTypeIds.BAT)
				.add(EntityTypeIds.BEE)
				.add(EntityTypeIds.CAMEL)
				.add(EntityTypeIds.CAT)
				.add(EntityTypeIds.DOLPHIN)
				.add(EntityTypeIds.DONKEY)
				.add(EntityTypeIds.FOX)
				.add(EntityTypeIds.FROG)
				.add(EntityTypeIds.GOAT)
				.add(EntityTypeIds.HORSE)
				.add(EntityTypeIds.LLAMA)
				.add(EntityTypeIds.MULE)
				.add(EntityTypeIds.OCELOT)
				.add(EntityTypeIds.PANDA)
				.add(EntityTypeIds.PARROT)
				.add(EntityTypeIds.POLAR_BEAR)
				.add(EntityTypeIds.SNIFFER)
				.add(EntityTypeIds.SNOW_GOLEM)
				.add(EntityTypeIds.STRIDER)
				.add(EntityTypeIds.TADPOLE)
				.add(EntityTypeIds.TRADER_LLAMA)
				.add(EntityTypeIds.TROPICAL_FISH)
				.add(EntityTypeIds.TURTLE)
				.add(EntityTypeIds.VILLAGER)
				.add(EntityTypeIds.WOLF);
		
		//  Farm animals or easy to kill mobs
		this.tag(JinericEntityTypeTags.LEVELS_WEAPON_LOW)
				.add(EntityTypeIds.CHICKEN)
				.add(EntityTypeIds.COD)
				.add(EntityTypeIds.COW)
				.add(EntityTypeIds.GLOW_SQUID)
				.add(EntityTypeIds.MOOSHROOM)
				.add(EntityTypeIds.PIG)
				.add(EntityTypeIds.PUFFERFISH)
				.add(EntityTypeIds.RABBIT)
				.add(EntityTypeIds.SALMON)
				.add(EntityTypeIds.SHEEP)
				.add(EntityTypeIds.SILVERFISH)
				.add(EntityTypeIds.SQUID)
				//  Wandering trader is only here because it's funny. Kill all traders.
				.add(EntityTypeIds.WANDERING_TRADER)
				.add(EntityTypeIds.ZOMBIE_HORSE);
		
		//  Mobs that are hostile but relatively easy to kill
		this.tag(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM)
				.add(EntityTypeIds.ZOMBIE)
				.add(EntityTypeIds.DROWNED)
				.add(EntityTypeIds.ZOMBIE_VILLAGER)
				.add(EntityTypeIds.ZOMBIFIED_PIGLIN)
				.add(EntityTypeIds.SKELETON)
				.add(EntityTypeIds.PILLAGER)
				.add(EntityTypeIds.PIGLIN)
				.add(EntityTypeIds.CREEPER)
				.add(EntityTypeIds.SPIDER)
				.add(EntityTypeIds.PHANTOM)
				.add(EntityTypeIds.SLIME)
				.add(EntityTypeIds.ENDERMITE)
				.add(EntityTypeIds.VEX);
		
		//  Mobs that do high damage or provide some kind of difficulty to kill (like applying an affect to the player on attack)
		this.tag(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM_PLUS)
				.add(EntityTypeIds.STRAY)
				.add(EntityTypeIds.BOGGED)
				.add(EntityTypeIds.WITCH)
				.add(EntityTypeIds.BLAZE)
				.add(EntityTypeIds.GUARDIAN)
				.add(EntityTypeIds.HUSK)
				.add(EntityTypeIds.WITHER_SKELETON)
				.add(EntityTypeIds.CAVE_SPIDER)
				.add(EntityTypeIds.VINDICATOR)
				.add(EntityTypeIds.GHAST)
				.add(EntityTypeIds.HOGLIN)
				.add(EntityTypeIds.ZOGLIN)
				.add(EntityTypeIds.BREEZE)
				.add(EntityTypeIds.MAGMA_CUBE)
				.add(EntityTypeIds.ENDERMAN);
		
		//  Mobs with high health-pools that pose a major threat or are difficult to kill
		this.tag(JinericEntityTypeTags.LEVELS_WEAPON_HIGH)
				.add(EntityTypeIds.IRON_GOLEM)
				.add(EntityTypeIds.RAVAGER)
				.add(EntityTypeIds.SHULKER)
				.add(EntityTypeIds.PIGLIN_BRUTE)
				.add(EntityTypeIds.EVOKER);
		
		//  Reserved for "Boss" mobs or very rare mobs
		this.tag(JinericEntityTypeTags.LEVELS_WEAPON_EXTREME)
				.add(EntityTypeIds.ELDER_GUARDIAN)
				.add(EntityTypeIds.ENDER_DRAGON)
				.add(EntityTypeIds.WARDEN);
		
		//  Entities that can increase the level of a weapon
		this.tag(JinericEntityTypeTags.LEVELS_WEAPON)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_LOW)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM_PLUS)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_HIGH)
				.addTag(JinericEntityTypeTags.LEVELS_WEAPON_EXTREME);
		
	}
	
	@Override
	public String getName() {
		return "Entity Types";
	}
}
