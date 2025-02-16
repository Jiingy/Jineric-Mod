package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@SuppressWarnings("all")
//TODO: 1.21.3 REORGANIZE INVENTORY
public class JinericItemGroups {
	public static final Identifier MOD_ITEMS_ID = JinericMain.ofJineric("mod_items");
	private static final RegistryKey<ItemGroup> MOD_ITEMS_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, MOD_ITEMS_ID);

	public static void registerJinericItemGroups() {
		Registry.register(Registries.ITEM_GROUP, MOD_ITEMS_KEY, FabricItemGroup.builder()
						.displayName(Text.literal("Jineric Mod Items"))
						.icon(() -> new ItemStack(JinericItems.PRISMARINE_CRYSTAL_BLOCK))
						.entries((context, entries) -> {
                           entries.add(JinericItems.PETRIFIED_OAK_LOG);
                           entries.add(JinericItems.PETRIFIED_OAK_WOOD);
                           entries.add(JinericItems.STRIPPED_PETRIFIED_OAK_LOG);
                           entries.add(JinericItems.STRIPPED_PETRIFIED_OAK_WOOD);
                           entries.add(JinericItems.PETRIFIED_OAK_PLANKS);
                           entries.add(JinericItems.PETRIFIED_OAK_STAIRS);
                           entries.add(JinericItems.PETRIFIED_OAK_SLAB);
                           entries.add(JinericItems.PETRIFIED_OAK_FENCE);
                           entries.add(JinericItems.PETRIFIED_OAK_FENCE_GATE);
                           entries.add(JinericItems.PETRIFIED_OAK_DOOR);
                           entries.add(JinericItems.PETRIFIED_OAK_TRAPDOOR);
                           entries.add(JinericItems.PETRIFIED_OAK_PRESSURE_PLATE);
                           entries.add(JinericItems.PETRIFIED_OAK_BUTTON);
                           entries.add(JinericItems.PETRIFIED_OAK_LEAVES);
                           entries.add(JinericItems.PETRIFIED_OAK_SAPLING);
                           entries.add(JinericItems.PETRIFIED_OAK_LADDER);
                           entries.add(JinericItems.PETRIFIED_OAK_BOOKSHELF);
                           entries.add(JinericItems.PETRIFIED_OAK_SIGN);
                           entries.add(JinericItems.PETRIFIED_OAK_HANGING_SIGN);
                           entries.add(JinericItems.PETRIFIED_OAK_BOAT);
                           entries.add(JinericItems.PETRIFIED_OAK_CHEST_BOAT);
							entries.add(JinericItems.STONE_WALL);
							entries.add(JinericItems.SMOOTH_STONE_STAIRS);
							entries.add(JinericItems.SMOOTH_STONE_WALL);
							entries.add(JinericItems.POLISHED_STONE);
							entries.add(JinericItems.POLISHED_STONE_STAIRS);
							entries.add(JinericItems.POLISHED_STONE_SLAB);
							entries.add(JinericItems.POLISHED_STONE_WALL);
							entries.add(JinericItems.STONE_BRICK_PILLAR);
							entries.add(JinericItems.CRACKED_STONE_BRICK_STAIRS);
							entries.add(JinericItems.CRACKED_STONE_BRICK_SLAB);
							entries.add(JinericItems.CRACKED_STONE_BRICK_WALL);
							entries.add(JinericItems.STONE_TILES);
							entries.add(JinericItems.STONE_TILE_STAIRS);
							entries.add(JinericItems.STONE_TILE_SLAB);
							entries.add(JinericItems.STONE_TILE_WALL);
							entries.add(JinericItems.CRACKED_STONE_TILES);
							entries.add(JinericItems.CRACKED_STONE_TILE_STAIRS);
							entries.add(JinericItems.CRACKED_STONE_TILE_SLAB);
							entries.add(JinericItems.CRACKED_STONE_TILE_WALL);
							entries.add(JinericItems.SMOOTH_DEEPSLATE);
							entries.add(JinericItems.SMOOTH_DEEPSLATE_STAIRS);
							entries.add(JinericItems.SMOOTH_DEEPSLATE_SLAB);
							entries.add(JinericItems.SMOOTH_DEEPSLATE_WALL);
							entries.add(JinericItems.CRACKED_DEEPSLATE_BRICK_STAIRS);
							entries.add(JinericItems.CRACKED_DEEPSLATE_BRICK_SLAB);
							entries.add(JinericItems.CRACKED_DEEPSLATE_BRICK_WALL);
							entries.add(JinericItems.CRACKED_DEEPSLATE_TILE_STAIRS);
							entries.add(JinericItems.CRACKED_DEEPSLATE_TILE_SLAB);
							entries.add(JinericItems.CRACKED_DEEPSLATE_TILE_WALL);
							entries.add(JinericItems.SMOOTH_TUFF);
							entries.add(JinericItems.SMOOTH_TUFF_STAIRS);
							entries.add(JinericItems.SMOOTH_TUFF_SLAB);
							entries.add(JinericItems.SMOOTH_TUFF_WALL);
							entries.add(JinericItems.CRACKED_TUFF_BRICKS);
							entries.add(JinericItems.CRACKED_TUFF_BRICK_STAIRS);
							entries.add(JinericItems.CRACKED_TUFF_BRICK_SLAB);
							entries.add(JinericItems.CRACKED_TUFF_BRICK_WALL);
							entries.add(JinericItems.TUFF_BRICK_PILLAR);
							entries.add(JinericItems.TUFF_TILES);
							entries.add(JinericItems.TUFF_TILE_STAIRS);
							entries.add(JinericItems.TUFF_TILE_SLAB);
							entries.add(JinericItems.TUFF_TILE_WALL);
							entries.add(JinericItems.CRACKED_TUFF_TILES);
							entries.add(JinericItems.CRACKED_TUFF_TILE_STAIRS);
							entries.add(JinericItems.CRACKED_TUFF_TILE_SLAB);
							entries.add(JinericItems.CRACKED_TUFF_TILE_WALL);
							entries.add(JinericItems.DRIPSTONE_STAIRS);
							entries.add(JinericItems.DRIPSTONE_SLAB);
							entries.add(JinericItems.DRIPSTONE_WALL);
							entries.add(JinericItems.SMOOTH_DRIPSTONE);
							entries.add(JinericItems.SMOOTH_DRIPSTONE_STAIRS);
							entries.add(JinericItems.SMOOTH_DRIPSTONE_SLAB);
							entries.add(JinericItems.SMOOTH_DRIPSTONE_WALL);
							entries.add(JinericItems.POLISHED_DRIPSTONE);
							entries.add(JinericItems.POLISHED_DRIPSTONE_STAIRS);
							entries.add(JinericItems.POLISHED_DRIPSTONE_SLAB);
							entries.add(JinericItems.POLISHED_DRIPSTONE_WALL);
							entries.add(JinericItems.DRIPSTONE_BRICKS);
							entries.add(JinericItems.DRIPSTONE_BRICK_STAIRS);
							entries.add(JinericItems.DRIPSTONE_BRICK_SLAB);
							entries.add(JinericItems.DRIPSTONE_BRICK_WALL);
							entries.add(JinericItems.DRIPSTONE_BRICK_PILLAR);
							entries.add(JinericItems.CHISELED_DRIPSTONE_BRICKS);
							entries.add(JinericItems.CRACKED_DRIPSTONE_BRICKS);
							entries.add(JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
							entries.add(JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB);
							entries.add(JinericItems.CRACKED_DRIPSTONE_BRICK_WALL);
							entries.add(JinericItems.DRIPSTONE_TILES);
							entries.add(JinericItems.DRIPSTONE_TILE_STAIRS);
							entries.add(JinericItems.DRIPSTONE_TILE_SLAB);
							entries.add(JinericItems.DRIPSTONE_TILE_WALL);
							entries.add(JinericItems.CRACKED_DRIPSTONE_TILES);
							entries.add(JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS);
							entries.add(JinericItems.CRACKED_DRIPSTONE_TILE_SLAB);
							entries.add(JinericItems.CRACKED_DRIPSTONE_TILE_WALL);
							entries.add(JinericItems.FULL_GRASS_BLOCK);
							entries.add(JinericItems.SMOOTH_SANDSTONE_WALL);
							entries.add(JinericItems.CUT_SANDSTONE_STAIRS);
							entries.add(JinericItems.CUT_SANDSTONE_WALL);
							entries.add(JinericItems.POLISHED_SANDSTONE);
							entries.add(JinericItems.POLISHED_SANDSTONE_STAIRS);
							entries.add(JinericItems.POLISHED_SANDSTONE_SLAB);
							entries.add(JinericItems.POLISHED_SANDSTONE_WALL);
							entries.add(JinericItems.WAVY_SANDSTONE);
							entries.add(JinericItems.WAVY_SANDSTONE_STAIRS);
							entries.add(JinericItems.WAVY_SANDSTONE_SLAB);
							entries.add(JinericItems.WAVY_SANDSTONE_WALL);
							entries.add(JinericItems.SMOOTH_RED_SANDSTONE_WALL);
							entries.add(JinericItems.CUT_RED_SANDSTONE_STAIRS);
							entries.add(JinericItems.CUT_RED_SANDSTONE_WALL);
							entries.add(JinericItems.POLISHED_RED_SANDSTONE);
							entries.add(JinericItems.POLISHED_RED_SANDSTONE_STAIRS);
							entries.add(JinericItems.POLISHED_RED_SANDSTONE_SLAB);
							entries.add(JinericItems.POLISHED_RED_SANDSTONE_WALL);
							entries.add(JinericItems.WAVY_RED_SANDSTONE);
							entries.add(JinericItems.WAVY_RED_SANDSTONE_STAIRS);
							entries.add(JinericItems.WAVY_RED_SANDSTONE_SLAB);
							entries.add(JinericItems.WAVY_RED_SANDSTONE_WALL);
							entries.add(JinericItems.SOUL_SANDSTONE);
							entries.add(JinericItems.SOUL_SANDSTONE_STAIRS);
							entries.add(JinericItems.SOUL_SANDSTONE_SLAB);
							entries.add(JinericItems.SOUL_SANDSTONE_WALL);
							entries.add(JinericItems.CUT_SOUL_SANDSTONE);
							entries.add(JinericItems.CUT_SOUL_SANDSTONE_STAIRS);
							entries.add(JinericItems.CUT_SOUL_SANDSTONE_SLAB);
							entries.add(JinericItems.CUT_SOUL_SANDSTONE_WALL);
							entries.add(JinericItems.POLISHED_SOUL_SANDSTONE);
							entries.add(JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS);
							entries.add(JinericItems.POLISHED_SOUL_SANDSTONE_SLAB);
							entries.add(JinericItems.POLISHED_SOUL_SANDSTONE_WALL);
							entries.add(JinericItems.CHISELED_SOUL_SANDSTONE);
							entries.add(JinericItems.SMOOTH_SOUL_SANDSTONE);
							entries.add(JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS);
							entries.add(JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB);
							entries.add(JinericItems.SMOOTH_SOUL_SANDSTONE_WALL);
							entries.add(JinericItems.WAVY_SOUL_SANDSTONE);
							entries.add(JinericItems.WAVY_SOUL_SANDSTONE_STAIRS);
							entries.add(JinericItems.WAVY_SOUL_SANDSTONE_SLAB);
							entries.add(JinericItems.WAVY_SOUL_SANDSTONE_WALL);
							entries.add(JinericItems.DARK_PRISMARINE_WALL);
							entries.add(JinericItems.PRISMARINE_BRICK_WALL);
							entries.add(JinericItems.POLISHED_GRANITE_WALL);
							entries.add(JinericItems.POLISHED_DIORITE_WALL);
							entries.add(JinericItems.POLISHED_ANDESITE_WALL);
							entries.add(JinericItems.CALCITE_STAIRS);
							entries.add(JinericItems.CALCITE_SLAB);
							entries.add(JinericItems.CALCITE_WALL);
							entries.add(JinericItems.SNOW_BRICKS);
							entries.add(JinericItems.SNOW_BRICK_STAIRS);
							entries.add(JinericItems.SNOW_BRICK_SLAB);
							entries.add(JinericItems.SNOW_BRICK_WALL);
							entries.add(JinericItems.SNOW_WALL);
							entries.add(JinericItems.PACKED_ICE_STAIRS);
							entries.add(JinericItems.PACKED_ICE_SLAB);
							entries.add(JinericItems.PACKED_ICE_WALL);
							entries.add(JinericItems.OBSIDIAN_STAIRS);
							entries.add(JinericItems.OBSIDIAN_SLAB);
							entries.add(JinericItems.OBSIDIAN_WALL);
							entries.add(JinericItems.QUARTZ_WALL);
							entries.add(JinericItems.SMOOTH_QUARTZ_WALL);
							entries.add(JinericItems.QUARTZ_BRICK_STAIRS);
							entries.add(JinericItems.QUARTZ_BRICK_SLAB);
							entries.add(JinericItems.QUARTZ_BRICK_WALL);
							entries.add(JinericItems.CRACKED_NETHER_BRICK_STAIRS);
							entries.add(JinericItems.CRACKED_NETHER_BRICK_SLAB);
							entries.add(JinericItems.CRACKED_NETHER_BRICK_WALL);
							entries.add(JinericItems.RED_NETHER_BRICK_FENCE);
							entries.add(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
							entries.add(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
							entries.add(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);
							entries.add(JinericItems.SMOOTH_BASALT_STAIRS);
							entries.add(JinericItems.SMOOTH_BASALT_SLAB);
							entries.add(JinericItems.SMOOTH_BASALT_WALL);
							entries.add(JinericItems.PURPUR_WALL);
							entries.add(JinericItems.CUT_COPPER_WALL);
							entries.add(JinericItems.EXPOSED_CUT_COPPER_WALL);
							entries.add(JinericItems.WEATHERED_CUT_COPPER_WALL);
							entries.add(JinericItems.OXIDIZED_CUT_COPPER_WALL);
							entries.add(JinericItems.WAXED_CUT_COPPER_WALL);
							entries.add(JinericItems.WAXED_EXPOSED_CUT_COPPER_WALL);
							entries.add(JinericItems.WAXED_WEATHERED_CUT_COPPER_WALL);
							entries.add(JinericItems.WAXED_OXIDIZED_CUT_COPPER_WALL);
							entries.add(JinericItems.CHARCOAL_BLOCK);
							entries.add(JinericItems.FLINT_BLOCK);
							entries.add(JinericItems.BONE_MEAL_BLOCK);
							entries.add(JinericItems.PRISMARINE_CRYSTAL_BLOCK);
							entries.add(JinericItems.SUGAR_BLOCK);
							entries.add(JinericItems.ROTTEN_FLESH_BLOCK);
							entries.add(JinericItems.STICK_BLOCK);
							entries.add(JinericItems.EGG_BLOCK);
							entries.add(JinericItems.ENDER_PEARL_BLOCK);
							entries.add(JinericItems.PAPER_BLOCK);
							entries.add(JinericItems.BLAZE_ROD_BLOCK);
							entries.add(JinericItems.SPRUCE_BOOKSHELF);
							entries.add(JinericItems.BIRCH_BOOKSHELF);
							entries.add(JinericItems.JUNGLE_BOOKSHELF);
							entries.add(JinericItems.ACACIA_BOOKSHELF);
							entries.add(JinericItems.DARK_OAK_BOOKSHELF);
							entries.add(JinericItems.MANGROVE_BOOKSHELF);
							entries.add(JinericItems.CHERRY_BOOKSHELF);
							entries.add(JinericItems.BAMBOO_BOOKSHELF);
							entries.add(JinericItems.CRIMSON_BOOKSHELF);
							entries.add(JinericItems.WARPED_BOOKSHELF);
							entries.add(JinericItems.SPRUCE_CHEST);
							entries.add(JinericItems.BIRCH_CHEST);
							entries.add(JinericItems.JUNGLE_CHEST);
							entries.add(JinericItems.ACACIA_CHEST);
							entries.add(JinericItems.DARK_OAK_CHEST);
							entries.add(JinericItems.MANGROVE_CHEST);
							entries.add(JinericItems.CHERRY_CHEST);
							entries.add(JinericItems.BAMBOO_CHEST);
							entries.add(JinericItems.CRIMSON_CHEST);
							entries.add(JinericItems.WARPED_CHEST);
							entries.add(JinericItems.TRAPPED_SPRUCE_CHEST);
							entries.add(JinericItems.TRAPPED_BIRCH_CHEST);
							entries.add(JinericItems.TRAPPED_JUNGLE_CHEST);
							entries.add(JinericItems.TRAPPED_ACACIA_CHEST);
							entries.add(JinericItems.TRAPPED_DARK_OAK_CHEST);
							entries.add(JinericItems.TRAPPED_MANGROVE_CHEST);
							entries.add(JinericItems.TRAPPED_CHERRY_CHEST);
							entries.add(JinericItems.TRAPPED_BAMBOO_CHEST);
							entries.add(JinericItems.TRAPPED_CRIMSON_CHEST);
							entries.add(JinericItems.TRAPPED_WARPED_CHEST);
							entries.add(JinericItems.SPRUCE_LADDER);
							entries.add(JinericItems.BIRCH_LADDER);
							entries.add(JinericItems.JUNGLE_LADDER);
							entries.add(JinericItems.ACACIA_LADDER);
							entries.add(JinericItems.DARK_OAK_LADDER);
							entries.add(JinericItems.MANGROVE_LADDER);
							entries.add(JinericItems.CHERRY_LADDER);
							entries.add(JinericItems.BAMBOO_LADDER);
							entries.add(JinericItems.CRIMSON_LADDER);
							entries.add(JinericItems.WARPED_LADDER);
							entries.add(JinericItems.SOUL_JACK_O_LANTERN);
							entries.add(JinericItems.NETHERITE_HORSE_ARMOR);
							entries.add(JinericItems.REFINERY);
							entries.add(JinericItems.GOLDEN_POTATO);
							entries.add(JinericItems.GOLDEN_SWEET_BERRIES);
							entries.add(JinericItems.GOLDEN_BEETROOT);
							entries.add(JinericItems.REDSTONE_LANTERN);
							entries.add(JinericItems.REDSTONE_CAMPFIRE);
							entries.add(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE);
				}).build()
		);
	}

	public static void registerItemGroups() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries) -> {
			entries.addAfter(Items.BAMBOO_BUTTON, JinericItems.PETRIFIED_OAK_LOG);
			entries.addAfter(JinericItems.PETRIFIED_OAK_LOG, JinericItems.PETRIFIED_OAK_WOOD);
			entries.addAfter(JinericItems.PETRIFIED_OAK_WOOD, JinericItems.STRIPPED_PETRIFIED_OAK_LOG);
			entries.addAfter(JinericItems.STRIPPED_PETRIFIED_OAK_LOG, JinericItems.STRIPPED_PETRIFIED_OAK_WOOD);
			entries.addAfter(JinericItems.STRIPPED_PETRIFIED_OAK_WOOD, JinericItems.PETRIFIED_OAK_PLANKS);
			entries.addAfter(JinericItems.PETRIFIED_OAK_PLANKS, JinericItems.PETRIFIED_OAK_STAIRS);
			entries.addAfter(JinericItems.PETRIFIED_OAK_STAIRS, JinericItems.PETRIFIED_OAK_SLAB);
			entries.addAfter(JinericItems.PETRIFIED_OAK_SLAB, JinericItems.PETRIFIED_OAK_FENCE);
			entries.addAfter(JinericItems.PETRIFIED_OAK_FENCE, JinericItems.PETRIFIED_OAK_FENCE_GATE);
			entries.addAfter(JinericItems.PETRIFIED_OAK_FENCE_GATE, JinericItems.PETRIFIED_OAK_DOOR);
			entries.addAfter(JinericItems.PETRIFIED_OAK_DOOR, JinericItems.PETRIFIED_OAK_TRAPDOOR);
			entries.addAfter(JinericItems.PETRIFIED_OAK_TRAPDOOR, JinericItems.PETRIFIED_OAK_PRESSURE_PLATE);
			entries.addAfter(JinericItems.PETRIFIED_OAK_PRESSURE_PLATE, JinericItems.PETRIFIED_OAK_BUTTON);
			entries.addAfter(Items.WARPED_BUTTON, JinericItems.STICK_BLOCK);
			entries.addAfter(Items.STONE_SLAB, JinericItems.STONE_WALL);
			entries.addAfter(Items.SMOOTH_STONE, JinericItems.SMOOTH_STONE_STAIRS);
			entries.addAfter(Items.SMOOTH_STONE_SLAB, JinericItems.SMOOTH_STONE_WALL);
			entries.addBefore(Items.STONE_BRICK_STAIRS, Items.STONE_BRICKS);
			entries.addAfter(Items.STONE_BRICK_WALL, Items.CRACKED_STONE_BRICKS);
			entries.addAfter(Items.CRACKED_STONE_BRICKS, JinericItems.CRACKED_STONE_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_STONE_BRICK_STAIRS, JinericItems.CRACKED_STONE_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_STONE_BRICK_SLAB, JinericItems.CRACKED_STONE_BRICK_WALL);
			entries.addAfter(JinericItems.CRACKED_STONE_BRICK_WALL, JinericItems.STONE_BRICK_PILLAR);
			entries.addAfter(JinericItems.SMOOTH_STONE_WALL, JinericItems.POLISHED_STONE);
			entries.addAfter(JinericItems.POLISHED_STONE, JinericItems.POLISHED_STONE_STAIRS);
			entries.addAfter(JinericItems.POLISHED_STONE_STAIRS, JinericItems.POLISHED_STONE_SLAB);
			entries.addAfter(JinericItems.POLISHED_STONE_SLAB, JinericItems.POLISHED_STONE_WALL);
			entries.addAfter(Items.MOSSY_STONE_BRICK_WALL, JinericItems.STONE_TILES);
			entries.addAfter(JinericItems.STONE_TILES, JinericItems.STONE_TILE_STAIRS);
			entries.addAfter(JinericItems.STONE_TILE_STAIRS, JinericItems.STONE_TILE_SLAB);
			entries.addAfter(JinericItems.STONE_TILE_SLAB, JinericItems.STONE_TILE_WALL);
			entries.addAfter(JinericItems.STONE_TILE_WALL, JinericItems.CRACKED_STONE_TILES);
			entries.addAfter(JinericItems.CRACKED_STONE_TILES, JinericItems.CRACKED_STONE_TILE_STAIRS);
			entries.addAfter(JinericItems.CRACKED_STONE_TILE_STAIRS, JinericItems.CRACKED_STONE_TILE_SLAB);
			entries.addAfter(JinericItems.CRACKED_STONE_TILE_SLAB, JinericItems.CRACKED_STONE_TILE_WALL);
			entries.addAfter(Items.POLISHED_ANDESITE_SLAB, JinericItems.POLISHED_ANDESITE_WALL);
			entries.addAfter(Items.POLISHED_DIORITE_SLAB, JinericItems.POLISHED_DIORITE_WALL);
			entries.addAfter(Items.POLISHED_GRANITE_SLAB, JinericItems.POLISHED_GRANITE_WALL);
			entries.addAfter(Items.CHISELED_TUFF, JinericItems.SMOOTH_TUFF);
			entries.addAfter(JinericItems.SMOOTH_TUFF, JinericItems.SMOOTH_TUFF_STAIRS);
			entries.addAfter(JinericItems.SMOOTH_TUFF_STAIRS, JinericItems.SMOOTH_TUFF_SLAB);
			entries.addAfter(JinericItems.SMOOTH_TUFF_SLAB, JinericItems.SMOOTH_TUFF_WALL);
			entries.addAfter(Items.TUFF_BRICK_WALL, JinericItems.CRACKED_TUFF_BRICKS);
			entries.addAfter(JinericItems.CRACKED_TUFF_BRICKS, JinericItems.CRACKED_TUFF_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_TUFF_BRICK_STAIRS, JinericItems.CRACKED_TUFF_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_TUFF_BRICK_SLAB, JinericItems.CRACKED_TUFF_BRICK_WALL);
			entries.addAfter(JinericItems.CRACKED_TUFF_BRICKS, JinericItems.CRACKED_TUFF_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_TUFF_BRICK_STAIRS, JinericItems.CRACKED_TUFF_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_TUFF_BRICK_SLAB, JinericItems.CRACKED_TUFF_BRICK_WALL);
			entries.addAfter(JinericItems.CRACKED_TUFF_BRICK_WALL, JinericItems.TUFF_BRICK_PILLAR);
			entries.addAfter(Items.CHISELED_TUFF_BRICKS, JinericItems.TUFF_TILES);
			entries.addAfter(JinericItems.TUFF_TILES, JinericItems.TUFF_TILE_STAIRS);
			entries.addAfter(JinericItems.TUFF_TILE_STAIRS, JinericItems.TUFF_TILE_SLAB);
			entries.addAfter(JinericItems.TUFF_TILE_SLAB, JinericItems.TUFF_TILE_WALL);
			entries.addAfter(JinericItems.TUFF_TILE_WALL, JinericItems.CRACKED_TUFF_TILES);
			entries.addAfter(JinericItems.CRACKED_TUFF_TILES, JinericItems.CRACKED_TUFF_TILE_STAIRS);
			entries.addAfter(JinericItems.CRACKED_TUFF_TILE_STAIRS, JinericItems.CRACKED_TUFF_TILE_SLAB);
			entries.addAfter(JinericItems.CRACKED_TUFF_TILE_SLAB, JinericItems.CRACKED_TUFF_TILE_WALL);
			entries.addAfter(JinericItems.CRACKED_TUFF_TILE_WALL, Items.DRIPSTONE_BLOCK);
			entries.addAfter(Items.DRIPSTONE_BLOCK, JinericItems.DRIPSTONE_STAIRS);
			entries.addAfter(JinericItems.DRIPSTONE_STAIRS, JinericItems.DRIPSTONE_SLAB);
			entries.addAfter(JinericItems.DRIPSTONE_SLAB, JinericItems.DRIPSTONE_WALL);
			entries.addAfter(JinericItems.DRIPSTONE_WALL, JinericItems.SMOOTH_DRIPSTONE);
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
			entries.addAfter(JinericItems.DRIPSTONE_BRICK_WALL, JinericItems.DRIPSTONE_BRICK_PILLAR);
			entries.addAfter(JinericItems.DRIPSTONE_BRICK_PILLAR, JinericItems.CHISELED_DRIPSTONE_BRICKS);
			entries.addAfter(JinericItems.CHISELED_DRIPSTONE_BRICKS, JinericItems.CRACKED_DRIPSTONE_BRICKS);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICKS, JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS, JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB, JinericItems.CRACKED_DRIPSTONE_BRICK_WALL);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_WALL, JinericItems.DRIPSTONE_TILES);
			entries.addAfter(JinericItems.DRIPSTONE_TILES, JinericItems.DRIPSTONE_TILE_STAIRS);
			entries.addAfter(JinericItems.DRIPSTONE_TILE_STAIRS, JinericItems.DRIPSTONE_TILE_SLAB);
			entries.addAfter(JinericItems.DRIPSTONE_TILE_SLAB, JinericItems.DRIPSTONE_TILE_WALL);
			entries.addAfter(JinericItems.DRIPSTONE_TILE_WALL, JinericItems.CRACKED_DRIPSTONE_TILES);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_TILES, JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS, JinericItems.CRACKED_DRIPSTONE_TILE_SLAB);
			entries.addAfter(JinericItems.CRACKED_DRIPSTONE_TILE_SLAB, JinericItems.CRACKED_DRIPSTONE_TILE_WALL);
			entries.addAfter(Items.COBBLED_DEEPSLATE_WALL, JinericItems.SMOOTH_DEEPSLATE);
			entries.addAfter(JinericItems.SMOOTH_DEEPSLATE, JinericItems.SMOOTH_DEEPSLATE_STAIRS);
			entries.addAfter(JinericItems.SMOOTH_DEEPSLATE_STAIRS, JinericItems.SMOOTH_DEEPSLATE_SLAB);
			entries.addAfter(JinericItems.SMOOTH_DEEPSLATE_SLAB, JinericItems.SMOOTH_DEEPSLATE_WALL);
			entries.addAfter(Items.CRACKED_DEEPSLATE_BRICKS, JinericItems.CRACKED_DEEPSLATE_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_DEEPSLATE_BRICK_STAIRS, JinericItems.CRACKED_DEEPSLATE_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_DEEPSLATE_BRICK_SLAB, JinericItems.CRACKED_DEEPSLATE_BRICK_WALL);
			entries.addAfter(Items.CRACKED_DEEPSLATE_TILES, JinericItems.CRACKED_DEEPSLATE_TILE_STAIRS);
			entries.addAfter(JinericItems.CRACKED_DEEPSLATE_TILE_STAIRS, JinericItems.CRACKED_DEEPSLATE_TILE_SLAB);
			entries.addAfter(JinericItems.CRACKED_DEEPSLATE_TILE_SLAB, JinericItems.CRACKED_DEEPSLATE_TILE_WALL);
			entries.addAfter(Items.POLISHED_BLACKSTONE_BRICK_WALL, JinericItems.SOUL_SANDSTONE);
			entries.addAfter(JinericItems.SOUL_SANDSTONE, JinericItems.SOUL_SANDSTONE_STAIRS);
			entries.addAfter(JinericItems.SOUL_SANDSTONE_STAIRS, JinericItems.SOUL_SANDSTONE_SLAB);
			entries.addAfter(JinericItems.SOUL_SANDSTONE_SLAB, JinericItems.SOUL_SANDSTONE_WALL);
			entries.addAfter(JinericItems.SOUL_SANDSTONE_WALL, JinericItems.CHISELED_SOUL_SANDSTONE);
			entries.addAfter(JinericItems.CHISELED_SOUL_SANDSTONE, JinericItems.SMOOTH_SOUL_SANDSTONE);
			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE, JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS);
			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS, JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB);
			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB, JinericItems.SMOOTH_SOUL_SANDSTONE_WALL);
			entries.addAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_WALL, JinericItems.CUT_SOUL_SANDSTONE);
			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE, JinericItems.CUT_SOUL_SANDSTONE_STAIRS);
			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE_STAIRS, JinericItems.CUT_SOUL_SANDSTONE_SLAB);
			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE_SLAB, JinericItems.CUT_SOUL_SANDSTONE_WALL);
			entries.addAfter(JinericItems.CUT_SOUL_SANDSTONE_WALL, JinericItems.POLISHED_SOUL_SANDSTONE);
			entries.addAfter(JinericItems.POLISHED_SOUL_SANDSTONE, JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS);
			entries.addAfter(JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS, JinericItems.POLISHED_SOUL_SANDSTONE_SLAB);
			entries.addAfter(JinericItems.POLISHED_SOUL_SANDSTONE_SLAB, JinericItems.POLISHED_SOUL_SANDSTONE_WALL);
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
			entries.addAfter(JinericItems.POLISHED_RED_SANDSTONE_WALL, Items.PACKED_ICE);
			entries.addAfter(Items.PACKED_ICE, JinericItems.PACKED_ICE_STAIRS);
			entries.addAfter(JinericItems.PACKED_ICE_STAIRS, JinericItems.PACKED_ICE_SLAB);
			entries.addAfter(JinericItems.PACKED_ICE_SLAB, JinericItems.PACKED_ICE_WALL);
			entries.addAfter(JinericItems.PACKED_ICE_WALL, Items.SNOW_BLOCK);
			entries.addAfter(Items.SNOW_BLOCK, Items.SNOW);
			entries.addAfter(Items.SNOW, JinericItems.SNOW_WALL);
			entries.addAfter(Items.SEA_LANTERN, JinericItems.PRISMARINE_CRYSTAL_BLOCK);
			entries.addAfter(Items.PRISMARINE_BRICK_SLAB, JinericItems.PRISMARINE_BRICK_WALL);
			entries.addAfter(Items.DARK_PRISMARINE_SLAB, JinericItems.DARK_PRISMARINE_WALL);
			entries.addAfter(Items.SMOOTH_BASALT, JinericItems.SMOOTH_BASALT_STAIRS);
			entries.addAfter(JinericItems.SMOOTH_BASALT_STAIRS, JinericItems.SMOOTH_BASALT_SLAB);
			entries.addAfter(JinericItems.SMOOTH_BASALT_SLAB, JinericItems.SMOOTH_BASALT_WALL);
			entries.addBefore(Items.NETHERRACK, JinericItems.OBSIDIAN_WALL);
			entries.addBefore(JinericItems.OBSIDIAN_WALL, JinericItems.OBSIDIAN_SLAB);
			entries.addBefore(JinericItems.OBSIDIAN_SLAB, JinericItems.OBSIDIAN_STAIRS);
			entries.addBefore(JinericItems.OBSIDIAN_STAIRS, Items.OBSIDIAN);
			entries.addAfter(Items.CRACKED_NETHER_BRICKS, JinericItems.CRACKED_NETHER_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_NETHER_BRICK_STAIRS, JinericItems.CRACKED_NETHER_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_NETHER_BRICK_SLAB, JinericItems.CRACKED_NETHER_BRICK_WALL);
			entries.addAfter(Items.RED_NETHER_BRICK_WALL, JinericItems.RED_NETHER_BRICK_FENCE);
			entries.addAfter(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS, JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
			entries.addAfter(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
			entries.addAfter(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);
			entries.addAfter(JinericItems.POLISHED_SOUL_SANDSTONE_WALL, JinericItems.BLAZE_ROD_BLOCK);
			entries.addBefore(Items.COAL_BLOCK, JinericItems.FLINT_BLOCK);
			entries.addBefore(JinericItems.FLINT_BLOCK, JinericItems.PAPER_BLOCK);
			entries.addBefore(JinericItems.PAPER_BLOCK, JinericItems.SUGAR_BLOCK);
			entries.addBefore(JinericItems.SUGAR_BLOCK, JinericItems.EGG_BLOCK);
			entries.addBefore(JinericItems.EGG_BLOCK, JinericItems.ROTTEN_FLESH_BLOCK);
			entries.addAfter(Items.COAL_BLOCK, JinericItems.CHARCOAL_BLOCK);
			entries.addAfter(Items.PURPUR_SLAB, JinericItems.PURPUR_WALL);
			entries.addAfter(JinericItems.PURPUR_WALL, JinericItems.ENDER_PEARL_BLOCK);
			entries.addAfter(Items.QUARTZ_SLAB, JinericItems.QUARTZ_WALL);
			entries.addAfter(Items.QUARTZ_BRICKS, JinericItems.QUARTZ_BRICK_STAIRS);
			entries.addAfter(JinericItems.QUARTZ_BRICK_STAIRS, JinericItems.QUARTZ_BRICK_SLAB);
			entries.addAfter(JinericItems.QUARTZ_BRICK_SLAB, JinericItems.QUARTZ_BRICK_WALL);
			entries.addAfter(Items.SMOOTH_QUARTZ_SLAB, JinericItems.SMOOTH_QUARTZ_WALL);
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
			entries.addBefore(Items.GRASS_BLOCK, JinericItems.FULL_GRASS_BLOCK);
            entries.addAfter(Items.CHERRY_LOG, JinericItems.PETRIFIED_OAK_LOG);
            entries.addAfter(Items.CHERRY_LEAVES, JinericItems.PETRIFIED_OAK_LEAVES);
            entries.addAfter(Blocks.CHERRY_SAPLING, JinericBlocks.PETRIFIED_OAK_SAPLING);
			entries.addBefore(Items.BONE_BLOCK, JinericItems.BONE_MEAL_BLOCK);
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
			entries.addAfter(JinericItems.MANGROVE_LADDER, JinericItems.CHERRY_LADDER);
			entries.addAfter(JinericItems.CHERRY_LADDER, JinericItems.BAMBOO_LADDER);
			entries.addAfter(JinericItems.BAMBOO_LADDER, JinericItems.PETRIFIED_OAK_LADDER);
			entries.addAfter(JinericItems.PETRIFIED_OAK_LADDER, JinericItems.CRIMSON_LADDER);
			entries.addAfter(JinericItems.CRIMSON_LADDER, JinericItems.WARPED_LADDER);
			//BOOKSHELVES
			entries.addAfter(Items.BOOKSHELF, JinericItems.SPRUCE_BOOKSHELF);
			entries.addAfter(JinericItems.SPRUCE_BOOKSHELF, JinericItems.BIRCH_BOOKSHELF);
			entries.addAfter(JinericItems.BIRCH_BOOKSHELF, JinericItems.JUNGLE_BOOKSHELF);
			entries.addAfter(JinericItems.JUNGLE_BOOKSHELF, JinericItems.ACACIA_BOOKSHELF);
			entries.addAfter(JinericItems.ACACIA_BOOKSHELF, JinericItems.DARK_OAK_BOOKSHELF);
			entries.addAfter(JinericItems.DARK_OAK_BOOKSHELF, JinericItems.MANGROVE_BOOKSHELF);
			entries.addAfter(JinericItems.MANGROVE_BOOKSHELF, JinericItems.CHERRY_BOOKSHELF);
			entries.addAfter(JinericItems.CHERRY_BOOKSHELF, JinericItems.BAMBOO_BOOKSHELF);
			entries.addAfter(JinericItems.BAMBOO_BOOKSHELF, JinericItems.PETRIFIED_OAK_BOOKSHELF);
			entries.addAfter(JinericItems.PETRIFIED_OAK_BOOKSHELF, JinericItems.CRIMSON_BOOKSHELF);
			entries.addAfter(JinericItems.CRIMSON_BOOKSHELF, JinericItems.WARPED_BOOKSHELF);
			//CHESTS
			entries.addAfter(Items.CHEST, JinericItems.SPRUCE_CHEST);
			entries.addAfter(JinericItems.SPRUCE_CHEST, JinericItems.BIRCH_CHEST);
			entries.addAfter(JinericItems.BIRCH_CHEST, JinericItems.JUNGLE_CHEST);
			entries.addAfter(JinericItems.JUNGLE_CHEST, JinericItems.ACACIA_CHEST);
			entries.addAfter(JinericItems.ACACIA_CHEST, JinericItems.DARK_OAK_CHEST);
			entries.addAfter(JinericItems.DARK_OAK_CHEST, JinericItems.MANGROVE_CHEST);
			entries.addAfter(JinericItems.MANGROVE_CHEST, JinericItems.CHERRY_CHEST);
			entries.addAfter(JinericItems.CHERRY_CHEST, JinericItems.BAMBOO_CHEST);
			entries.addAfter(JinericItems.BAMBOO_CHEST, JinericItems.CRIMSON_CHEST);
			entries.addAfter(JinericItems.CRIMSON_CHEST, JinericItems.WARPED_CHEST);
			//SIGNS
			entries.addAfter(Items.BAMBOO_HANGING_SIGN, JinericItems.PETRIFIED_OAK_SIGN);
			entries.addAfter(JinericItems.PETRIFIED_OAK_SIGN, JinericItems.PETRIFIED_OAK_HANGING_SIGN);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries -> {
			entries.addAfter(Items.CHERRY_CHEST_BOAT, JinericItems.PETRIFIED_OAK_BOAT);
			entries.addAfter(JinericItems.PETRIFIED_OAK_BOAT, JinericItems.PETRIFIED_OAK_CHEST_BOAT);
		}));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register((entries -> {
			entries.addAfter(Items.REDSTONE_TORCH, JinericItems.REDSTONE_LANTERN);
			entries.addBefore(Items.BELL, JinericItems.REDSTONE_CAMPFIRE);
		}));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((entries -> {
			entries.addAfter(Items.DIAMOND_HORSE_ARMOR, JinericItems.NETHERITE_HORSE_ARMOR);
		}));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((entries -> {
			entries.addAfter(Items.BEETROOT, JinericItems.GOLDEN_BEETROOT);
			entries.addAfter(Items.POISONOUS_POTATO, JinericItems.GOLDEN_POTATO);
			entries.addAfter(Items.SWEET_BERRIES, JinericItems.GOLDEN_SWEET_BERRIES);
		}));
	}
}
