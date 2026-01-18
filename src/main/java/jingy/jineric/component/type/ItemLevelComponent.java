package jingy.jineric.component.type;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record ItemLevelComponent(int levelMax) {
	public static final Codec<ItemLevelComponent> CODEC = Codec.INT.xmap(ItemLevelComponent::new, ItemLevelComponent::levelMax);
	public static final StreamCodec<ByteBuf, ItemLevelComponent> PACKET_CODEC = StreamCodec.composite(
			ByteBufCodecs.INT, ItemLevelComponent::levelMax, ItemLevelComponent::new
	);
	public static final int DEFAULT_LEVEL = 0;
}
