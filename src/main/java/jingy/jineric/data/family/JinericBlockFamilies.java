package jingy.jineric.data.family;

import com.google.common.collect.Maps;
import jingy.jineric.block.JinericBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class JinericBlockFamilies {
   private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.newHashMap();

   public static final BlockFamily PETRIFIED_OAK = register(JinericBlocks.PETRIFIED_OAK_PLANKS)
           .button(JinericBlocks.PETRIFIED_OAK_BUTTON)
           .fence(JinericBlocks.PETRIFIED_OAK_FENCE)
           .fenceGate(JinericBlocks.PETRIFIED_OAK_FENCE_GATE)
           .pressurePlate(JinericBlocks.PETRIFIED_OAK_PRESSURE_PLATE)
           .sign(JinericBlocks.PETRIFIED_OAK_SIGN, JinericBlocks.PETRIFIED_OAK_WALL_SIGN)
           .slab(JinericBlocks.PETRIFIED_OAK_SLAB)
           .stairs(JinericBlocks.PETRIFIED_OAK_STAIRS)
           .door(JinericBlocks.PETRIFIED_OAK_DOOR)
           .trapdoor(JinericBlocks.PETRIFIED_OAK_TRAPDOOR)
           .group("wooden").unlockCriterionName("has_planks")
           .build();

   public static Stream<BlockFamily> getFamilies() {
      return BASE_BLOCKS_TO_FAMILIES.values().stream();
   }

   public static BlockFamily.Builder register(Block baseBlock) {
      BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
      BlockFamily blockFamily = (BlockFamily)BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
      if (blockFamily != null) {
         throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
      } else {
         return builder;
      }
   }
}
