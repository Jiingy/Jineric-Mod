package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.collect.ImmutableMap;

import java.util.Map;

@SuppressWarnings("unstable")
public class JinericItemGroups {
//	public static final ItemGroup DONE = FabricItemGroupBuilder.build(
//			new Identifier("done", "jineric"),
//			() -> new ItemStack(JinericItems.DRIPSTONE_BRICKS));
//
//	public static final ItemGroup WIP = FabricItemGroupBuilder.build(
//			new Identifier("work_in_progress", "jineric"),
//			() -> new ItemStack(JinericItems.FIREWEED));
//
//	public static final ItemGroup UNKNOWN = FabricItemGroupBuilder.build(
//			new Identifier("unknown", "jineric"),
//			() -> new ItemStack(Items.APPLE));

	public static final ItemGroup MOD_ITEMS = FabricItemGroup.builder(new Identifier(JinericMain.MOD_ID, "mod_items"))
			.displayName(Text.literal("Jineric Mod Items"))
			.icon(() -> new ItemStack(JinericItems.PRISMARINE_CRYSTAL_BLOCK))
			.entries((enabledFeatures, entries, operatorEnabled) -> {
				//STORAGE BLOCKS
				entries.add(JinericItems.OBSIDIAN_STAIRS);
				entries.add(JinericItems.OBSIDIAN_SLAB);
				entries.add(JinericItems.OBSIDIAN_WALL);
				entries.add(JinericItems.SNOW_WALL);

				entries.add(JinericItems.CHARCOAL_BLOCK);
				entries.add(JinericItems.FLINT_BLOCK);
				entries.add(JinericItems.BONE_MEAL_BLOCK);
				entries.add(JinericItems.PRISMARINE_CRYSTAL_BLOCK);
				entries.add(JinericItems.SUGAR_BLOCK);
				entries.add(JinericItems.ROTTEN_FLESH_BLOCK);
				entries.add(JinericItems.STICK_BUNDLE);
				entries.add(JinericItems.EGG_BLOCK);
				entries.add(JinericItems.ENDER_PEARL_BLOCK);
				entries.add(JinericItems.STACK_OF_PAPER);
				entries.add(JinericItems.BLAZE_ROD_BUNDLE);

				//OTHER
				entries.add(JinericItems.REDSTONE_CAMPFIRE);
				entries.add(JinericItems.REDSTONE_LANTERN);
				entries.add(JinericItems.REFINERY);
				entries.add(JinericItems.TUMBLEWEED);
				entries.add(JinericItems.SHULKER_CHEST);
//				entries.add(JinericItems.SALT);
//				entries.add(JinericItems.SALT_BLOCK);
			}).build();

	public static final ItemGroup WOODEN_MOD_ITEMS = FabricItemGroup.builder(new Identifier(JinericMain.MOD_ID, "wooden_mod_items"))
			.displayName(Text.literal("Jineric Wooden Mod Items"))
			.icon(() ->new ItemStack(JinericItems.WARPED_CHEST))
			.entries((enabledFeatures, entries, operatorEnabled) -> {
				//WOODEN BLOCKS
				entries.add(JinericItems.SPRUCE_BOOKSHELF);
				entries.add(JinericItems.SPRUCE_CHEST);
				entries.add(JinericItems.SPRUCE_LADDER);
				entries.add(JinericItems.BIRCH_BOOKSHELF);
				entries.add(JinericItems.BIRCH_CHEST);
				entries.add(JinericItems.BIRCH_LADDER);
				entries.add(JinericItems.JUNGLE_BOOKSHELF);
				entries.add(JinericItems.JUNGLE_CHEST);
				entries.add(JinericItems.JUNGLE_LADDER);
				entries.add(JinericItems.ACACIA_BOOKSHELF);
				entries.add(JinericItems.ACACIA_CHEST);
				entries.add(JinericItems.ACACIA_LADDER);
				entries.add(JinericItems.DARK_OAK_BOOKSHELF);
				entries.add(JinericItems.DARK_OAK_CHEST);
				entries.add(JinericItems.DARK_OAK_LADDER);
				entries.add(JinericItems.MANGROVE_BOOKSHELF);
				entries.add(JinericItems.MANGROVE_CHEST);
				entries.add(JinericItems.MANGROVE_LADDER);
				entries.add(JinericItems.CRIMSON_BOOKSHELF);
				entries.add(JinericItems.CRIMSON_CHEST);
				entries.add(JinericItems.CRIMSON_LADDER);
				entries.add(JinericItems.WARPED_BOOKSHELF);
				entries.add(JinericItems.WARPED_CHEST);
				entries.add(JinericItems.WARPED_LADDER);
			}).build();

