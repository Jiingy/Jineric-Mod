package jingy.jineric.mixin.change;

import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ToolMaterial.class)
public abstract class ModifyVanillaToolMaterialMixin {
	
	@ModifyArgs(
			method = "<clinit>",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/ToolMaterial;<init>(Lnet/minecraft/tags/TagKey;IFFILnet/minecraft/tags/TagKey;)V",
					ordinal = 0
			)
	)
	private static void modifyWoodToolMaterial(Args args) {
		args.set(1, 32);
		args.set(2, 1.33F);
	}
	
	@ModifyArgs(
			method = "<clinit>",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/item/ToolMaterial;<init>(Lnet/minecraft/tags/TagKey;IFFILnet/minecraft/tags/TagKey;)V",
					ordinal = 1
			)
	)
	private static void modifyStoneToolMaterial(Args args) {
		args.set(1, 128);
		args.set(2, 2.0F);
	}
}
