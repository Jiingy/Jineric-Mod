package jingy.jineric.tag;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public interface JinericEntityTypeTags {
	TagKey<EntityType<?>> LEVELS_WEAPON_NONE = register("levels_weapon_none");
	TagKey<EntityType<?>> LEVELS_WEAPON = register("levels_weapon");
	TagKey<EntityType<?>> LEVELS_WEAPON_LOW = register("levels_weapon_low");
	TagKey<EntityType<?>> LEVELS_WEAPON_MEDIUM = register("levels_weapon_medium");
	TagKey<EntityType<?>> LEVELS_WEAPON_MEDIUM_PLUS = register("levels_weapon_medium_plus");
	TagKey<EntityType<?>> LEVELS_WEAPON_HIGH = register("levels_weapon_high");
	TagKey<EntityType<?>> LEVELS_WEAPON_EXTREME = register("levels_weapon_extreme");
	
	private static TagKey<EntityType<?>> register(String id) {
		return TagKey.create(BuiltInRegistries.ENTITY_TYPE.key(), JinericMain.ofJineric(id));
	}
}
