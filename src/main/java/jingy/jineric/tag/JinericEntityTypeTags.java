package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

public class JinericEntityTypeTags {
	public static final TagKey<EntityType<?>> CLASSIC_BOAT = registerItemTag("classic_boat");
	
	private static TagKey<EntityType<?>> registerItemTag(String id) {
		return TagKey.of(Registries.ENTITY_TYPE.getKey(), JinericMain.ofJineric(id));
	}
	
	public static void initialize() {}
}
