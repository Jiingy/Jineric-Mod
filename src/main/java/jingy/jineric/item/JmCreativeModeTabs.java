package jingy.jineric.item;

import jingy.jineric.base.JinericMain;
import jingy.jineric.block.JinericBlocks;
import jingy.jineric.data.family.EquipmentFamilies;
import jingy.jineric.data.family.EquipmentFamily;
import jingy.jineric.item.equipment.JmEquipmentAssetKeys;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class JmCreativeModeTabs {
	private static final ResourceKey<CreativeModeTab> CONTENT_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, JinericMain.ofJineric("0_content"));
	private static final ResourceKey<CreativeModeTab> BLOCKS_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, JinericMain.ofJineric("1_blocks"));
	private static final ResourceKey<CreativeModeTab> ITEMS_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, JinericMain.ofJineric("2_items"));
	
	public static final CreativeModeTab CONTENT = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
			.title(Component.literal("Jineric Content"))
			.icon(() -> new ItemStack(JinericItems.PRISMARINE_CRYSTAL_BLOCK))
			.displayItems((context, entries) -> {
				entries.accept(JinericItems.STONE_WALL);
				entries.accept(JinericItems.SMOOTH_STONE_STAIRS);
				entries.accept(JinericItems.SMOOTH_STONE_WALL);
				entries.accept(JinericItems.POLISHED_STONE);
				entries.accept(JinericItems.POLISHED_STONE_STAIRS);
				entries.accept(JinericItems.POLISHED_STONE_SLAB);
				entries.accept(JinericItems.POLISHED_STONE_WALL);
				entries.accept(JinericItems.STONE_BRICK_PILLAR);
				entries.accept(JinericItems.CRACKED_STONE_BRICK_STAIRS);
				entries.accept(JinericItems.CRACKED_STONE_BRICK_SLAB);
				entries.accept(JinericItems.CRACKED_STONE_BRICK_WALL);
				entries.accept(JinericItems.STONE_TILES);
				entries.accept(JinericItems.STONE_TILE_STAIRS);
				entries.accept(JinericItems.STONE_TILE_SLAB);
				entries.accept(JinericItems.STONE_TILE_WALL);
				entries.accept(JinericItems.CRACKED_STONE_TILES);
				entries.accept(JinericItems.CRACKED_STONE_TILE_STAIRS);
				entries.accept(JinericItems.CRACKED_STONE_TILE_SLAB);
				entries.accept(JinericItems.CRACKED_STONE_TILE_WALL);
				entries.accept(JinericItems.SMOOTH_DEEPSLATE);
				entries.accept(JinericItems.SMOOTH_DEEPSLATE_STAIRS);
				entries.accept(JinericItems.SMOOTH_DEEPSLATE_SLAB);
				entries.accept(JinericItems.SMOOTH_DEEPSLATE_WALL);
				entries.accept(JinericItems.CRACKED_DEEPSLATE_BRICK_STAIRS);
				entries.accept(JinericItems.CRACKED_DEEPSLATE_BRICK_SLAB);
				entries.accept(JinericItems.CRACKED_DEEPSLATE_BRICK_WALL);
				entries.accept(JinericItems.CRACKED_DEEPSLATE_TILE_STAIRS);
				entries.accept(JinericItems.CRACKED_DEEPSLATE_TILE_SLAB);
				entries.accept(JinericItems.CRACKED_DEEPSLATE_TILE_WALL);
				entries.accept(JinericItems.SMOOTH_TUFF);
				entries.accept(JinericItems.SMOOTH_TUFF_STAIRS);
				entries.accept(JinericItems.SMOOTH_TUFF_SLAB);
				entries.accept(JinericItems.SMOOTH_TUFF_WALL);
				entries.accept(JinericItems.CRACKED_TUFF_BRICKS);
				entries.accept(JinericItems.CRACKED_TUFF_BRICK_STAIRS);
				entries.accept(JinericItems.CRACKED_TUFF_BRICK_SLAB);
				entries.accept(JinericItems.CRACKED_TUFF_BRICK_WALL);
				entries.accept(JinericItems.TUFF_BRICK_PILLAR);
				entries.accept(JinericItems.TUFF_TILES);
				entries.accept(JinericItems.TUFF_TILE_STAIRS);
				entries.accept(JinericItems.TUFF_TILE_SLAB);
				entries.accept(JinericItems.TUFF_TILE_WALL);
				entries.accept(JinericItems.CRACKED_TUFF_TILES);
				entries.accept(JinericItems.CRACKED_TUFF_TILE_STAIRS);
				entries.accept(JinericItems.CRACKED_TUFF_TILE_SLAB);
				entries.accept(JinericItems.CRACKED_TUFF_TILE_WALL);
				entries.accept(JinericItems.DRIPSTONE_STAIRS);
				entries.accept(JinericItems.DRIPSTONE_SLAB);
				entries.accept(JinericItems.DRIPSTONE_WALL);
				entries.accept(JinericItems.SMOOTH_DRIPSTONE);
				entries.accept(JinericItems.SMOOTH_DRIPSTONE_STAIRS);
				entries.accept(JinericItems.SMOOTH_DRIPSTONE_SLAB);
				entries.accept(JinericItems.SMOOTH_DRIPSTONE_WALL);
				entries.accept(JinericItems.POLISHED_DRIPSTONE);
				entries.accept(JinericItems.POLISHED_DRIPSTONE_STAIRS);
				entries.accept(JinericItems.POLISHED_DRIPSTONE_SLAB);
				entries.accept(JinericItems.POLISHED_DRIPSTONE_WALL);
				entries.accept(JinericItems.DRIPSTONE_BRICKS);
				entries.accept(JinericItems.DRIPSTONE_BRICK_STAIRS);
				entries.accept(JinericItems.DRIPSTONE_BRICK_SLAB);
				entries.accept(JinericItems.DRIPSTONE_BRICK_WALL);
				entries.accept(JinericItems.DRIPSTONE_BRICK_PILLAR);
				entries.accept(JinericItems.CHISELED_DRIPSTONE_BRICKS);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_BRICKS);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_BRICK_WALL);
				entries.accept(JinericItems.DRIPSTONE_TILES);
				entries.accept(JinericItems.DRIPSTONE_TILE_STAIRS);
				entries.accept(JinericItems.DRIPSTONE_TILE_SLAB);
				entries.accept(JinericItems.DRIPSTONE_TILE_WALL);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_TILES);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_TILE_SLAB);
				entries.accept(JinericItems.CRACKED_DRIPSTONE_TILE_WALL);
				entries.accept(JinericItems.FULL_GRASS_BLOCK);
				entries.accept(JinericItems.SMOOTH_SANDSTONE_WALL);
				entries.accept(JinericItems.CUT_SANDSTONE_STAIRS);
				entries.accept(JinericItems.CUT_SANDSTONE_WALL);
				entries.accept(JinericItems.POLISHED_SANDSTONE);
				entries.accept(JinericItems.POLISHED_SANDSTONE_STAIRS);
				entries.accept(JinericItems.POLISHED_SANDSTONE_SLAB);
				entries.accept(JinericItems.POLISHED_SANDSTONE_WALL);
				entries.accept(JinericItems.WAVY_SANDSTONE);
				entries.accept(JinericItems.WAVY_SANDSTONE_STAIRS);
				entries.accept(JinericItems.WAVY_SANDSTONE_SLAB);
				entries.accept(JinericItems.WAVY_SANDSTONE_WALL);
				entries.accept(JinericItems.SMOOTH_RED_SANDSTONE_WALL);
				entries.accept(JinericItems.CUT_RED_SANDSTONE_STAIRS);
				entries.accept(JinericItems.CUT_RED_SANDSTONE_WALL);
				entries.accept(JinericItems.POLISHED_RED_SANDSTONE);
				entries.accept(JinericItems.POLISHED_RED_SANDSTONE_STAIRS);
				entries.accept(JinericItems.POLISHED_RED_SANDSTONE_SLAB);
				entries.accept(JinericItems.POLISHED_RED_SANDSTONE_WALL);
				entries.accept(JinericItems.WAVY_RED_SANDSTONE);
				entries.accept(JinericItems.WAVY_RED_SANDSTONE_STAIRS);
				entries.accept(JinericItems.WAVY_RED_SANDSTONE_SLAB);
				entries.accept(JinericItems.WAVY_RED_SANDSTONE_WALL);
				entries.accept(JinericItems.SOUL_SANDSTONE);
				entries.accept(JinericItems.SOUL_SANDSTONE_STAIRS);
				entries.accept(JinericItems.SOUL_SANDSTONE_SLAB);
				entries.accept(JinericItems.SOUL_SANDSTONE_WALL);
				entries.accept(JinericItems.CUT_SOUL_SANDSTONE);
				entries.accept(JinericItems.CUT_SOUL_SANDSTONE_STAIRS);
				entries.accept(JinericItems.CUT_SOUL_SANDSTONE_SLAB);
				entries.accept(JinericItems.CUT_SOUL_SANDSTONE_WALL);
				entries.accept(JinericItems.POLISHED_SOUL_SANDSTONE);
				entries.accept(JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS);
				entries.accept(JinericItems.POLISHED_SOUL_SANDSTONE_SLAB);
				entries.accept(JinericItems.POLISHED_SOUL_SANDSTONE_WALL);
				entries.accept(JinericItems.CHISELED_SOUL_SANDSTONE);
				entries.accept(JinericItems.SMOOTH_SOUL_SANDSTONE);
				entries.accept(JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS);
				entries.accept(JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB);
				entries.accept(JinericItems.SMOOTH_SOUL_SANDSTONE_WALL);
				entries.accept(JinericItems.WAVY_SOUL_SANDSTONE);
				entries.accept(JinericItems.WAVY_SOUL_SANDSTONE_STAIRS);
				entries.accept(JinericItems.WAVY_SOUL_SANDSTONE_SLAB);
				entries.accept(JinericItems.WAVY_SOUL_SANDSTONE_WALL);
				entries.accept(JinericItems.DARK_PRISMARINE_WALL);
				entries.accept(JinericItems.PRISMARINE_BRICK_WALL);
				entries.accept(JinericItems.POLISHED_GRANITE_WALL);
				entries.accept(JinericItems.POLISHED_DIORITE_WALL);
				entries.accept(JinericItems.POLISHED_ANDESITE_WALL);
				entries.accept(JinericItems.CALCITE_STAIRS);
				entries.accept(JinericItems.CALCITE_SLAB);
				entries.accept(JinericItems.CALCITE_WALL);
				entries.accept(JinericItems.SNOW_BRICKS);
				entries.accept(JinericItems.SNOW_BRICK_STAIRS);
				entries.accept(JinericItems.SNOW_BRICK_SLAB);
				entries.accept(JinericItems.SNOW_BRICK_WALL);
				entries.accept(JinericItems.SNOW_WALL);
				entries.accept(JinericItems.PACKED_ICE_STAIRS);
				entries.accept(JinericItems.PACKED_ICE_SLAB);
				entries.accept(JinericItems.PACKED_ICE_WALL);
				entries.accept(JinericItems.OBSIDIAN_STAIRS);
				entries.accept(JinericItems.OBSIDIAN_SLAB);
				entries.accept(JinericItems.OBSIDIAN_WALL);
				entries.accept(JinericItems.QUARTZ_WALL);
				entries.accept(JinericItems.SMOOTH_QUARTZ_WALL);
				entries.accept(JinericItems.QUARTZ_BRICK_STAIRS);
				entries.accept(JinericItems.QUARTZ_BRICK_SLAB);
				entries.accept(JinericItems.QUARTZ_BRICK_WALL);
				entries.accept(JinericItems.CRACKED_NETHER_BRICK_STAIRS);
				entries.accept(JinericItems.CRACKED_NETHER_BRICK_SLAB);
				entries.accept(JinericItems.CRACKED_NETHER_BRICK_WALL);
				entries.accept(JinericItems.RED_NETHER_BRICK_FENCE);
				entries.accept(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
				entries.accept(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
				entries.accept(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);
				entries.accept(JinericItems.SMOOTH_BASALT_STAIRS);
				entries.accept(JinericItems.SMOOTH_BASALT_SLAB);
				entries.accept(JinericItems.SMOOTH_BASALT_WALL);
				entries.accept(JinericItems.PURPUR_WALL);
				entries.accept(JinericItems.CUT_COPPER_WALL.weathering().unaffected());
				entries.accept(JinericItems.CUT_COPPER_WALL.weathering().exposed());
				entries.accept(JinericItems.CUT_COPPER_WALL.weathering().weathered());
				entries.accept(JinericItems.CUT_COPPER_WALL.weathering().oxidized());
				entries.accept(JinericItems.CUT_COPPER_WALL.waxed().unaffected());
				entries.accept(JinericItems.CUT_COPPER_WALL.waxed().exposed());
				entries.accept(JinericItems.CUT_COPPER_WALL.waxed().weathered());
				entries.accept(JinericItems.CUT_COPPER_WALL.waxed().oxidized());
				entries.accept(JinericItems.CHARCOAL_BLOCK);
				entries.accept(JinericItems.FLINT_BLOCK);
				entries.accept(JinericItems.BONE_MEAL_BLOCK);
				entries.accept(JinericItems.PRISMARINE_CRYSTAL_BLOCK);
				entries.accept(JinericItems.SUGAR_BLOCK);
				entries.accept(JinericItems.ROTTEN_FLESH_BLOCK);
				entries.accept(JinericItems.STICK_BLOCK);
				entries.accept(JinericItems.EGG_BLOCK);
				entries.accept(JinericItems.ENDER_PEARL_BLOCK);
				entries.accept(JinericItems.PAPER_BLOCK);
				entries.accept(JinericItems.BLAZE_ROD_BLOCK);
				entries.accept(JinericItems.SPRUCE_BOOKSHELF);
				entries.accept(JinericItems.BIRCH_BOOKSHELF);
				entries.accept(JinericItems.JUNGLE_BOOKSHELF);
				entries.accept(JinericItems.ACACIA_BOOKSHELF);
				entries.accept(JinericItems.DARK_OAK_BOOKSHELF);
				entries.accept(JinericItems.MANGROVE_BOOKSHELF);
				entries.accept(JinericItems.CHERRY_BOOKSHELF);
				entries.accept(JinericItems.BAMBOO_BOOKSHELF);
				entries.accept(JinericItems.CRIMSON_BOOKSHELF);
				entries.accept(JinericItems.WARPED_BOOKSHELF);
				entries.accept(JinericItems.SPRUCE_CHEST);
				entries.accept(JinericItems.BIRCH_CHEST);
				entries.accept(JinericItems.JUNGLE_CHEST);
				entries.accept(JinericItems.ACACIA_CHEST);
				entries.accept(JinericItems.DARK_OAK_CHEST);
				entries.accept(JinericItems.MANGROVE_CHEST);
				entries.accept(JinericItems.CHERRY_CHEST);
				entries.accept(JinericItems.BAMBOO_CHEST);
				entries.accept(JinericItems.CRIMSON_CHEST);
				entries.accept(JinericItems.WARPED_CHEST);
				entries.accept(JinericItems.TRAPPED_SPRUCE_CHEST);
				entries.accept(JinericItems.TRAPPED_BIRCH_CHEST);
				entries.accept(JinericItems.TRAPPED_JUNGLE_CHEST);
				entries.accept(JinericItems.TRAPPED_ACACIA_CHEST);
				entries.accept(JinericItems.TRAPPED_DARK_OAK_CHEST);
				entries.accept(JinericItems.TRAPPED_MANGROVE_CHEST);
				entries.accept(JinericItems.TRAPPED_CHERRY_CHEST);
				entries.accept(JinericItems.TRAPPED_BAMBOO_CHEST);
				entries.accept(JinericItems.TRAPPED_CRIMSON_CHEST);
				entries.accept(JinericItems.TRAPPED_WARPED_CHEST);
				entries.accept(JinericItems.SPRUCE_LADDER);
				entries.accept(JinericItems.BIRCH_LADDER);
				entries.accept(JinericItems.JUNGLE_LADDER);
				entries.accept(JinericItems.ACACIA_LADDER);
				entries.accept(JinericItems.DARK_OAK_LADDER);
				entries.accept(JinericItems.MANGROVE_LADDER);
				entries.accept(JinericItems.CHERRY_LADDER);
				entries.accept(JinericItems.BAMBOO_LADDER);
				entries.accept(JinericItems.CRIMSON_LADDER);
				entries.accept(JinericItems.WARPED_LADDER);
				entries.accept(JinericItems.SOUL_JACK_O_LANTERN);
				entries.accept(JinericItems.REFINERY);
				entries.accept(JinericItems.GOLDEN_POTATO);
				entries.accept(JinericItems.GOLDEN_SWEET_BERRIES);
				entries.accept(JinericItems.GOLDEN_BEETROOT);
				entries.accept(JinericItems.REDSTONE_LANTERN);
				entries.accept(JinericItems.REDSTONE_CAMPFIRE);
				entries.accept(JinericItems.STONE_UPGRADE_SMITHING_TEMPLATE);
				entries.accept(JinericItems.COPPER_UPGRADE_SMITHING_TEMPLATE);
				entries.accept(JinericItems.IRON_UPGRADE_SMITHING_TEMPLATE);
				entries.accept(JinericItems.GOLD_UPGRADE_SMITHING_TEMPLATE);
				entries.accept(JinericItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
			}).build();
	
	public static final CreativeModeTab BLOCKS = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
			.title(Component.literal("Jineric Blocks"))
			.icon(() -> new ItemStack(JinericBlocks.REFINERY))
			.displayItems((context, entries) -> {
				DefaultedRegistry<Block> blocks = BuiltInRegistries.BLOCK;
				blocks.stream()
						.filter(block -> blocks.getKey(block).getNamespace().equals("jineric"))
						.sorted(Comparator.comparing(block -> blocks.getKey(block).getPath()))
						.forEach(block -> {
							entries.accept(block);
						});
			}).build();
	
	public static final CreativeModeTab ITEMS = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 2)
			.title(Component.literal("Jineric Items"))
			.icon(() -> new ItemStack(JinericItems.GOLDEN_SWEET_BERRIES))
			.displayItems((context, entries) -> {
				DefaultedRegistry<Item> items = BuiltInRegistries.ITEM;
				items.stream()
						.filter(item -> items.getKey(item).getNamespace().equals("jineric") && !(item instanceof BlockItem))
						.sorted(Comparator.comparing(item -> items.getKey(item).getPath()))
						.forEach(item -> {
							entries.accept(item);
						});
				addWoodEquipment(entries, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			}).build();
	
	public static void registerJinericItemGroups() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CONTENT_KEY, CONTENT);
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, BLOCKS_KEY, BLOCKS);
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEMS_KEY, ITEMS);
	}
	
	public static void modifyVanillaGroups() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((entries) -> {
			entries.insertAfter(Items.WARPED_BUTTON, JinericItems.STICK_BLOCK);
			entries.insertAfter(Items.STONE_SLAB, JinericItems.STONE_WALL);
			entries.insertAfter(Items.SMOOTH_STONE, JinericItems.SMOOTH_STONE_STAIRS);
			entries.insertAfter(Items.SMOOTH_STONE_SLAB, JinericItems.SMOOTH_STONE_WALL);
			entries.insertBefore(Items.STONE_BRICK_STAIRS, Items.STONE_BRICKS);
			entries.insertAfter(Items.STONE_BRICK_WALL, Items.CRACKED_STONE_BRICKS);
			entries.insertAfter(Items.CRACKED_STONE_BRICKS, JinericItems.CRACKED_STONE_BRICK_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_STONE_BRICK_STAIRS, JinericItems.CRACKED_STONE_BRICK_SLAB);
			entries.insertAfter(JinericItems.CRACKED_STONE_BRICK_SLAB, JinericItems.CRACKED_STONE_BRICK_WALL);
			entries.insertAfter(JinericItems.CRACKED_STONE_BRICK_WALL, JinericItems.STONE_BRICK_PILLAR);
			entries.insertAfter(JinericItems.SMOOTH_STONE_WALL, JinericItems.POLISHED_STONE);
			entries.insertAfter(JinericItems.POLISHED_STONE, JinericItems.POLISHED_STONE_STAIRS);
			entries.insertAfter(JinericItems.POLISHED_STONE_STAIRS, JinericItems.POLISHED_STONE_SLAB);
			entries.insertAfter(JinericItems.POLISHED_STONE_SLAB, JinericItems.POLISHED_STONE_WALL);
			entries.insertAfter(Items.MOSSY_STONE_BRICK_WALL, JinericItems.STONE_TILES);
			entries.insertAfter(JinericItems.STONE_TILES, JinericItems.STONE_TILE_STAIRS);
			entries.insertAfter(JinericItems.STONE_TILE_STAIRS, JinericItems.STONE_TILE_SLAB);
			entries.insertAfter(JinericItems.STONE_TILE_SLAB, JinericItems.STONE_TILE_WALL);
			entries.insertAfter(JinericItems.STONE_TILE_WALL, JinericItems.CRACKED_STONE_TILES);
			entries.insertAfter(JinericItems.CRACKED_STONE_TILES, JinericItems.CRACKED_STONE_TILE_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_STONE_TILE_STAIRS, JinericItems.CRACKED_STONE_TILE_SLAB);
			entries.insertAfter(JinericItems.CRACKED_STONE_TILE_SLAB, JinericItems.CRACKED_STONE_TILE_WALL);
			entries.insertAfter(Items.POLISHED_ANDESITE_SLAB, JinericItems.POLISHED_ANDESITE_WALL);
			entries.insertAfter(Items.POLISHED_DIORITE_SLAB, JinericItems.POLISHED_DIORITE_WALL);
			entries.insertAfter(Items.POLISHED_GRANITE_SLAB, JinericItems.POLISHED_GRANITE_WALL);
			entries.insertAfter(Items.CHISELED_TUFF, JinericItems.SMOOTH_TUFF);
			entries.insertAfter(JinericItems.SMOOTH_TUFF, JinericItems.SMOOTH_TUFF_STAIRS);
			entries.insertAfter(JinericItems.SMOOTH_TUFF_STAIRS, JinericItems.SMOOTH_TUFF_SLAB);
			entries.insertAfter(JinericItems.SMOOTH_TUFF_SLAB, JinericItems.SMOOTH_TUFF_WALL);
			entries.insertAfter(Items.TUFF_BRICK_WALL, JinericItems.CRACKED_TUFF_BRICKS);
			entries.insertAfter(JinericItems.CRACKED_TUFF_BRICKS, JinericItems.CRACKED_TUFF_BRICK_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_TUFF_BRICK_STAIRS, JinericItems.CRACKED_TUFF_BRICK_SLAB);
			entries.insertAfter(JinericItems.CRACKED_TUFF_BRICK_SLAB, JinericItems.CRACKED_TUFF_BRICK_WALL);
			entries.insertAfter(JinericItems.CRACKED_TUFF_BRICKS, JinericItems.CRACKED_TUFF_BRICK_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_TUFF_BRICK_STAIRS, JinericItems.CRACKED_TUFF_BRICK_SLAB);
			entries.insertAfter(JinericItems.CRACKED_TUFF_BRICK_SLAB, JinericItems.CRACKED_TUFF_BRICK_WALL);
			entries.insertAfter(JinericItems.CRACKED_TUFF_BRICK_WALL, JinericItems.TUFF_BRICK_PILLAR);
			entries.insertAfter(Items.CHISELED_TUFF_BRICKS, JinericItems.TUFF_TILES);
			entries.insertAfter(JinericItems.TUFF_TILES, JinericItems.TUFF_TILE_STAIRS);
			entries.insertAfter(JinericItems.TUFF_TILE_STAIRS, JinericItems.TUFF_TILE_SLAB);
			entries.insertAfter(JinericItems.TUFF_TILE_SLAB, JinericItems.TUFF_TILE_WALL);
			entries.insertAfter(JinericItems.TUFF_TILE_WALL, JinericItems.CRACKED_TUFF_TILES);
			entries.insertAfter(JinericItems.CRACKED_TUFF_TILES, JinericItems.CRACKED_TUFF_TILE_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_TUFF_TILE_STAIRS, JinericItems.CRACKED_TUFF_TILE_SLAB);
			entries.insertAfter(JinericItems.CRACKED_TUFF_TILE_SLAB, JinericItems.CRACKED_TUFF_TILE_WALL);
			entries.insertAfter(JinericItems.CRACKED_TUFF_TILE_WALL, Items.DRIPSTONE_BLOCK);
			entries.insertAfter(Items.DRIPSTONE_BLOCK, JinericItems.DRIPSTONE_STAIRS);
			entries.insertAfter(JinericItems.DRIPSTONE_STAIRS, JinericItems.DRIPSTONE_SLAB);
			entries.insertAfter(JinericItems.DRIPSTONE_SLAB, JinericItems.DRIPSTONE_WALL);
			entries.insertAfter(JinericItems.DRIPSTONE_WALL, JinericItems.SMOOTH_DRIPSTONE);
			entries.insertAfter(JinericItems.SMOOTH_DRIPSTONE, JinericItems.SMOOTH_DRIPSTONE_STAIRS);
			entries.insertAfter(JinericItems.SMOOTH_DRIPSTONE_STAIRS, JinericItems.SMOOTH_DRIPSTONE_SLAB);
			entries.insertAfter(JinericItems.SMOOTH_DRIPSTONE_SLAB, JinericItems.SMOOTH_DRIPSTONE_WALL);
			entries.insertAfter(JinericItems.SMOOTH_DRIPSTONE_WALL, JinericItems.POLISHED_DRIPSTONE);
			entries.insertAfter(JinericItems.POLISHED_DRIPSTONE, JinericItems.POLISHED_DRIPSTONE_STAIRS);
			entries.insertAfter(JinericItems.POLISHED_DRIPSTONE_STAIRS, JinericItems.POLISHED_DRIPSTONE_SLAB);
			entries.insertAfter(JinericItems.POLISHED_DRIPSTONE_SLAB, JinericItems.POLISHED_DRIPSTONE_WALL);
			entries.insertAfter(JinericItems.POLISHED_DRIPSTONE_WALL, JinericItems.DRIPSTONE_BRICKS);
			entries.insertAfter(JinericItems.DRIPSTONE_BRICKS, JinericItems.DRIPSTONE_BRICK_STAIRS);
			entries.insertAfter(JinericItems.DRIPSTONE_BRICK_STAIRS, JinericItems.DRIPSTONE_BRICK_SLAB);
			entries.insertAfter(JinericItems.DRIPSTONE_BRICK_SLAB, JinericItems.DRIPSTONE_BRICK_WALL);
			entries.insertAfter(JinericItems.DRIPSTONE_BRICK_WALL, JinericItems.DRIPSTONE_BRICK_PILLAR);
			entries.insertAfter(JinericItems.DRIPSTONE_BRICK_PILLAR, JinericItems.CHISELED_DRIPSTONE_BRICKS);
			entries.insertAfter(JinericItems.CHISELED_DRIPSTONE_BRICKS, JinericItems.CRACKED_DRIPSTONE_BRICKS);
			entries.insertAfter(JinericItems.CRACKED_DRIPSTONE_BRICKS, JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_STAIRS, JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB);
			entries.insertAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_SLAB, JinericItems.CRACKED_DRIPSTONE_BRICK_WALL);
			entries.insertAfter(JinericItems.CRACKED_DRIPSTONE_BRICK_WALL, JinericItems.DRIPSTONE_TILES);
			entries.insertAfter(JinericItems.DRIPSTONE_TILES, JinericItems.DRIPSTONE_TILE_STAIRS);
			entries.insertAfter(JinericItems.DRIPSTONE_TILE_STAIRS, JinericItems.DRIPSTONE_TILE_SLAB);
			entries.insertAfter(JinericItems.DRIPSTONE_TILE_SLAB, JinericItems.DRIPSTONE_TILE_WALL);
			entries.insertAfter(JinericItems.DRIPSTONE_TILE_WALL, JinericItems.CRACKED_DRIPSTONE_TILES);
			entries.insertAfter(JinericItems.CRACKED_DRIPSTONE_TILES, JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_DRIPSTONE_TILE_STAIRS, JinericItems.CRACKED_DRIPSTONE_TILE_SLAB);
			entries.insertAfter(JinericItems.CRACKED_DRIPSTONE_TILE_SLAB, JinericItems.CRACKED_DRIPSTONE_TILE_WALL);
			entries.insertAfter(Items.COBBLED_DEEPSLATE_WALL, JinericItems.SMOOTH_DEEPSLATE);
			entries.insertAfter(JinericItems.SMOOTH_DEEPSLATE, JinericItems.SMOOTH_DEEPSLATE_STAIRS);
			entries.insertAfter(JinericItems.SMOOTH_DEEPSLATE_STAIRS, JinericItems.SMOOTH_DEEPSLATE_SLAB);
			entries.insertAfter(JinericItems.SMOOTH_DEEPSLATE_SLAB, JinericItems.SMOOTH_DEEPSLATE_WALL);
			entries.insertAfter(Items.CRACKED_DEEPSLATE_BRICKS, JinericItems.CRACKED_DEEPSLATE_BRICK_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_DEEPSLATE_BRICK_STAIRS, JinericItems.CRACKED_DEEPSLATE_BRICK_SLAB);
			entries.insertAfter(JinericItems.CRACKED_DEEPSLATE_BRICK_SLAB, JinericItems.CRACKED_DEEPSLATE_BRICK_WALL);
			entries.insertAfter(Items.CRACKED_DEEPSLATE_TILES, JinericItems.CRACKED_DEEPSLATE_TILE_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_DEEPSLATE_TILE_STAIRS, JinericItems.CRACKED_DEEPSLATE_TILE_SLAB);
			entries.insertAfter(JinericItems.CRACKED_DEEPSLATE_TILE_SLAB, JinericItems.CRACKED_DEEPSLATE_TILE_WALL);
			entries.insertAfter(Items.POLISHED_BLACKSTONE_BRICK_WALL, JinericItems.SOUL_SANDSTONE);
			entries.insertAfter(JinericItems.SOUL_SANDSTONE, JinericItems.SOUL_SANDSTONE_STAIRS);
			entries.insertAfter(JinericItems.SOUL_SANDSTONE_STAIRS, JinericItems.SOUL_SANDSTONE_SLAB);
			entries.insertAfter(JinericItems.SOUL_SANDSTONE_SLAB, JinericItems.SOUL_SANDSTONE_WALL);
			entries.insertAfter(JinericItems.SOUL_SANDSTONE_WALL, JinericItems.CHISELED_SOUL_SANDSTONE);
			entries.insertAfter(JinericItems.CHISELED_SOUL_SANDSTONE, JinericItems.SMOOTH_SOUL_SANDSTONE);
			entries.insertAfter(JinericItems.SMOOTH_SOUL_SANDSTONE, JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS);
			entries.insertAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_STAIRS, JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB);
			entries.insertAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_SLAB, JinericItems.SMOOTH_SOUL_SANDSTONE_WALL);
			entries.insertAfter(JinericItems.SMOOTH_SOUL_SANDSTONE_WALL, JinericItems.CUT_SOUL_SANDSTONE);
			entries.insertAfter(JinericItems.CUT_SOUL_SANDSTONE, JinericItems.CUT_SOUL_SANDSTONE_STAIRS);
			entries.insertAfter(JinericItems.CUT_SOUL_SANDSTONE_STAIRS, JinericItems.CUT_SOUL_SANDSTONE_SLAB);
			entries.insertAfter(JinericItems.CUT_SOUL_SANDSTONE_SLAB, JinericItems.CUT_SOUL_SANDSTONE_WALL);
			entries.insertAfter(JinericItems.CUT_SOUL_SANDSTONE_WALL, JinericItems.POLISHED_SOUL_SANDSTONE);
			entries.insertAfter(JinericItems.POLISHED_SOUL_SANDSTONE, JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS);
			entries.insertAfter(JinericItems.POLISHED_SOUL_SANDSTONE_STAIRS, JinericItems.POLISHED_SOUL_SANDSTONE_SLAB);
			entries.insertAfter(JinericItems.POLISHED_SOUL_SANDSTONE_SLAB, JinericItems.POLISHED_SOUL_SANDSTONE_WALL);
			entries.insertAfter(Items.CUT_SANDSTONE, JinericItems.CUT_SANDSTONE_STAIRS);
			entries.insertAfter(Items.CUT_STANDSTONE_SLAB, JinericItems.CUT_SANDSTONE_WALL);
			entries.insertAfter(JinericItems.CUT_SANDSTONE_WALL, JinericItems.POLISHED_SANDSTONE);
			entries.insertAfter(JinericItems.POLISHED_SANDSTONE, JinericItems.POLISHED_SANDSTONE_STAIRS);
			entries.insertAfter(JinericItems.POLISHED_SANDSTONE_STAIRS, JinericItems.POLISHED_SANDSTONE_SLAB);
			entries.insertAfter(JinericItems.POLISHED_SANDSTONE_SLAB, JinericItems.POLISHED_SANDSTONE_WALL);
			entries.insertAfter(Items.CUT_RED_SANDSTONE, JinericItems.CUT_RED_SANDSTONE_STAIRS);
			entries.insertAfter(Items.CUT_RED_SANDSTONE_SLAB, JinericItems.CUT_RED_SANDSTONE_WALL);
			entries.insertAfter(JinericItems.CUT_RED_SANDSTONE_WALL, JinericItems.POLISHED_RED_SANDSTONE);
			entries.insertAfter(JinericItems.POLISHED_RED_SANDSTONE, JinericItems.POLISHED_RED_SANDSTONE_STAIRS);
			entries.insertAfter(JinericItems.POLISHED_RED_SANDSTONE_STAIRS, JinericItems.POLISHED_RED_SANDSTONE_SLAB);
			entries.insertAfter(JinericItems.POLISHED_RED_SANDSTONE_SLAB, JinericItems.POLISHED_RED_SANDSTONE_WALL);
			entries.insertAfter(JinericItems.POLISHED_RED_SANDSTONE_WALL, Items.PACKED_ICE);
			entries.insertAfter(Items.PACKED_ICE, JinericItems.PACKED_ICE_STAIRS);
			entries.insertAfter(JinericItems.PACKED_ICE_STAIRS, JinericItems.PACKED_ICE_SLAB);
			entries.insertAfter(JinericItems.PACKED_ICE_SLAB, JinericItems.PACKED_ICE_WALL);
			entries.insertAfter(JinericItems.PACKED_ICE_WALL, Items.SNOW_BLOCK);
			entries.insertAfter(Items.SNOW_BLOCK, Items.SNOW);
			entries.insertAfter(Items.SNOW, JinericItems.SNOW_WALL);
			entries.insertAfter(Items.SEA_LANTERN, JinericItems.PRISMARINE_CRYSTAL_BLOCK);
			entries.insertAfter(Items.PRISMARINE_BRICK_SLAB, JinericItems.PRISMARINE_BRICK_WALL);
			entries.insertAfter(Items.DARK_PRISMARINE_SLAB, JinericItems.DARK_PRISMARINE_WALL);
			entries.insertAfter(Items.SMOOTH_BASALT, JinericItems.SMOOTH_BASALT_STAIRS);
			entries.insertAfter(JinericItems.SMOOTH_BASALT_STAIRS, JinericItems.SMOOTH_BASALT_SLAB);
			entries.insertAfter(JinericItems.SMOOTH_BASALT_SLAB, JinericItems.SMOOTH_BASALT_WALL);
			entries.insertBefore(Items.NETHERRACK, JinericItems.OBSIDIAN_WALL);
			entries.insertBefore(JinericItems.OBSIDIAN_WALL, JinericItems.OBSIDIAN_SLAB);
			entries.insertBefore(JinericItems.OBSIDIAN_SLAB, JinericItems.OBSIDIAN_STAIRS);
			entries.insertBefore(JinericItems.OBSIDIAN_STAIRS, Items.OBSIDIAN);
			entries.insertAfter(Items.CRACKED_NETHER_BRICKS, JinericItems.CRACKED_NETHER_BRICK_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_NETHER_BRICK_STAIRS, JinericItems.CRACKED_NETHER_BRICK_SLAB);
			entries.insertAfter(JinericItems.CRACKED_NETHER_BRICK_SLAB, JinericItems.CRACKED_NETHER_BRICK_WALL);
			entries.insertAfter(Items.RED_NETHER_BRICK_WALL, JinericItems.RED_NETHER_BRICK_FENCE);
			entries.insertAfter(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS, JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
			entries.insertAfter(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
			entries.insertAfter(JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, JinericItems.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);
			entries.insertAfter(JinericItems.POLISHED_SOUL_SANDSTONE_WALL, JinericItems.BLAZE_ROD_BLOCK);
			entries.insertBefore(Items.COAL_BLOCK, JinericItems.FLINT_BLOCK);
			entries.insertBefore(JinericItems.FLINT_BLOCK, JinericItems.PAPER_BLOCK);
			entries.insertBefore(JinericItems.PAPER_BLOCK, JinericItems.SUGAR_BLOCK);
			entries.insertBefore(JinericItems.SUGAR_BLOCK, JinericItems.EGG_BLOCK);
			entries.insertBefore(JinericItems.EGG_BLOCK, JinericItems.ROTTEN_FLESH_BLOCK);
			entries.insertAfter(Items.COAL_BLOCK, JinericItems.CHARCOAL_BLOCK);
			entries.insertAfter(Items.PURPUR_SLAB, JinericItems.PURPUR_WALL);
			entries.insertAfter(JinericItems.PURPUR_WALL, JinericItems.ENDER_PEARL_BLOCK);
			entries.insertAfter(Items.QUARTZ_SLAB, JinericItems.QUARTZ_WALL);
			entries.insertAfter(Items.QUARTZ_BRICKS, JinericItems.QUARTZ_BRICK_STAIRS);
			entries.insertAfter(JinericItems.QUARTZ_BRICK_STAIRS, JinericItems.QUARTZ_BRICK_SLAB);
			entries.insertAfter(JinericItems.QUARTZ_BRICK_SLAB, JinericItems.QUARTZ_BRICK_WALL);
			entries.insertAfter(Items.SMOOTH_QUARTZ_SLAB, JinericItems.SMOOTH_QUARTZ_WALL);
			entries.insertAfter(Items.CUT_COPPER_SLAB.weathering().oxidized(), JinericItems.CUT_COPPER_WALL.weathering().unaffected());
			entries.insertAfter(JinericItems.CUT_COPPER_WALL.weathering().unaffected(), JinericItems.CUT_COPPER_WALL.weathering().exposed());
			entries.insertAfter(JinericItems.CUT_COPPER_WALL.weathering().exposed(), JinericItems.CUT_COPPER_WALL.weathering().weathered());
			entries.insertAfter(JinericItems.CUT_COPPER_WALL.weathering().weathered(), JinericItems.CUT_COPPER_WALL.weathering().oxidized());
			entries.insertAfter(Items.CUT_COPPER_SLAB.waxed().oxidized(), JinericItems.CUT_COPPER_WALL.waxed().unaffected());
			entries.insertAfter(JinericItems.CUT_COPPER_WALL.waxed().unaffected(), JinericItems.CUT_COPPER_WALL.waxed().exposed());
			entries.insertAfter(JinericItems.CUT_COPPER_WALL.waxed().exposed(), JinericItems.CUT_COPPER_WALL.waxed().weathered());;
			entries.insertAfter(JinericItems.CUT_COPPER_WALL.waxed().weathered(), JinericItems.CUT_COPPER_WALL.waxed().oxidized());
			entries.insertAfter(Items.SMOOTH_SANDSTONE_SLAB, JinericItems.SMOOTH_SANDSTONE_WALL);
			entries.insertAfter(Items.SMOOTH_RED_SANDSTONE_SLAB, JinericItems.SMOOTH_RED_SANDSTONE_WALL);
			entries.insertAfter(Items.SMOOTH_SANDSTONE_SLAB, JinericItems.SMOOTH_SANDSTONE_WALL);
		});
		
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((entries -> {
			entries.insertBefore(Items.GRASS_BLOCK, JinericItems.FULL_GRASS_BLOCK);
			entries.insertBefore(Items.BONE_BLOCK, JinericItems.BONE_MEAL_BLOCK);
			entries.insertAfter(Items.JACK_O_LANTERN, JinericItems.SOUL_JACK_O_LANTERN);
		}));

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register((entries) -> {
			entries.insertAfter(Items.SOUL_LANTERN, JinericItems.REDSTONE_LANTERN);
			entries.insertAfter(Items.SOUL_CAMPFIRE, JinericItems.REDSTONE_CAMPFIRE);
			//LADDERS
			entries.insertAfter(Items.LADDER, JinericItems.SPRUCE_LADDER);
			entries.insertAfter(JinericItems.SPRUCE_LADDER, JinericItems.BIRCH_LADDER);
			entries.insertAfter(JinericItems.BIRCH_LADDER, JinericItems.JUNGLE_LADDER);
			entries.insertAfter(JinericItems.JUNGLE_LADDER, JinericItems.ACACIA_LADDER);
			entries.insertAfter(JinericItems.ACACIA_LADDER, JinericItems.DARK_OAK_LADDER);
			entries.insertAfter(JinericItems.DARK_OAK_LADDER, JinericItems.MANGROVE_LADDER);
			entries.insertAfter(JinericItems.MANGROVE_LADDER, JinericItems.CHERRY_LADDER);
			entries.insertAfter(JinericItems.CHERRY_LADDER, JinericItems.BAMBOO_LADDER);
			entries.insertAfter(JinericItems.BAMBOO_LADDER, JinericItems.CRIMSON_LADDER);
			entries.insertAfter(JinericItems.CRIMSON_LADDER, JinericItems.WARPED_LADDER);
			//BOOKSHELVES
			entries.insertAfter(Items.BOOKSHELF, JinericItems.SPRUCE_BOOKSHELF);
			entries.insertAfter(JinericItems.SPRUCE_BOOKSHELF, JinericItems.BIRCH_BOOKSHELF);
			entries.insertAfter(JinericItems.BIRCH_BOOKSHELF, JinericItems.JUNGLE_BOOKSHELF);
			entries.insertAfter(JinericItems.JUNGLE_BOOKSHELF, JinericItems.ACACIA_BOOKSHELF);
			entries.insertAfter(JinericItems.ACACIA_BOOKSHELF, JinericItems.DARK_OAK_BOOKSHELF);
			entries.insertAfter(JinericItems.DARK_OAK_BOOKSHELF, JinericItems.MANGROVE_BOOKSHELF);
			entries.insertAfter(JinericItems.MANGROVE_BOOKSHELF, JinericItems.CHERRY_BOOKSHELF);
			entries.insertAfter(JinericItems.CHERRY_BOOKSHELF, JinericItems.BAMBOO_BOOKSHELF);
			entries.insertAfter(JinericItems.BAMBOO_BOOKSHELF, JinericItems.CRIMSON_BOOKSHELF);
			entries.insertAfter(JinericItems.CRIMSON_BOOKSHELF, JinericItems.WARPED_BOOKSHELF);
			//CHESTS
			entries.insertAfter(Items.CHEST, JinericItems.SPRUCE_CHEST);
			entries.insertAfter(JinericItems.SPRUCE_CHEST, JinericItems.BIRCH_CHEST);
			entries.insertAfter(JinericItems.BIRCH_CHEST, JinericItems.JUNGLE_CHEST);
			entries.insertAfter(JinericItems.JUNGLE_CHEST, JinericItems.ACACIA_CHEST);
			entries.insertAfter(JinericItems.ACACIA_CHEST, JinericItems.DARK_OAK_CHEST);
			entries.insertAfter(JinericItems.DARK_OAK_CHEST, JinericItems.MANGROVE_CHEST);
			entries.insertAfter(JinericItems.MANGROVE_CHEST, JinericItems.CHERRY_CHEST);
			entries.insertAfter(JinericItems.CHERRY_CHEST, JinericItems.BAMBOO_CHEST);
			entries.insertAfter(JinericItems.BAMBOO_CHEST, JinericItems.CRIMSON_CHEST);
			entries.insertAfter(JinericItems.CRIMSON_CHEST, JinericItems.WARPED_CHEST);
		});
		
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS).register((entries -> {
			entries.insertAfter(Items.REDSTONE_TORCH, JinericItems.REDSTONE_LANTERN);
			entries.insertBefore(Items.BELL, JinericItems.REDSTONE_CAMPFIRE);
		}));
		
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((entries -> {
		}));
		
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register((entries -> {
			entries.insertAfter(Items.BEETROOT, JinericItems.GOLDEN_BEETROOT);
			entries.insertAfter(Items.POISONOUS_POTATO, JinericItems.GOLDEN_POTATO);
			entries.insertAfter(Items.SWEET_BERRIES, JinericItems.GOLDEN_SWEET_BERRIES);
		}));
	}
	
	private static void addWoodEquipment(CreativeModeTab.Output entries, CreativeModeTab.TabVisibility visibility) {
		EquipmentFamily family = EquipmentFamilies.WOODEN;
		
		family.getVariants().forEach((variant, item) -> {
			for (WoodType woodType : WoodType.values().toList()) {
				String woodTypeName = woodType.name();
				String woodTypeVariant = woodTypeName + "_" + variant;
				ItemStack itemStack = new ItemStack(item);
				Component text = Component.translatable("item.jineric." + woodTypeVariant);
				itemStack.set(DataComponents.ITEM_NAME, text);
				itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(), List.of(woodTypeVariant), List.of()));
				
				if (variant.isArmor()) {
					itemStack.set(
							DataComponents.EQUIPPABLE,
							Equippable.builder(variant.equipmentSlot())
									.setAsset(JmEquipmentAssetKeys.parseWoodenKey(woodTypeName))
									.build()
					);
				}
				entries.accept(itemStack, visibility);
			}
		});
	}
	
	private static String getItemPath(Item item) {
		return BuiltInRegistries.ITEM.getKey(item).getPath();
	}
}
