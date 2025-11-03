package jingy.jineric.data.generators.tag;

import jingy.jineric.item.JinericItems;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class JinericItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public JinericItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		this.valueLookupBuilder(JinericItemTags.CHESTS)
				.addTag(JinericItemTags.WOODEN_CHESTS);
		this.valueLookupBuilder(JinericItemTags.WOODEN_CHESTS)
				.add(Items.CHEST)
				.add(JinericItems.SPRUCE_CHEST)
				.add(JinericItems.BIRCH_CHEST)
				.add(JinericItems.JUNGLE_CHEST)
				.add(JinericItems.ACACIA_CHEST)
				.add(JinericItems.DARK_OAK_CHEST)
				.add(JinericItems.MANGROVE_CHEST)
				.add(JinericItems.CHERRY_CHEST)
				.add(JinericItems.BAMBOO_CHEST)
				.add(JinericItems.CRIMSON_CHEST)
				.add(JinericItems.WARPED_CHEST);
		this.valueLookupBuilder(JinericItemTags.PETRIFIED_OAK_LOGS)
				.add(JinericItems.PETRIFIED_OAK_LOG)
				.add(JinericItems.PETRIFIED_OAK_WOOD)
				.add(JinericItems.STRIPPED_PETRIFIED_OAK_LOG)
				.add(JinericItems.STRIPPED_PETRIFIED_OAK_WOOD);
		this.valueLookupBuilder(ItemTags.LOGS_THAT_BURN).addTag(JinericItemTags.PETRIFIED_OAK_LOGS);
		this.valueLookupBuilder(ItemTags.PLANKS).add(JinericItems.PETRIFIED_OAK_PLANKS);
		this.valueLookupBuilder(ItemTags.STAIRS).add(JinericItems.PETRIFIED_OAK_STAIRS);
		this.valueLookupBuilder(ItemTags.WOODEN_STAIRS).add(JinericItems.PETRIFIED_OAK_STAIRS);
		this.valueLookupBuilder(ItemTags.SLABS).add(JinericItems.PETRIFIED_OAK_SLAB);
		this.valueLookupBuilder(ItemTags.WOODEN_SLABS).add(JinericItems.PETRIFIED_OAK_SLAB);
		this.valueLookupBuilder(ItemTags.FENCES).add(JinericItems.PETRIFIED_OAK_FENCE, JinericItems.RED_NETHER_BRICK_FENCE);
		this.valueLookupBuilder(ItemTags.WOODEN_FENCES).add(JinericItems.PETRIFIED_OAK_FENCE);
		this.valueLookupBuilder(ItemTags.DOORS).add(JinericItems.PETRIFIED_OAK_DOOR);
		this.valueLookupBuilder(ItemTags.WOODEN_DOORS).add(JinericItems.PETRIFIED_OAK_DOOR);
		this.valueLookupBuilder(ItemTags.TRAPDOORS).add(JinericItems.PETRIFIED_OAK_TRAPDOOR);
		this.valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS).add(JinericItems.PETRIFIED_OAK_TRAPDOOR);
		this.valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(JinericItems.PETRIFIED_OAK_PRESSURE_PLATE);
		this.valueLookupBuilder(ItemTags.BUTTONS).add(JinericItems.PETRIFIED_OAK_BUTTON);
		this.valueLookupBuilder(ItemTags.WOODEN_BUTTONS).add(JinericItems.PETRIFIED_OAK_BUTTON);
		this.valueLookupBuilder(ItemTags.LEAVES).add(JinericItems.PETRIFIED_OAK_LEAVES);
		this.valueLookupBuilder(ItemTags.SAPLINGS).add(JinericItems.PETRIFIED_OAK_SAPLING);
		this.valueLookupBuilder(ItemTags.SIGNS).add(JinericItems.PETRIFIED_OAK_SIGN);
		this.valueLookupBuilder(ItemTags.HANGING_SIGNS).add(JinericItems.PETRIFIED_OAK_HANGING_SIGN);
		this.valueLookupBuilder(ItemTags.BOATS).add(JinericItems.PETRIFIED_OAK_BOAT);
		this.valueLookupBuilder(ItemTags.CHEST_BOATS).add(JinericItems.PETRIFIED_OAK_CHEST_BOAT);
