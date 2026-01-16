package jingy.jineric.config;

public class JmConfig {
	public static boolean MODE_FREE = false; // Durability is removed with no drawbacks
	public static boolean MODE_ = false; // Durability is removed on items with Unbreaking V, a new level which isn't obtainable through enchanting
	public static boolean MODE_UPGRADE = true; // Durability starts at 0, you increase the value with usage
	public static boolean UPGRADE_EQUIPMENT = true;
	public static boolean UPGRADE_TEMPLATE = false;
	public static boolean MODIFY_TOOL_MINABLE = true;
	public static boolean VANILLA_ANVIL = true;
	public static boolean MODIFY_VANILLA_ANVIL = true;
	
	public static boolean DURABILITY = false;
	public static boolean REPLACE_VANILLA_RECIPE_BOOK = true;
}
