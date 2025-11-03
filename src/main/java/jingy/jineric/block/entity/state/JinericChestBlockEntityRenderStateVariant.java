package jingy.jineric.block.entity.state;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.state.ChestBlockEntityRenderState;
import net.minecraft.client.util.SpriteIdentifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jingy.jineric.client.render.JinericTextureRenderLayers.*;

@Environment(EnvType.CLIENT)
public class JinericChestBlockEntityRenderStateVariant {
	public static final List<ChestBlockEntityRenderState.Variant> VARIANTS = new ArrayList<>();
	public static final Map<ChestBlockEntityRenderState.Variant, JinericChestBlockEntityRenderStateVariant> VARIANT_TO_SPRITE_ID = new HashMap<>();
	
	public static final ChestBlockEntityRenderState.Variant JINERIC_SPRUCE = register("SPRUCE", SPRUCE_CHEST, SPRUCE_CHEST_LEFT, SPRUCE_CHEST_RIGHT);
	//	public static final ChestBlockEntityRenderState.Variant JINERIC_OAK = register("OAK", OAK_CHEST, OAK_CHEST_LEFT, OAK_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_BIRCH = register("BIRCH", BIRCH_CHEST, BIRCH_CHEST_LEFT, BIRCH_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_JUNGLE = register("JUNGLE", JUNGLE_CHEST, JUNGLE_CHEST_LEFT, JUNGLE_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_ACACIA = register("ACACIA", ACACIA_CHEST, ACACIA_CHEST_LEFT, ACACIA_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_DARK_OAK = register("DARK_OAK", DARK_OAK_CHEST, DARK_OAK_CHEST_LEFT, DARK_OAK_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_MANGROVE = register("MANGROVE", MANGROVE_CHEST, MANGROVE_CHEST_LEFT, MANGROVE_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_CHERRY = register("CHERRY", CHERRY_CHEST, CHERRY_CHEST_LEFT, CHERRY_CHEST_RIGHT);
	//	public static final ChestBlockEntityRenderState.Variant JINERIC_PALE_OAK = register("PALE_OAK", PALE_OAK_CHEST, PALE_OAK_CHEST_LEFT, PALE_OAK_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_BAMBOO = register("BAMBOO", BAMBOO_CHEST, BAMBOO_CHEST_LEFT, BAMBOO_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_CRIMSON = register("CRIMSON", CRIMSON_CHEST, CRIMSON_CHEST_LEFT, CRIMSON_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_WARPED = register("WARPED", WARPED_CHEST, WARPED_CHEST_LEFT, WARPED_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_SPRUCE = register("TRAPPED_SPRUCE", TRAPPED_SPRUCE_CHEST, TRAPPED_SPRUCE_CHEST_LEFT, TRAPPED_SPRUCE_CHEST_RIGHT);
	//	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_OAK = register("TRAPPED_OAK", TRAPPED_OAK_CHEST, TRAPPED_OAK_CHEST_LEFT, TRAPPED_OAK_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_BIRCH = register("TRAPPED_BIRCH", TRAPPED_BIRCH_CHEST, TRAPPED_BIRCH_CHEST_LEFT, TRAPPED_BIRCH_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_JUNGLE = register("TRAPPED_JUNGLE", TRAPPED_JUNGLE_CHEST, TRAPPED_JUNGLE_CHEST_LEFT, TRAPPED_JUNGLE_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_ACACIA = register("TRAPPED_ACACIA", TRAPPED_ACACIA_CHEST, TRAPPED_ACACIA_CHEST_LEFT, TRAPPED_ACACIA_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_DARK_OAK = register("TRAPPED_DARK_OAK", TRAPPED_DARK_OAK_CHEST, TRAPPED_DARK_OAK_CHEST_LEFT, TRAPPED_DARK_OAK_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_MANGROVE = register("TRAPPED_MANGROVE", TRAPPED_MANGROVE_CHEST, TRAPPED_MANGROVE_CHEST_LEFT, TRAPPED_MANGROVE_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_CHERRY = register("TRAPPED_CHERRY", TRAPPED_CHERRY_CHEST, TRAPPED_CHERRY_CHEST_LEFT, TRAPPED_CHERRY_CHEST_RIGHT);
	//	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_PALE_OAK = register("TRAPPED_PALE_OAK", TRAPPED_PALE_OAK_CHEST, TRAPPED_PALE_OAK_CHEST_LEFT, TRAPPED_PALE_OAK_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_BAMBOO = register("TRAPPED_BAMBOO", TRAPPED_BAMBOO_CHEST, TRAPPED_BAMBOO_CHEST_LEFT, TRAPPED_BAMBOO_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_CRIMSON = register("TRAPPED_CRIMSON", TRAPPED_CRIMSON_CHEST, TRAPPED_CRIMSON_CHEST_LEFT, TRAPPED_CRIMSON_CHEST_RIGHT);
	public static final ChestBlockEntityRenderState.Variant JINERIC_TRAPPED_WARPED = register("TRAPPED_WARPED", TRAPPED_WARPED_CHEST, TRAPPED_WARPED_CHEST_LEFT, TRAPPED_WARPED_CHEST_RIGHT);
	
	private final String name;
	private final SpriteIdentifier normal;
	private final SpriteIdentifier left;
	private final SpriteIdentifier right;
	
	public JinericChestBlockEntityRenderStateVariant(String name, SpriteIdentifier normal, SpriteIdentifier left, SpriteIdentifier right) {
		this.name = name;
		this.normal = normal;
		this.left = left;
		this.right = right;
	}
	
	private static ChestBlockEntityRenderState.Variant register(String name, SpriteIdentifier normal, SpriteIdentifier left, SpriteIdentifier right) {
		ChestBlockEntityRenderState.Variant variant = ClassTinkerers.getEnum(ChestBlockEntityRenderState.Variant.class, "JINERIC_" + name);
//		List<SpriteIdentifier> spriteIdentifiers = List.of(normal, left, right);
		VARIANTS.add(variant);
		VARIANT_TO_SPRITE_ID.put(variant, new JinericChestBlockEntityRenderStateVariant(name, normal, left, right));
		return variant;
	}
	
	public String getName() {
		return name;
	}
	
	public SpriteIdentifier getNormal() {
		return normal;
	}
	
	public SpriteIdentifier getLeft() {
		return left;
	}
	
	public SpriteIdentifier getRight() {
		return right;
	}
	
	public static void initialize() {}
}