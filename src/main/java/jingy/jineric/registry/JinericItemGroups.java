package jingy.jineric.registry;

import jingy.jineric.base.JinericMain;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.collect.ImmutableMap;

import java.util.Map;

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
			.icon(() ->new ItemStack(JinericItems.POLISHED_DRIPSTONE))
			.entries((enabledFeatures, entries, operatorEnabled) -> {
				//STONE
				entries.add(JinericItems.CRACKED_STONE_BRICK_STAIRS);
				entries.add(JinericItems.CRACKED_STONE_BRICK_SLAB);
				entries.add(JinericItems.CRACKED_STONE_BRICK_WALL);
				entries.add(JinericItems.POLISHED_STONE);
				entries.add(JinericItems.POLISHED_STONE_STAIRS);
				entries.add(JinericItems.POLISHED_STONE_SLAB);
				entries.add(JinericItems.POLISHED_STONE_WALL);
				entries.add(JinericItems.STONE_TILES);
				entries.add(JinericItems.STONE_TILE_STAIRS);
				entries.add(JinericItems.STONE_TILE_SLAB);
				entries.add(JinericItems.STONE_TILE_WALL);
				entries.add(JinericItems.STONE_PILLAR);
				//DRIPSTONE
				entries.add(JinericItems.COBBLED_DRIPSTONE);
				entries.add(JinericItems.COBBLED_DRIPSTONE_STAIRS);
				entries.add(JinericItems.COBBLED_DRIPSTONE_SLAB);
				entries.add(JinericItems.COBBLED_DRIPSTONE_WALL);
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
				entries.add(JinericItems.DRIPSTONE_TILES);
				entries.add(JinericItems.DRIPSTONE_TILE_STAIRS);
				entries.add(JinericItems.DRIPSTONE_TILE_SLAB);
				entries.add(JinericItems.DRIPSTONE_TILE_WALL);
				entries.add(JinericItems.DRIPSTONE_PILLAR);
				entries.add(JinericItems.CHISELED_DRIPSTONE_BRICKS);
				//STORAGE BLOCKS
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

				//COPPER
				entries.add(JinericItems.CUT_COPPER_WALL);
				entries.add(JinericItems.EXPOSED_CUT_COPPER_WALL);
				entries.add(JinericItems.OXIDIZED_CUT_COPPER_WALL);
				entries.add(JinericItems.WEATHERED_CUT_COPPER_WALL);
				entries.add(JinericItems.WAXED_CUT_COPPER_WALL);
				entries.add(JinericItems.WAXED_EXPOSED_CUT_COPPER_WALL);
				entries.add(JinericItems.WAXED_OXIDIZED_CUT_COPPER_WALL);
				entries.add(JinericItems.WAXED_WEATHERED_CUT_COPPER_WALL);

				//OTHER
				entries.add(JinericItems.REDSTONE_CAMPFIRE);
				entries.add(JinericItems.REDSTONE_LANTERN);
				entries.add(JinericItems.REFINERY);
				entries.add(JinericItems.TUMBLEWEED);
				entries.add(JinericItems.SOUL_JACK_O_LANTERN);
				entries.add(JinericItems.SNOW_WALL);
				entries.add(JinericItems.SHULKER_CHEST);
				entries.add(JinericItems.SALT);
				entries.add(JinericItems.SALT_BLOCK);
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
//		ItemGroupEvents.modifyEntriesEvent(new Identifier(JinericMain.MOD_ID, "mod_items")).register();
	}
}
