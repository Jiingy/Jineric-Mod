package jingy.jineric.mixin.access;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodType.class)
public interface WoodTypeAccess {
	
	@Invoker("<init>")
	static WoodType invokeInit(String name, BlockSetType blockSetType) {
		throw new IllegalStateException("Could not <invoke> init() in WoodType!");
	}
	
	@Invoker("register")
	static WoodType invokeRegister(WoodType signType) {
		throw new IllegalStateException("Could not invoke register() in WoodType!");
	}
}
