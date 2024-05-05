package net.mcreator.stellar.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.stellar.block.model.BoxingRingConerBlockModel;
import net.mcreator.stellar.block.entity.BoxingRingConerTileEntity;

public class BoxingRingConerTileRenderer extends GeoBlockRenderer<BoxingRingConerTileEntity> {
	public BoxingRingConerTileRenderer() {
		super(new BoxingRingConerBlockModel());
	}

	@Override
	public RenderType getRenderType(BoxingRingConerTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
