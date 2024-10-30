package jingy.jineric.client.render.entity.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.DyeColor;

@Environment(EnvType.CLIENT)
public class ManxLoaghtanRenderState extends LivingEntityRenderState {
    public float neckAngle;
    public float headAngle;
    public boolean sheared;
    public DyeColor color = DyeColor.BLACK;
    public int id;
}
