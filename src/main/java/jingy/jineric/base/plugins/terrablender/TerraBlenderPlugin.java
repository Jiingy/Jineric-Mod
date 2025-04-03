package jingy.jineric.base.plugins.terrablender;

import jingy.jineric.base.JinericMain;
import jingy.jineric.world.biome.JinericCommonRegion;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class TerraBlenderPlugin implements TerraBlenderApi {

   @Override
   public void onTerraBlenderInitialized() {
//	   Regions.register(new JinericCommonRegion(JinericMain.ofJineric("overworld_region"), 1));
	   SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, JinericMain.MOD_ID, JinericMaterialRules.createJinericDefaultRule());
   }
}
