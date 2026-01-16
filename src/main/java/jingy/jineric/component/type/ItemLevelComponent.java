package jingy.jineric.component.type;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

public record ItemLevelComponent(int levelMax) {
	public static final Codec<ItemLevelComponent> CODEC = Codec.INT.xmap(ItemLevelComponent::new, ItemLevelComponent::levelMax);
	public static final PacketCodec<ByteBuf, ItemLevelComponent> PACKET_CODEC = PacketCodec.tuple(
			PacketCodecs.INTEGER, ItemLevelComponent::levelMax, ItemLevelComponent::new
	);
	public static final int DEFAULT_LEVEL = 0;
}