//		this.valueLookupBuilder(ItemTags.BANNERS);
//		this.valueLookupBuilder(ItemTags.BUNDLES);
//		this.valueLookupBuilder(ItemTags.FISHES);
//		this.valueLookupBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS);
//		this.valueLookupBuilder(ItemTags.COALS);
//		this.valueLookupBuilder(ItemTags.ARROWS);
//		this.valueLookupBuilder(ItemTags.LECTERN_BOOKS);
//		this.valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS);
//		this.valueLookupBuilder(ItemTags.PIGLIN_REPELLENTS);
//		this.valueLookupBuilder(ItemTags.PIGLIN_LOVED);
//		this.valueLookupBuilder(ItemTags.IGNORED_BY_PIGLIN_BABIES);
//		this.valueLookupBuilder(ItemTags.PIGLIN_FOOD);
//		this.valueLookupBuilder(ItemTags.PIGLIN_SAFE_ARMOR);
//		this.valueLookupBuilder(ItemTags.FOX_FOOD);
//		this.valueLookupBuilder(ItemTags.DUPLICATES_ALLAYS);
//		this.valueLookupBuilder(ItemTags.BREWING_FUEL);
//		this.valueLookupBuilder(ItemTags.NON_FLAMMABLE_WOOD);
//		this.valueLookupBuilder(ItemTags.WOODEN_TOOL_MATERIALS);
//		this.valueLookupBuilder(ItemTags.STONE_TOOL_MATERIALS);
//		this.valueLookupBuilder(ItemTags.IRON_TOOL_MATERIALS);
//		this.valueLookupBuilder(ItemTags.GOLD_TOOL_MATERIALS);
//		this.valueLookupBuilder(ItemTags.DIAMOND_TOOL_MATERIALS);
//		this.valueLookupBuilder(ItemTags.NETHERITE_TOOL_MATERIALS);
//		this.valueLookupBuilder(ItemTags.REPAIRS_LEATHER_ARMOR);
//		this.valueLookupBuilder(ItemTags.REPAIRS_CHAIN_ARMOR);
//		this.valueLookupBuilder(ItemTags.REPAIRS_IRON_ARMOR);
//		this.valueLookupBuilder(ItemTags.REPAIRS_GOLD_ARMOR);
//		this.valueLookupBuilder(ItemTags.REPAIRS_DIAMOND_ARMOR);
//		this.valueLookupBuilder(ItemTags.REPAIRS_NETHERITE_ARMOR);
//		this.valueLookupBuilder(ItemTags.REPAIRS_TURTLE_HELMET);
//		this.valueLookupBuilder(ItemTags.REPAIRS_WOLF_ARMOR);
//		this.valueLookupBuilder(ItemTags.STONE_CRAFTING_MATERIALS);
//		this.valueLookupBuilder(ItemTags.FREEZE_IMMUNE_WEARABLES);
//		this.valueLookupBuilder(ItemTags.AXOLOTL_FOOD);
//		this.valueLookupBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES);
//		this.valueLookupBuilder(ItemTags.COMPASSES);
//		this.valueLookupBuilder(ItemTags.CREEPER_IGNITERS);
//		this.valueLookupBuilder(ItemTags.SWORDS);
//		this.valueLookupBuilder(ItemTags.AXES);
//		this.valueLookupBuilder(ItemTags.PICKAXES);
//		this.valueLookupBuilder(ItemTags.SHOVELS);
//		this.valueLookupBuilder(ItemTags.HOES);
//		this.valueLookupBuilder(ItemTags.BREAKS_DECORATED_POTS);
//		this.valueLookupBuilder(ItemTags.SKELETON_PREFERRED_WEAPONS);
//		this.valueLookupBuilder(ItemTags.DROWNED_PREFERRED_WEAPONS);
//		this.valueLookupBuilder(ItemTags.PIGLIN_PREFERRED_WEAPONS);
//		this.valueLookupBuilder(ItemTags.PILLAGER_PREFERRED_WEAPONS);
//		this.valueLookupBuilder(ItemTags.WITHER_SKELETON_DISLIKED_WEAPONS);
//		this.valueLookupBuilder(ItemTags.DECORATED_POT_SHERDS);
//		this.valueLookupBuilder(ItemTags.DECORATED_POT_INGREDIENTS);
//		this.valueLookupBuilder(ItemTags.FOOT_ARMOR);
//		this.valueLookupBuilder(ItemTags.LEG_ARMOR);
//		this.valueLookupBuilder(ItemTags.CHEST_ARMOR);
//		this.valueLookupBuilder(ItemTags.HEAD_ARMOR);
//		this.valueLookupBuilder(ItemTags.SKULLS);
//		this.valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR);
//		wrapperLookup.getOrThrow(RegistryKeys.TRIM_MATERIAL)
//				.streamEntries()
//				.sorted(Comparator.comparing(reference -> reference.registryKey().getValue()))
//				.forEach(reference -> this.valueLookupBuilder(ItemTags.TRIM_MATERIALS).add(((ArmorTrimMaterial)reference.value()).ingredient().value()))
//		;
//		this.valueLookupBuilder(ItemTags.BOOKSHELF_BOOKS);
//		this.valueLookupBuilder(ItemTags.NOTEBLOCK_TOP_INSTRUMENTS);
//		this.valueLookupBuilder(ItemTags.SNIFFER_FOOD);
//		this.valueLookupBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS);
//		this.valueLookupBuilder(ItemTags.VILLAGER_PICKS_UP);
//		this.valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.SWORD_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.WEAPON_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.MACE_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.MINING_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.FISHING_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.TRIDENT_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.BOW_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.CROSSBOW_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE);
//		this.valueLookupBuilder(ItemTags.DYEABLE);
//		this.valueLookupBuilder(ItemTags.FURNACE_MINECART_FUEL);
//		this.valueLookupBuilder(ItemTags.MEAT);
//		this.valueLookupBuilder(ItemTags.WOLF_FOOD);
//		this.valueLookupBuilder(ItemTags.OCELOT_FOOD);
//		this.valueLookupBuilder(ItemTags.CAT_FOOD);
//		this.valueLookupBuilder(ItemTags.HORSE_FOOD);
//		this.valueLookupBuilder(ItemTags.HORSE_TEMPT_ITEMS);
//		this.valueLookupBuilder(ItemTags.CAMEL_FOOD);
//		this.valueLookupBuilder(ItemTags.ARMADILLO_FOOD);
//		this.valueLookupBuilder(ItemTags.CHICKEN_FOOD);
//		this.valueLookupBuilder(ItemTags.FROG_FOOD);
//		this.valueLookupBuilder(ItemTags.HOGLIN_FOOD);
//		this.valueLookupBuilder(ItemTags.LLAMA_FOOD);
//		this.valueLookupBuilder(ItemTags.LLAMA_TEMPT_ITEMS);
//		this.valueLookupBuilder(ItemTags.PANDA_FOOD);
//		this.valueLookupBuilder(ItemTags.PANDA_EATS_FROM_GROUND);
//		this.valueLookupBuilder(ItemTags.PIG_FOOD);
//		this.valueLookupBuilder(ItemTags.RABBIT_FOOD);
//		this.valueLookupBuilder(ItemTags.STRIDER_FOOD);
//		this.valueLookupBuilder(ItemTags.STRIDER_TEMPT_ITEMS);
//		this.valueLookupBuilder(ItemTags.TURTLE_FOOD);
//		this.valueLookupBuilder(ItemTags.PARROT_FOOD);
//		this.valueLookupBuilder(ItemTags.PARROT_POISONOUS_FOOD);
//		this.valueLookupBuilder(ItemTags.COW_FOOD);
//		this.valueLookupBuilder(ItemTags.SHEEP_FOOD);
//		this.valueLookupBuilder(ItemTags.GOAT_FOOD);
//		this.valueLookupBuilder(ItemTags.MAP_INVISIBILITY_EQUIPMENT);
//		this.valueLookupBuilder(ItemTags.GAZE_DISGUISE_EQUIPMENT);
	}
	
	@Override
	public String getName() {
		return "Item Tags";
	}
}
