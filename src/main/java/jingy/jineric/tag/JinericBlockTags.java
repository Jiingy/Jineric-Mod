package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class JinericBlockTags {
	public static final TagKey<Block> NOT_PICKAXE_WALL = registerBlockTag("not_pickaxe_wall");
	public static final TagKey<Block> SLIPPERY = registerBlockTag("slippery");
	public static final TagKey<Block> JM_GRASS_BLOCK_REPLACEABLE = registerBlockTag("jm_grass_block_replaceable");
	public static final TagKey<Block> WOODEN_BOOKSHELVES = registerBlockTag("wooden_bookshelves");
	public static final TagKey<Block> CHESTS = registerBlockTag("chests");
	public static final TagKey<Block> TRAPPED_CHESTS = registerBlockTag("trapped_chests");
	public static final TagKey<Block> WOODEN_CHESTS = registerBlockTag("wooden_chests");
	public static final TagKey<Block> WOODEN_TRAPPED_CHESTS = registerBlockTag("wooden_trapped_chests");
	public static final TagKey<Block> LADDERS = registerBlockTag("ladders");
	public static final TagKey<Block> WOODEN_LADDERS = registerBlockTag("wooden_ladders");
	
	public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = registerBlockTag("incorrect_for_emerald_tool");
	public static final TagKey<Block> BOOSTS_WOODEN_EQUIPMENT_LEVEL = registerBlockTag("boosts_wooden_equipment_level");
	public static final TagKey<Block> BOOSTS_STONE_EQUIPMENT_LEVEL = registerBlockTag("boosts_stone_equipment_level");
	public static final TagKey<Block> BOOSTS_COPPER_EQUIPMENT_LEVEL = registerBlockTag("boosts_copper_equipment_level");
	public static final TagKey<Block> BOOSTS_IRON_EQUIPMENT_LEVEL = registerBlockTag("boosts_iron_equipment_level");
	public static final TagKey<Block> BOOSTS_GOLD_EQUIPMENT_LEVEL = registerBlockTag("boosts_gold_equipment_level");
	public static final TagKey<Block> BOOSTS_DIAMOND_EQUIPMENT_LEVEL = registerBlockTag("boosts_diamond_equipment_level");
	public static final TagKey<Block> BOOSTS_NETHERITE_EQUIPMENT_LEVEL = registerBlockTag("boosts_netherite_equipment_level");
	
	private static TagKey<Block> registerBlockTag(String id) {
		return TagKey.create(BuiltInRegistries.BLOCK.key(), JinericMain.ofJineric(id));
	}
	
	public JinericBlockTags() {
	}
}
