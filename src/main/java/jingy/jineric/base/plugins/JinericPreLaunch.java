package jingy.jineric.base.plugins;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class JinericPreLaunch implements PreLaunchEntrypoint {
	
	@Override
	public void onPreLaunch() {
		MixinExtrasBootstrap.init();
	}
}
