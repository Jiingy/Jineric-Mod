package net.jineric.jineric_mod.block.entity.state;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.resources.model.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.jineric.jineric_mod.render.JinericTextureRenderLayers.*;

@Environment(EnvType.CLIENT)
public record JinericChestBlockEntityRenderStateVariant(
		String name, Material normal, Material left, Material right
) {
	public static final List<ChestRenderState.ChestMaterialType> VARIANTS = new ArrayList<>();
	public static final Map<ChestRenderState.ChestMaterialType, JinericChestBlockEntityRenderStateVariant> VARIANT_TO_SPRITE_ID = new HashMap<>();
	
	public static final ChestRenderState.ChestMaterialType SPRUCE = register("SPRUCE", SPRUCE_CHEST, SPRUCE_CHEST_LEFT, SPRUCE_CHEST_RIGHT);
	//	public static final ChestRenderState.ChestMaterialType JINERIC_OAK = register("OAK", OAK_CHEST, OAK_CHEST_LEFT, OAK_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType BIRCH = register("BIRCH", BIRCH_CHEST, BIRCH_CHEST_LEFT, BIRCH_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType JUNGLE = register("JUNGLE", JUNGLE_CHEST, JUNGLE_CHEST_LEFT, JUNGLE_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType ACACIA = register("ACACIA", ACACIA_CHEST, ACACIA_CHEST_LEFT, ACACIA_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType DARK_OAK = register("DARK_OAK", DARK_OAK_CHEST, DARK_OAK_CHEST_LEFT, DARK_OAK_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType MANGROVE = register("MANGROVE", MANGROVE_CHEST, MANGROVE_CHEST_LEFT, MANGROVE_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType CHERRY = register("CHERRY", CHERRY_CHEST, CHERRY_CHEST_LEFT, CHERRY_CHEST_RIGHT);
	//	public static final ChestRenderState.ChestMaterialType JINERIC_PALE_OAK = register("PALE_OAK", PALE_OAK_CHEST, PALE_OAK_CHEST_LEFT, PALE_OAK_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType BAMBOO = register("BAMBOO", BAMBOO_CHEST, BAMBOO_CHEST_LEFT, BAMBOO_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType CRIMSON = register("CRIMSON", CRIMSON_CHEST, CRIMSON_CHEST_LEFT, CRIMSON_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType WARPED = register("WARPED", WARPED_CHEST, WARPED_CHEST_LEFT, WARPED_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_SPRUCE = register("TRAPPED_SPRUCE", TRAPPED_SPRUCE_CHEST, TRAPPED_SPRUCE_CHEST_LEFT, TRAPPED_SPRUCE_CHEST_RIGHT);
	//	public static final ChestRenderState.ChestMaterialType JINERIC_TRAPPED_OAK = register("TRAPPED_OAK", TRAPPED_OAK_CHEST, TRAPPED_OAK_CHEST_LEFT, TRAPPED_OAK_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_BIRCH = register("TRAPPED_BIRCH", TRAPPED_BIRCH_CHEST, TRAPPED_BIRCH_CHEST_LEFT, TRAPPED_BIRCH_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_JUNGLE = register("TRAPPED_JUNGLE", TRAPPED_JUNGLE_CHEST, TRAPPED_JUNGLE_CHEST_LEFT, TRAPPED_JUNGLE_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_ACACIA = register("TRAPPED_ACACIA", TRAPPED_ACACIA_CHEST, TRAPPED_ACACIA_CHEST_LEFT, TRAPPED_ACACIA_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_DARK_OAK = register("TRAPPED_DARK_OAK", TRAPPED_DARK_OAK_CHEST, TRAPPED_DARK_OAK_CHEST_LEFT, TRAPPED_DARK_OAK_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_MANGROVE = register("TRAPPED_MANGROVE", TRAPPED_MANGROVE_CHEST, TRAPPED_MANGROVE_CHEST_LEFT, TRAPPED_MANGROVE_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_CHERRY = register("TRAPPED_CHERRY", TRAPPED_CHERRY_CHEST, TRAPPED_CHERRY_CHEST_LEFT, TRAPPED_CHERRY_CHEST_RIGHT);
	//	public static final ChestRenderState.ChestMaterialType JINERIC_TRAPPED_PALE_OAK = register("TRAPPED_PALE_OAK", TRAPPED_PALE_OAK_CHEST, TRAPPED_PALE_OAK_CHEST_LEFT, TRAPPED_PALE_OAK_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_BAMBOO = register("TRAPPED_BAMBOO", TRAPPED_BAMBOO_CHEST, TRAPPED_BAMBOO_CHEST_LEFT, TRAPPED_BAMBOO_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_CRIMSON = register("TRAPPED_CRIMSON", TRAPPED_CRIMSON_CHEST, TRAPPED_CRIMSON_CHEST_LEFT, TRAPPED_CRIMSON_CHEST_RIGHT);
	public static final ChestRenderState.ChestMaterialType TRAPPED_WARPED = register("TRAPPED_WARPED", TRAPPED_WARPED_CHEST, TRAPPED_WARPED_CHEST_LEFT, TRAPPED_WARPED_CHEST_RIGHT);
	
	private static ChestRenderState.ChestMaterialType register(String name, Material normal, Material left, Material right) {
		ChestRenderState.ChestMaterialType variant = ClassTinkerers.getEnum(ChestRenderState.ChestMaterialType.class, "JINERIC_" + name);
		VARIANTS.add(variant);
		VARIANT_TO_SPRITE_ID.put(variant, new JinericChestBlockEntityRenderStateVariant(name, normal, left, right));
		return variant;
	}
	
	public static void initialize() {
	}
}