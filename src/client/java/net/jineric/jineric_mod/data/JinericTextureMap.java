package net.jineric.jineric_mod.data;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class JinericTextureMap {
	
	public static TextureMapping bareSideEnd(Block side, Block end) {
		return new TextureMapping().put(TextureSlot.SIDE, TextureMapping.getBlockTexture(side)).put(TextureSlot.END, TextureMapping.getBlockTexture(end));
	}
	
	public static TextureMapping bareSideEnd(Block block) {
		return new TextureMapping().put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block)).put(TextureSlot.END, TextureMapping.getBlockTexture(block));
	}
	
	public static TextureMapping sidedSlab(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		Block slabBlock = blockFamily.get(BlockFamily.Variant.SLAB);
		// Subject to change later
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(baseBlock))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(slabBlock, "_side"))
				.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(baseBlock))
				.put(TextureSlot.END, TextureMapping.getBlockTexture(baseBlock));
	}
	
	public static TextureMapping borderStairs(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		Block stairsBlock = blockFamily.get(BlockFamily.Variant.STAIRS);
		// Subject to change later
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(baseBlock))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(baseBlock))
				.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(baseBlock));
	}
	
	public static TextureMapping borderWall(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		Block wallBlock = blockFamily.get(BlockFamily.Variant.WALL);
		return new TextureMapping()
				.put(TextureSlot.END, TextureMapping.getBlockTexture(wallBlock, "_end"))
				.put(JinericTextureKey.SIDE_SHORT, TextureMapping.getBlockTexture(wallBlock, "_side_short"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(baseBlock))
				.put(JinericTextureKey.SIDE_LINE_END, TextureMapping.getBlockTexture(wallBlock, "_side_line_end"))
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(wallBlock, "_top"));
	}
	
	public static TextureMapping topBottomShort(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		return new TextureMapping()
				.put(TextureSlot.TOP, TextureMapping.getBlockTexture(baseBlock, "_top"))
				.put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(baseBlock, "_bottom"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(baseBlock))
				.put(JinericTextureKey.SIDE_SHORT, TextureMapping.getBlockTexture(baseBlock, "_short"));
	}
	
	public static TextureMapping columnShort(BlockFamily blockFamily, @Nullable BlockFamily blockTopFix) {
		Block baseBlock = blockFamily.getBaseBlock();
		return new TextureMapping()
				// Sandstone texture naming sucks, this circumvents it in a lazy way.
				.put(TextureSlot.END, TextureMapping.getBlockTexture(blockTopFix != null ? blockTopFix.getBaseBlock() : blockFamily.getBaseBlock(), "_top"))
				.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(baseBlock))
				.put(JinericTextureKey.SIDE_SHORT, JinericTextureMap.getMcSubIdToJineric(baseBlock, "_short"));
	}
	
	public static Material getMcSubIdToJineric(Block block, String suffix) {
		Identifier identifier = BuiltInRegistries.BLOCK.getKey(block);
		return new Material(JinericMain.ofJineric(identifier.getPath()).withPath(path -> "block/" + path + suffix));
	}
}
