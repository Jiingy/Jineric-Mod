package jingy.jineric.stat;

import jingy.jineric.base.JinericMain;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class JinericStats {
	public static final Identifier INTERACT_WITH_REFINERY = register("interact_with_refinery", StatFormatter.DEFAULT);
	
	private static Identifier register(String id, StatFormatter formatter) {
		Identifier identifier = JinericMain.ofJineric(id);
		Registry.register(BuiltInRegistries.CUSTOM_STAT, identifier, identifier);
		Stats.CUSTOM.get(identifier, formatter);
		return identifier;
	}
	
	public static void initialize() {
	}
}
