package jingy.jineric.data.generators.tag;

import jingy.jineric.references.JmBlockItemIds;
import jingy.jineric.references.JmItemIds;
import jingy.jineric.tag.JinericItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class JinericItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
	public JinericItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
		super(output, completableFuture);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider holderLookup) {
		//  Modded
		this.builder(JinericItemTags.CHESTS)
				.addTag(JinericItemTags.WOODEN_CHESTS);
		this.builder(JinericItemTags.WOODEN_CHESTS)
				.add(BlockItemIds.CHEST)
				.add(JmBlockItemIds.SPRUCE_CHEST)
				.add(JmBlockItemIds.BIRCH_CHEST)
				.add(JmBlockItemIds.JUNGLE_CHEST)
				.add(JmBlockItemIds.ACACIA_CHEST)
				.add(JmBlockItemIds.DARK_OAK_CHEST)
				.add(JmBlockItemIds.MANGROVE_CHEST)
				.add(JmBlockItemIds.CHERRY_CHEST)
				.add(JmBlockItemIds.BAMBOO_CHEST)
				.add(JmBlockItemIds.CRIMSON_CHEST)
				.add(JmBlockItemIds.WARPED_CHEST);
		this.builder(JinericItemTags.CUT_COPPER)
				.add(BlockItemIds.CUT_COPPER.weathering().unaffected())
				.add(BlockItemIds.CUT_COPPER.weathering().exposed())
				.add(BlockItemIds.CUT_COPPER.weathering().weathered())
				.add(BlockItemIds.CUT_COPPER.weathering().oxidized())
				.add(BlockItemIds.CUT_COPPER.waxed().unaffected())
				.add(BlockItemIds.CUT_COPPER.waxed().exposed())
				.add(BlockItemIds.CUT_COPPER.waxed().weathered())
				.add(BlockItemIds.CUT_COPPER.waxed().oxidized());
		this.builder(JinericItemTags.ARMOR)
				.forceAddTag(ItemTags.HEAD_ARMOR)
				.forceAddTag(ItemTags.CHEST_ARMOR)
				.forceAddTag(ItemTags.LEG_ARMOR)
				.forceAddTag(ItemTags.FOOT_ARMOR);
		this.builder(JinericItemTags.STONE_EQUIPMENT_MATERIALS)
				.add(BlockItemIds.STONE);
		this.builder(ItemTags.HEAD_ARMOR).add(JmItemIds.WOODEN_HELMET);
		this.builder(ItemTags.CHEST_ARMOR).add(JmItemIds.WOODEN_CHESTPLATE);
		this.builder(ItemTags.LEG_ARMOR).add(JmItemIds.WOODEN_LEGGINGS);
		this.builder(ItemTags.FOOT_ARMOR).add(JmItemIds.WOODEN_BOOTS);
		this.builder(JinericItemTags.TINDER_MATERIALS)
				.add(ItemIds.FEATHER)
				.add(BlockItemIds.RED_MUSHROOM)
				.add(BlockItemIds.BROWN_MUSHROOM);
		this.builder(JinericItemTags.LOGS)
				.forceAddTag(ConventionalItemTags.NATURAL_LOGS)
				.forceAddTag(ConventionalItemTags.STRIPPED_LOGS);
		this.builder(JinericItemTags.WOODS)
				.forceAddTag(ConventionalItemTags.NATURAL_WOODS)
				.forceAddTag(ConventionalItemTags.STRIPPED_WOODS);
		this.builder(JinericItemTags.LOGS_AND_WOODS)
				.forceAddTag(JinericItemTags.LOGS)
				.forceAddTag(JinericItemTags.WOODS);
				
		//  Vanilla
//		this.getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN);
//		this.getOrCreateTagBuilder(ItemTags.PLANKS);
//		this.getOrCreateTagBuilder(ItemTags.STAIRS);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS);
//		this.getOrCreateTagBuilder(ItemTags.SLABS);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_SLABS);
//		this.getOrCreateTagBuilder(ItemTags.FENCES);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_FENCES);
//		this.getOrCreateTagBuilder(ItemTags.DOORS);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS);
//		this.getOrCreateTagBuilder(ItemTags.TRAPDOORS);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES);
//		this.getOrCreateTagBuilder(ItemTags.BUTTONS);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS);
//		this.getOrCreateTagBuilder(ItemTags.LEAVES);
//		this.getOrCreateTagBuilder(ItemTags.SAPLINGS);
//		this.getOrCreateTagBuilder(ItemTags.SIGNS);
//		this.getOrCreateTagBuilder(ItemTags.HANGING_SIGNS);
//		this.getOrCreateTagBuilder(ItemTags.BOATS);
//		this.getOrCreateTagBuilder(ItemTags.CHEST_BOATS);
//		this.getOrCreateTagBuilder(ItemTags.BANNERS);
//		this.getOrCreateTagBuilder(ItemTags.BUNDLES);
//		this.getOrCreateTagBuilder(ItemTags.FISHES);
//		this.getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS);
//		this.getOrCreateTagBuilder(ItemTags.COALS);
//		this.getOrCreateTagBuilder(ItemTags.ARROWS);
//		this.getOrCreateTagBuilder(ItemTags.LECTERN_BOOKS);
//		this.getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS);
//		this.getOrCreateTagBuilder(ItemTags.PIGLIN_REPELLENTS);
//		this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED);
//		this.getOrCreateTagBuilder(ItemTags.IGNORED_BY_PIGLIN_BABIES);
//		this.getOrCreateTagBuilder(ItemTags.PIGLIN_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.PIGLIN_SAFE_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.FOX_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.DUPLICATES_ALLAYS);
//		this.getOrCreateTagBuilder(ItemTags.BREWING_FUEL);
//		this.getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD);
//		this.getOrCreateTagBuilder(ItemTags.WOODEN_TOOL_MATERIALS);
//		this.getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS);
//		this.getOrCreateTagBuilder(ItemTags.IRON_TOOL_MATERIALS);
//		this.getOrCreateTagBuilder(ItemTags.GOLD_TOOL_MATERIALS);
//		this.getOrCreateTagBuilder(ItemTags.DIAMOND_TOOL_MATERIALS);
//		this.getOrCreateTagBuilder(ItemTags.NETHERITE_TOOL_MATERIALS);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_LEATHER_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_CHAIN_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_IRON_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_GOLD_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_DIAMOND_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_NETHERITE_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_TURTLE_HELMET);
//		this.getOrCreateTagBuilder(ItemTags.REPAIRS_WOLF_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS);
//		this.getOrCreateTagBuilder(ItemTags.FREEZE_IMMUNE_WEARABLES);
//		this.getOrCreateTagBuilder(ItemTags.AXOLOTL_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES);
//		this.getOrCreateTagBuilder(ItemTags.COMPASSES);
//		this.getOrCreateTagBuilder(ItemTags.CREEPER_IGNITERS);
//		this.getOrCreateTagBuilder(ItemTags.SWORDS);
//		this.getOrCreateTagBuilder(ItemTags.AXES);
//		this.getOrCreateTagBuilder(ItemTags.PICKAXES);
//		this.getOrCreateTagBuilder(ItemTags.SHOVELS);
//		this.getOrCreateTagBuilder(ItemTags.HOES);
//		this.getOrCreateTagBuilder(ItemTags.BREAKS_DECORATED_POTS);
//		this.getOrCreateTagBuilder(ItemTags.SKELETON_PREFERRED_WEAPONS);
//		this.getOrCreateTagBuilder(ItemTags.DROWNED_PREFERRED_WEAPONS);
//		this.getOrCreateTagBuilder(ItemTags.PIGLIN_PREFERRED_WEAPONS);
//		this.getOrCreateTagBuilder(ItemTags.PILLAGER_PREFERRED_WEAPONS);
//		this.getOrCreateTagBuilder(ItemTags.WITHER_SKELETON_DISLIKED_WEAPONS);
//		this.getOrCreateTagBuilder(ItemTags.DECORATED_POT_SHERDS);
//		this.getOrCreateTagBuilder(ItemTags.DECORATED_POT_INGREDIENTS);
//		this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.HEAD_ARMOR);
//		this.getOrCreateTagBuilder(ItemTags.SKULLS);
//		this.getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR);
//		holderLookup.getOrThrow(RegistryKeys.TRIM_MATERIAL)
//				.streamEntries()
//				.sorted(Comparator.comparing(reference -> reference.registryKey().getValue()))
//				.forEach(reference -> this.getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS).add(((ArmorTrimMaterial)reference.value()).ingredient().value()))
//		;
//		this.getOrCreateTagBuilder(ItemTags.BOOKSHELF_BOOKS);
//		this.getOrCreateTagBuilder(ItemTags.NOTEBLOCK_TOP_INSTRUMENTS);
//		this.getOrCreateTagBuilder(ItemTags.SNIFFER_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS);
//		this.getOrCreateTagBuilder(ItemTags.VILLAGER_PICKS_UP);
//		this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.MACE_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.FISHING_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.TRIDENT_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.CROSSBOW_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE);
//		this.getOrCreateTagBuilder(ItemTags.DYEABLE);
//		this.getOrCreateTagBuilder(ItemTags.FURNACE_MINECART_FUEL);
//		this.getOrCreateTagBuilder(ItemTags.MEAT);
//		this.getOrCreateTagBuilder(ItemTags.WOLF_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.OCELOT_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.CAT_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.HORSE_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.HORSE_TEMPT_ITEMS);
//		this.getOrCreateTagBuilder(ItemTags.CAMEL_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.ARMADILLO_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.CHICKEN_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.FROG_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.HOGLIN_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.LLAMA_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.LLAMA_TEMPT_ITEMS);
//		this.getOrCreateTagBuilder(ItemTags.PANDA_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.PANDA_EATS_FROM_GROUND);
//		this.getOrCreateTagBuilder(ItemTags.PIG_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.RABBIT_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.STRIDER_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.STRIDER_TEMPT_ITEMS);
//		this.getOrCreateTagBuilder(ItemTags.TURTLE_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.PARROT_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.PARROT_POISONOUS_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.COW_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.SHEEP_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.GOAT_FOOD);
//		this.getOrCreateTagBuilder(ItemTags.MAP_INVISIBILITY_EQUIPMENT);
//		this.getOrCreateTagBuilder(ItemTags.GAZE_DISGUISE_EQUIPMENT);
	}
	
	@Override
	public String getName() {
		return "Item Tags";
	}
}
