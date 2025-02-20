package jingy.jineric.client.data;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class JinericModels {
	public static final Model TEMPLATE_COLUMN_SHORT_WALL_POST = block("template_column_short_wall_post", "_post", TextureKey.END, TextureKey.SIDE);
	public static final Model TEMPLATE_COLUMN_SHORT_WALL_SIDE_LOW = block("template_column_short_wall_side_low", "_low_side", TextureKey.END, TextureKey.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final Model TEMPLATE_COLUMN_SHORT_WALL_TALL_SIDE = block("template_column_short_wall_tall_side", "_tall_side", TextureKey.END, TextureKey.SIDE);
	public static final Model TEMPLATE_TOP_BOTTOM_SHORT_WALL_POST = block("template_top_bottom_short_wall_post", "_post", TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final Model TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_LOW = block("template_top_bottom_short_wall_side_low", "_low_side", TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final Model TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_TALL = block("template_top_bottom_short_wall_side_tall", "_tall_side", TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE);
	public static final Model TEMPLATE_BORDER_WALL_SIDE_LOW = block("template_border_wall_side_low", "_side_low", TextureKey.TOP, TextureKey.END, JinericTextureKey.SIDE_SHORT, TextureKey.SIDE);
	public static final Model TEMPLATE_BORDER_WALL_SIDE_LINE_LOW = block("template_border_wall_side_line_low", "_side_line_low", JinericTextureKey.SIDE_LINE_END, JinericTextureKey.SIDE_SHORT, TextureKey.SIDE);
	public static final Model TEMPLATE_BORDER_WALL_SIDE_TALL = block("template_border_wall_side_tall", "_side_tall", TextureKey.END, TextureKey.SIDE);
	public static final Model TEMPLATE_COLUMN_SHORT_WALL_INVENTORY = block("template_column_short_wall_inventory", "_inventory", TextureKey.END, TextureKey.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final Model TEMPLATE_TOP_BOTTOM_WALL_INVENTORY = block("template_top_bottom_short_wall_inventory", "_inventory", TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE, JinericTextureKey.SIDE_SHORT);
	
	private static Model block(String parent, String variant, TextureKey... requiredTextureKeys) {
		return new Model(Optional.of(JinericMain.ofJineric("block/" + parent)), Optional.of(variant), requiredTextureKeys);
	}
	
	public static void initialize() {
	}
}
