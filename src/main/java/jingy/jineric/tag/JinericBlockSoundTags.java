package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

public class JinericBlockSoundTags {
	public static final TagKey<Block> VEGETATION_SOUNDS = register("vegetation_sounds");
	public static final TagKey<Block> WOODEN_BLOCK_SOUNDS = register("wooden_block_sounds");
	public static final TagKey<Block> WOODEN_NETHER_BLOCK_SOUNDS = register("wooden_nether_block_sounds");
	public static final TagKey<Block> WOODEN_ACCESSORY_SOUNDS = register("wooden_accessory_sounds");
	public static final TagKey<Block> MUSHROOM_SOUNDS = register("mushroom_sounds");
	public static final TagKey<Block> LEAF_SOUNDS = register("leaf_sounds");
	
	private static TagKey<Block> register(String id) {
		return TagKey.of(Registries.BLOCK.getKey(), JinericMain.ofJineric("sounds/" + id));
	}
	
	public static void initialize() {}
}
