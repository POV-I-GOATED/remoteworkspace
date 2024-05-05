package net.mcreator.stellar.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.stellar.block.model.BoxingRingLineDisplayModel;
import net.mcreator.stellar.block.display.BoxingRingLineDisplayItem;

public class BoxingRingLineDisplayItemRenderer extends GeoItemRenderer<BoxingRingLineDisplayItem> {
	public BoxingRingLineDisplayItemRenderer() {
		super(new BoxingRingLineDisplayModel());
	}

	@Override
	public RenderType getRenderType(BoxingRingLineDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
