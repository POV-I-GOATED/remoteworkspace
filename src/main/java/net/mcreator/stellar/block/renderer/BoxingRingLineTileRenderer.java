package net.mcreator.stellar.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.stellar.block.model.BoxingRingLineBlockModel;
import net.mcreator.stellar.block.entity.BoxingRingLineTileEntity;

public class BoxingRingLineTileRenderer extends GeoBlockRenderer<BoxingRingLineTileEntity> {
	public BoxingRingLineTileRenderer() {
		super(new BoxingRingLineBlockModel());
	}

	@Override
	public RenderType getRenderType(BoxingRingLineTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
