package jingy.jineric.item;

import jingy.jineric.tag.JinericEntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import java.util.Map;

public class WeaponUpgrader {
	public static final Map<TagKey<EntityType<?>>, Integer> ENTITY_LEVEL_PER_HIT = Map.of(
			JinericEntityTypeTags.LEVELS_WEAPON_NONE, 0,
			JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM, 1,
			JinericEntityTypeTags.LEVELS_WEAPON, 2,
			JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM_PLUS, 4,
			JinericEntityTypeTags.LEVELS_WEAPON_HIGH, 6,
			JinericEntityTypeTags.LEVELS_WEAPON_EXTREME, 10
	);
	
	public static int setLevelIncrease(LivingEntity livingEntity) {
		if (livingEntity.typeHolder().is(JinericEntityTypeTags.LEVELS_WEAPON_NONE)) {
			return 0;
		}
		if (livingEntity.typeHolder().is(JinericEntityTypeTags.LEVELS_WEAPON_LOW)) {
			return 1;
		} else if (livingEntity.typeHolder().is(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM)) {
			return 2;
		} else if (livingEntity.typeHolder().is(JinericEntityTypeTags.LEVELS_WEAPON_MEDIUM_PLUS)) {
			return 3;
		} else if (livingEntity.typeHolder().is(JinericEntityTypeTags.LEVELS_WEAPON_HIGH)) {
			return 4;
		} else if (livingEntity.typeHolder().is(JinericEntityTypeTags.LEVELS_WEAPON_EXTREME)) {
			return 5;
		} else {
			return 0;
		}
	}
}
