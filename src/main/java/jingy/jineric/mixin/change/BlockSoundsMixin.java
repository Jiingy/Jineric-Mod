package jingy.jineric.mixin.change;

import jingy.jineric.sound.JinericBlockSoundGroup;
import jingy.jineric.tag.JinericBlockSoundTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public abstract class BlockSoundsMixin {
	@Inject(
			method = "getSoundType",
			at = @At(value = "HEAD"),
			cancellable = true
	)
	private void jineric$CustomSoundGroups(BlockState state, CallbackInfoReturnable<SoundType> cir) {
		if (state.is(JinericBlockSoundTags.LEAF_SOUNDS)) {
			cir.setReturnValue(SoundType.AZALEA_LEAVES);
		} else if (state.is(JinericBlockSoundTags.WOODEN_BLOCK_SOUNDS)) {
			cir.setReturnValue(JinericBlockSoundGroup.WOODEN_BLOCKS);
		} else if (state.is(JinericBlockSoundTags.WOODEN_ACCESSORY_SOUNDS)) {
			cir.setReturnValue(JinericBlockSoundGroup.WOODEN_ACCESSORIES);
		} else if (state.is(Blocks.LADDER)) {
			cir.setReturnValue(JinericBlockSoundGroup.WOODEN_LADDER);
		} else if (state.is(JinericBlockSoundTags.MUSHROOM_SOUNDS)) {
			cir.setReturnValue(SoundType.NETHER_WART);
		} else if (state.is(JinericBlockSoundTags.VEGETATION_SOUNDS)) {
			cir.setReturnValue(SoundType.MOSS);
		} else if (state.is(Blocks.REDSTONE_WIRE)) {
			cir.setReturnValue(JinericBlockSoundGroup.REDSTONE_DUST);
		} else if (state.is(Blocks.TRIPWIRE)) {
			cir.setReturnValue(SoundType.WOOL);
		} else if (state.is(Blocks.COBBLESTONE) || state.is(Blocks.INFESTED_COBBLESTONE)) {
			cir.setReturnValue(JinericBlockSoundGroup.COBBLED_STONES);
		} else if (state.is(BlockTags.SAPLINGS)) {
			cir.setReturnValue(SoundType.CHERRY_SAPLING);
		} else if (state.is(JinericBlockSoundTags.WOODEN_NETHER_BLOCK_SOUNDS)) {
			cir.setReturnValue(SoundType.NETHER_WOOD);
		} else if (state.is(Blocks.SKELETON_SKULL)
				|| state.is(Blocks.SKELETON_WALL_SKULL)
				|| state.is(Blocks.WITHER_SKELETON_SKULL)
				|| state.is(Blocks.WITHER_SKELETON_WALL_SKULL)) {
			cir.setReturnValue(SoundType.BONE_BLOCK);
		}
	}
}
