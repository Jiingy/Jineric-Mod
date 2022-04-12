package jingy.jineric.tag;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.AbstractTagProvider;
import net.minecraft.util.registry.Registry;

public class JinericBlockTagProvider extends AbstractTagProvider<Block> {
   public JinericBlockTagProvider(DataGenerator root) {
      super(root, Registry.BLOCK);
   }

   @Override
   protected void configure() {

   }

   @Override
   public String getName() {
      return null;
   }
}
