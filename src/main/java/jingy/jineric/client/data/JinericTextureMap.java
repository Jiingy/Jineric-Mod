package jingy.jineric.client.data;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.data.TextureKey;
import net.minecraft.client.data.TextureMap;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class JinericTextureMap {
	
	public static TextureMap bareSideEnd(Block side, Block end) {
		return new TextureMap().put(TextureKey.SIDE, TextureMap.getId(side)).put(TextureKey.END, TextureMap.getId(end));
	}
	
	public static TextureMap bareSideEnd(Block block) {
		return new TextureMap().put(TextureKey.SIDE, TextureMap.getId(block)).put(TextureKey.END, TextureMap.getId(block));
	}
	
	public static TextureMap sidedSlab(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		Block slabBlock = blockFamily.getVariant(BlockFamily.Variant.SLAB);
		// Subject to change later
		return new TextureMap()
				.put(TextureKey.TOP, TextureMap.getId(baseBlock))
				.put(TextureKey.SIDE, TextureMap.getSubId(slabBlock, "_side"))
				.put(TextureKey.BOTTOM, TextureMap.getId(baseBlock))
				.put(TextureKey.END, TextureMap.getId(baseBlock));
	}
	
	public static TextureMap borderStairs(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		Block stairsBlock = blockFamily.getVariant(BlockFamily.Variant.STAIRS);
		// Subject to change later
		return new TextureMap()
				.put(TextureKey.TOP, TextureMap.getId(baseBlock))
				.put(TextureKey.SIDE, TextureMap.getId(baseBlock))
				.put(TextureKey.BOTTOM, TextureMap.getId(baseBlock));
	}
	
	public static TextureMap borderWall(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		Block wallBlock = blockFamily.getVariant(BlockFamily.Variant.WALL);
		return new TextureMap()
				.put(TextureKey.END, TextureMap.getSubId(wallBlock, "_end"))
				.put(JinericTextureKey.SIDE_SHORT, TextureMap.getSubId(wallBlock, "_side_short"))
				.put(TextureKey.SIDE, TextureMap.getId(baseBlock))
				.put(JinericTextureKey.SIDE_LINE_END, TextureMap.getSubId(wallBlock, "_side_line_end"))
				.put(TextureKey.TOP, TextureMap.getSubId(wallBlock, "_top"));
	}
	
	public static TextureMap topBottomShort(BlockFamily blockFamily) {
		Block baseBlock = blockFamily.getBaseBlock();
		return new TextureMap()
				.put(TextureKey.TOP, TextureMap.getSubId(baseBlock, "_top"))
				.put(TextureKey.BOTTOM, TextureMap.getSubId(baseBlock, "_bottom"))
				.put(TextureKey.SIDE, TextureMap.getId(baseBlock))
				.put(JinericTextureKey.SIDE_SHORT, TextureMap.getSubId(baseBlock, "_short"));
	}
	
	public static TextureMap columnShort(BlockFamily blockFamily, @Nullable BlockFamily blockTopFix) {
		Block baseBlock = blockFamily.getBaseBlock();
		return new TextureMap()
				// Sandstone texture naming sucks, this circumvents it in a lazy way.
				.put(TextureKey.END, TextureMap.getSubId(blockTopFix != null ? blockTopFix.getBaseBlock() : blockFamily.getBaseBlock(), "_top"))
				.put(TextureKey.SIDE, TextureMap.getId(baseBlock))
				.put(JinericTextureKey.SIDE_SHORT, JinericTextureMap.getMcSubIdToJineric(baseBlock, "_short"));
	}
	
	public static Identifier getMcSubIdToJineric(Block block, String suffix) {
		Identifier identifier = Registries.BLOCK.getId(block);
		return JinericMain.ofJineric(identifier.getPath()).withPath(path -> "block/" + path + suffix);
	}
}