	public static final Identifier MOD_ITEMS_ID = new Identifier("jineric:mod_items");

	public static final Map<ItemGroup, Identifier> GROUP_ID_MAP = new ImmutableMap.Builder<ItemGroup, Identifier>().put(MOD_ITEMS, MOD_ITEMS_ID).build();


	public static void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries) -> {
			entries.addAfter(Items.STONE_SLAB, JinericItems.STONE_WALL);
			entries.addAfter(Items.SMOOTH_STONE, JinericItems.SMOOTH_STONE_STAIRS);
			entries.addAfter(Items.SMOOTH_STONE_SLAB, JinericItems.SMOOTH_STONE_WALL);

			entries.addBefore(Items.STONE_BRICK_STAIRS, Items.STONE_BRICKS);

			entries.addAfter(Items.STONE_BRICK_WALL, Items.CRACKED_STONE_BRICKS);
			entries.addAfter(Items.CRACKED_STONE_BRICKS, JinericItems.CRACKED_STONE_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_STONE_BRICK_STAIRS, JinericItems.CRACKED_STONE_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_STONE_BRICK_SLAB, JinericItems.CRACKED_STONE_BRICK_WALL);

			entries.addAfter(JinericItems.CRACKED_STONE_BRICK_WALL, JinericItems.STONE_PILLAR);

			entries.addAfter(JinericItems.SMOOTH_STONE_WALL, JinericItems.POLISHED_STONE);
			entries.addAfter(JinericItems.POLISHED_STONE, JinericItems.POLISHED_STONE_STAIRS);
			entries.addAfter(JinericItems.POLISHED_STONE_STAIRS, JinericItems.POLISHED_STONE_SLAB);
			entries.addAfter(JinericItems.POLISHED_STONE_SLAB, JinericItems.POLISHED_STONE_WALL);
			entries.addAfter(Items.MOSSY_STONE_BRICK_WALL, JinericItems.STONE_TILES);
			entries.addAfter(JinericItems.STONE_TILES, JinericItems.STONE_TILE_STAIRS);
			entries.addAfter(JinericItems.STONE_TILE_STAIRS, JinericItems.STONE_TILE_SLAB);
			entries.addAfter(JinericItems.STONE_TILE_SLAB, JinericItems.STONE_TILE_WALL);
			//"ITE" BlOCKS
			entries.addAfter(Items.POLISHED_ANDESITE_STAIRS, JinericItems.POLISHED_ANDESITE_WALL);
			entries.addAfter(Items.POLISHED_DIORITE_STAIRS, JinericItems.POLISHED_DIORITE_WALL);
			entries.addAfter(Items.POLISHED_GRANITE_STAIRS, JinericItems.POLISHED_GRANITE_WALL);
			//DRIPSTONE
			entries.addAfter(Items.POLISHED_ANDESITE_SLAB, Items.DRIPSTONE_BLOCK);
			entries.addAfter(Items.DRIPSTONE_BLOCK, JinericItems.DRIPSTONE_STAIRS);
			entries.addAfter(JinericItems.DRIPSTONE_STAIRS, JinericItems.DRIPSTONE_SLAB);
			entries.addAfter(JinericItems.DRIPSTONE_SLAB, JinericItems.DRIPSTONE_WALL);
			entries.addAfter(JinericItems.DRIPSTONE_WALL, JinericItems.COBBLED_DRIPSTONE);
			entries.addAfter(JinericItems.COBBLED_DRIPSTONE, JinericItems.COBBLED_DRIPSTONE_STAIRS);
			entries.addAfter(JinericItems.COBBLED_DRIPSTONE_STAIRS, JinericItems.COBBLED_DRIPSTONE_SLAB);
			entries.addAfter(JinericItems.COBBLED_DRIPSTONE_SLAB, JinericItems.COBBLED_DRIPSTONE_WALL);
			entries.addAfter(JinericItems.COBBLED_DRIPSTONE_WALL, JinericItems.SMOOTH_DRIPSTONE);
			entries.addAfter(JinericItems.SMOOTH_DRIPSTONE, JinericItems.SMOOTH_DRIPSTONE_STAIRS);
			entries.addAfter(JinericItems.SMOOTH_DRIPSTONE_STAIRS, JinericItems.SMOOTH_DRIPSTONE_SLAB);
			entries.addAfter(JinericItems.SMOOTH_DRIPSTONE_SLAB, JinericItems.SMOOTH_DRIPSTONE_WALL);
			entries.addAfter(JinericItems.SMOOTH_DRIPSTONE_WALL, JinericItems.POLISHED_DRIPSTONE);
			entries.addAfter(JinericItems.POLISHED_DRIPSTONE, JinericItems.POLISHED_DRIPSTONE_STAIRS);
			entries.addAfter(JinericItems.POLISHED_DRIPSTONE_STAIRS, JinericItems.POLISHED_DRIPSTONE_SLAB);
			entries.addAfter(JinericItems.POLISHED_DRIPSTONE_SLAB, JinericItems.POLISHED_DRIPSTONE_WALL);
			entries.addAfter(JinericItems.POLISHED_DRIPSTONE_WALL, JinericItems.DRIPSTONE_BRICKS);
			entries.addAfter(JinericItems.DRIPSTONE_BRICKS, JinericItems.DRIPSTONE_BRICK_STAIRS);
			entries.addAfter(JinericItems.DRIPSTONE_BRICK_STAIRS, JinericItems.DRIPSTONE_BRICK_SLAB);
			entries.addAfter(JinericItems.DRIPSTONE_BRICK_SLAB, JinericItems.DRIPSTONE_BRICK_WALL);
			entries.addAfter(JinericItems.DRIPSTONE_BRICK_WALL, JinericItems.CRACKED_DRIPSTONE_BRICKS);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICKS, JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS, JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB, JinericItems.CRACKED_DRIPSTONE_BRICK_WALL);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_WALL, JinericItems.DRIPSTONE_PILLAR);
			entries.addAfter(JinericItems.DRIPSTONE_PILLAR, JinericItems.CHISELED_DRIPSTONE_BRICKS);
			entries.addAfter(JinericItems.CHISELED_DRIPSTONE_BRICKS, JinericItems.DRIPSTONE_TILES);
			entries.addAfter(JinericItems.DRIPSTONE_TILES, JinericItems.DRIPSTONE_TILE_STAIRS);
			entries.addAfter(JinericItems.DRIPSTONE_TILE_STAIRS, JinericItems.DRIPSTONE_TILE_SLAB);
			entries.addAfter(JinericItems.DRIPSTONE_TILE_SLAB, JinericItems.DRIPSTONE_TILE_WALL);
			entries.addAfter(Items.COBBLED_DEEPSLATE_WALL, JinericItems.SMOOTH_DEEPSLATE);
			entries.addAfter(JinericItems.SMOOTH_DEEPSLATE, JinericItems.SMOOTH_DEEPSLATE_STAIRS);
			entries.addAfter(JinericItems.SMOOTH_DEEPSLATE_STAIRS, JinericItems.SMOOTH_DEEPSLATE_SLAB);
			entries.addAfter(JinericItems.SMOOTH_DEEPSLATE_SLAB, JinericItems.SMOOTH_DEEPSLATE_WALL);
			entries.addAfter(Items.PRISMARINE_BRICK_SLAB, JinericItems.PRISMARINE_BRICK_WALL);
			entries.addAfter(Items.DARK_PRISMARINE_SLAB, JinericItems.DARK_PRISMARINE_WALL);
