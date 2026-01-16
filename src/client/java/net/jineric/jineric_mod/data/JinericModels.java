package net.jineric.jineric_mod.data;

import jingy.jineric.base.JinericMain;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class JinericModels {
	public static final ModelTemplate TEMPLATE_COLUMN_SHORT_WALL_POST = block("template_column_short_wall_post", "_post", TextureSlot.END, TextureSlot.SIDE);
	public static final ModelTemplate TEMPLATE_COLUMN_SHORT_WALL_SIDE_LOW = block("template_column_short_wall_side_low", "_side_low", TextureSlot.END, TextureSlot.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final ModelTemplate TEMPLATE_COLUMN_SHORT_WALL_SIDE_TALL = block("template_column_short_wall_side_tall", "_side_tall", TextureSlot.END, TextureSlot.SIDE);
	public static final ModelTemplate TEMPLATE_TOP_BOTTOM_SHORT_WALL_POST = block("template_top_bottom_short_wall_post", "_post", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final ModelTemplate TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_LOW = block("template_top_bottom_short_wall_side_low", "_side_low", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final ModelTemplate TEMPLATE_TOP_BOTTOM_SHORT_WALL_SIDE_TALL = block("template_top_bottom_short_wall_side_tall", "_side_tall", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE);
	public static final ModelTemplate TEMPLATE_BORDER_WALL_SIDE_LOW = block("template_border_wall_side_low", "_side_low", TextureSlot.TOP, TextureSlot.END, JinericTextureKey.SIDE_SHORT, TextureSlot.SIDE);
	public static final ModelTemplate TEMPLATE_BORDER_WALL_SIDE_LINE_LOW = block("template_border_wall_side_line_low", "_side_line_low", JinericTextureKey.SIDE_LINE_END, JinericTextureKey.SIDE_SHORT, TextureSlot.SIDE);
	public static final ModelTemplate TEMPLATE_BORDER_WALL_SIDE_TALL = block("template_border_wall_side_tall", "_side_tall", TextureSlot.END, TextureSlot.SIDE);
	public static final ModelTemplate TEMPLATE_COLUMN_SHORT_WALL_INVENTORY = block("template_column_short_wall_inventory", "_inventory", TextureSlot.END, TextureSlot.SIDE, JinericTextureKey.SIDE_SHORT);
	public static final ModelTemplate TEMPLATE_TOP_BOTTOM_WALL_INVENTORY = block("template_top_bottom_short_wall_inventory", "_inventory", TextureSlot.TOP, TextureSlot.BOTTOM, TextureSlot.SIDE, JinericTextureKey.SIDE_SHORT);
	
	private static ModelTemplate block(String parent, String variant, TextureSlot... requiredTextureKeys) {
		return new ModelTemplate(Optional.of(JinericMain.ofJineric("block/" + parent)), Optional.of(variant), requiredTextureKeys);
	}
	
	public static void initialize() {}
}
