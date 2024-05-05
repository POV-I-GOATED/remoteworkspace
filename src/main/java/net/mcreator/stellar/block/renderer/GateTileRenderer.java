package net.mcreator.stellar.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.stellar.block.model.GateBlockModel;
import net.mcreator.stellar.block.entity.GateTileEntity;

public class GateTileRenderer extends GeoBlockRenderer<GateTileEntity> {
	public GateTileRenderer() {
		super(new GateBlockModel());
	}

	@Override
	public RenderType getRenderType(GateTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
