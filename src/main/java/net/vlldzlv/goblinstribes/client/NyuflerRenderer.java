package net.vlldzlv.goblinstribes.client;

import net.minecraft.client.model.SnifferModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vlldzlv.goblinstribes.GoblinsTribes;
import net.vlldzlv.goblinstribes.entity.Nyufler;

public class NyuflerRenderer extends MobRenderer<Nyufler, SnifferModel<Nyufler>> {
	private static final ResourceLocation TEXTURE =
			new ResourceLocation(GoblinsTribes.MOD_ID, "textures/entity/nyufler/nyufler.png");

	public NyuflerRenderer(EntityRendererProvider.Context context) {
		super(context, new SnifferModel<>(context.bakeLayer(ModelLayers.SNIFFER)), 0.6F);
	}

	@Override
	public ResourceLocation getTextureLocation(Nyufler entity) {
		return TEXTURE;
	}

	@Override
	protected float getFlipDegrees(Nyufler livingEntity) {
		return 180.0F;
	}
}
