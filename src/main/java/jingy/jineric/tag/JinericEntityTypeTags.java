package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class JinericEntityTypeTags {
	
	private static TagKey<EntityType<?>> registerItemTag(String id) {
		return TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), JinericMain.ofJineric(id));
	}
	
	public static void initialize() {}
}