//			entries.addAfter(Items.POLISHED_BLACKSTONE_BRICK_WALL, JinericItems.SOUL_SANDSTONE);
//			entries.addAfter(JinericItems.SOUL_SANDSTONE, JinericItems.SOUL_SANDSTONE_STAIRS);
//			entries.addAfter(JinericItems.SOUL_SANDSTONE_STAIRS, JinericItems.SOUL_SANDSTONE_SLAB);
//			entries.addAfter(JinericItems.SOUL_SANDSTONE_SLAB, JinericItems.SOUL_SANDSTONE_WALL);
//			entries.addAfter(JinericItems.SOUL_SANDSTONE_WALL, JinericItems.CHISELED_SOUL_SANDSTONE);
//			entries.addAfter(JinericItems.CHISELED_SOUL_SANDSTONE, JinericItems.SMOOTH_SOUL_SANDSTONE);
//			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE, JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS);
//			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS, JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB);
//			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB, JinericItems.SMOOTH_SOUL_SANDSTONE_WALL);
//			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_WALL, JinericItems.CUT_SOUL_SANDSTONE);
//			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE, JinericItems.CUT_SOUL_SANDSTONE_STAIRS);
//			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE_STAIRS, JinericItems.CUT_SOUL_SANDSTONE_SLAB);
//			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE_SLAB, JinericItems.CUT_SOUL_SANDSTONE_WALL);
//			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE_WALL, JinericItems.POLISHED_SOUL_SANDSTONE);
//			entries.addAfter(JinericItems.POLISHED_SOUL_SANDSTONE, JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS);
//			entries.addAfter(JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS, JinericItems.POLISHED_SOUL_SANDSTONE_SLAB);
//			entries.addAfter(JinericItems.POLISHED_SOUL_SANDSTONE_SLAB, JinericItems.POLISHED_SOUL_SANDSTONE_WALL);
			//SANDSTONES
			entries.addAfter(Items.CUT_SANDSTONE, JinericItems.CUT_SANDSTONE_STAIRS);
			entries.addAfter(Items.CUT_SANDSTONE_SLAB, JinericItems.CUT_SANDSTONE_WALL);
			entries.addAfter(JinericItems.CUT_SANDSTONE_WALL, JinericItems.POLISHED_SANDSTONE);
			entries.addAfter(JinericItems.POLISHED_SANDSTONE, JinericItems.POLISHED_SANDSTONE_STAIRS);
			entries.addAfter(JinericItems.POLISHED_SANDSTONE_STAIRS, JinericItems.POLISHED_SANDSTONE_SLAB);
			entries.addAfter(JinericItems.POLISHED_SANDSTONE_SLAB, JinericItems.POLISHED_SANDSTONE_WALL);
			entries.addAfter(Items.CUT_RED_SANDSTONE, JinericItems.CUT_RED_SANDSTONE_STAIRS);
			entries.addAfter(Items.CUT_RED_SANDSTONE_SLAB, JinericItems.CUT_RED_SANDSTONE_WALL);
			entries.addAfter(JinericItems.CUT_RED_SANDSTONE_WALL, JinericItems.POLISHED_RED_SANDSTONE);
			entries.addAfter(JinericItems.POLISHED_RED_SANDSTONE, JinericItems.POLISHED_RED_SANDSTONE_STAIRS);
			entries.addAfter(JinericItems.POLISHED_RED_SANDSTONE_STAIRS, JinericItems.POLISHED_RED_SANDSTONE_SLAB);
			entries.addAfter(JinericItems.POLISHED_RED_SANDSTONE_SLAB, JinericItems.POLISHED_RED_SANDSTONE_WALL);
			//COPPER
			entries.addAfter(Items.CUT_COPPER_SLAB, JinericItems.CUT_COPPER_WALL);
			entries.addAfter(Items.EXPOSED_CUT_COPPER, JinericItems.EXPOSED_CUT_COPPER_WALL);
			entries.addAfter(Items.WEATHERED_CUT_COPPER_SLAB, JinericItems.WEATHERED_CUT_COPPER_WALL);
			entries.addAfter(Items.OXIDIZED_CUT_COPPER_SLAB, JinericItems.OXIDIZED_CUT_COPPER_WALL);
			entries.addAfter(Items.WAXED_CUT_COPPER_SLAB, JinericItems.WAXED_CUT_COPPER_WALL);
			entries.addAfter(Items.WAXED_EXPOSED_CUT_COPPER, JinericItems.WAXED_EXPOSED_CUT_COPPER_WALL);
			entries.addAfter(Items.WAXED_WEATHERED_CUT_COPPER_SLAB, JinericItems.WAXED_WEATHERED_CUT_COPPER_WALL);
			entries.addAfter(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, JinericItems.WAXED_OXIDIZED_CUT_COPPER_WALL);
			entries.addAfter(Items.SMOOTH_SANDSTONE_SLAB, JinericItems.SMOOTH_SANDSTONE_WALL);
			entries.addAfter(Items.SMOOTH_RED_SANDSTONE_SLAB, JinericItems.SMOOTH_RED_SANDSTONE_WALL);
			entries.addAfter(Items.SMOOTH_SANDSTONE_SLAB, JinericItems.SMOOTH_SANDSTONE_WALL);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register((entries -> {
//			entries.addAfter(Items.PACKED_ICE, JinericItems.PACKED_ICE_STAIRS);
//			entries.addAfter(JinericItems.PACKED_ICE_STAIRS, JinericItems.PACKED_ICE_SLAB);
//			entries.addAfter(JinericItems.PACKED_ICE_SLAB, JinericItems.PACKED_ICE_WALL);
			//TODO: WORK OUT OBSIDIAN
//			entries.addAfter(Items.OBSIDIAN, JinericItems.OBSIDIAN_STAIRS);
//			entries.addAfter(JinericItems.OBSIDIAN_STAIRS, JinericItems.OBSIDIAN_SLAB);
//			entries.addAfter(JinericItems.OBSIDIAN_SLAB, JinericItems.OBSIDIAN_WALL);
//			entries.addAfter(Items.SNOW_BLOCK, JinericItems.SNOW_WALL);
			entries.addAfter(Items.JACK_O_LANTERN, JinericItems.SOUL_JACK_O_LANTERN);
		}));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((entries) -> {
			entries.addAfter(Items.SOUL_LANTERN, JinericItems.REDSTONE_LANTERN);
			entries.addAfter(Items.SOUL_CAMPFIRE, JinericItems.REDSTONE_CAMPFIRE);
			//LADDERS
			entries.addAfter(Items.LADDER, JinericItems.SPRUCE_LADDER);
			entries.addAfter(JinericItems.SPRUCE_LADDER, JinericItems.BIRCH_LADDER);
			entries.addAfter(JinericItems.BIRCH_LADDER, JinericItems.JUNGLE_LADDER);
			entries.addAfter(JinericItems.JUNGLE_LADDER, JinericItems.ACACIA_LADDER);
			entries.addAfter(JinericItems.ACACIA_LADDER, JinericItems.DARK_OAK_LADDER);
			entries.addAfter(JinericItems.DARK_OAK_LADDER, JinericItems.MANGROVE_LADDER);
			entries.addAfter(JinericItems.MANGROVE_LADDER, JinericItems.CRIMSON_LADDER);
			entries.addAfter(JinericItems.CRIMSON_LADDER, JinericItems.WARPED_LADDER);
			//BOOKSHELVES
			entries.addAfter(Items.BOOKSHELF, JinericItems.SPRUCE_BOOKSHELF);
			entries.addAfter(JinericItems.SPRUCE_BOOKSHELF, JinericItems.BIRCH_BOOKSHELF);
			entries.addAfter(JinericItems.BIRCH_BOOKSHELF, JinericItems.JUNGLE_BOOKSHELF);
			entries.addAfter(JinericItems.JUNGLE_BOOKSHELF, JinericItems.ACACIA_BOOKSHELF);
			entries.addAfter(JinericItems.ACACIA_BOOKSHELF, JinericItems.DARK_OAK_BOOKSHELF);
			entries.addAfter(JinericItems.DARK_OAK_BOOKSHELF, JinericItems.MANGROVE_BOOKSHELF);
			entries.addAfter(JinericItems.MANGROVE_BOOKSHELF, JinericItems.CRIMSON_BOOKSHELF);
			entries.addAfter(JinericItems.CRIMSON_BOOKSHELF, JinericItems.WARPED_BOOKSHELF);
			//CHESTS
			entries.addAfter(Items.CHEST, JinericItems.SPRUCE_CHEST);
			entries.addAfter(JinericItems.SPRUCE_CHEST, JinericItems.BIRCH_CHEST);
			entries.addAfter(JinericItems.BIRCH_CHEST, JinericItems.JUNGLE_CHEST);
			entries.addAfter(JinericItems.JUNGLE_CHEST, JinericItems.ACACIA_CHEST);
			entries.addAfter(JinericItems.ACACIA_CHEST, JinericItems.DARK_OAK_CHEST);
			entries.addAfter(JinericItems.DARK_OAK_CHEST, JinericItems.MANGROVE_CHEST);
			entries.addAfter(JinericItems.MANGROVE_CHEST, JinericItems.CRIMSON_CHEST);
			entries.addAfter(JinericItems.CRIMSON_CHEST, JinericItems.WARPED_CHEST);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((entries -> {
			entries.addAfter(Items.DIAMOND_HORSE_ARMOR, JinericItems.NETHERITE_HORSE_ARMOR);
		}));
	}
}