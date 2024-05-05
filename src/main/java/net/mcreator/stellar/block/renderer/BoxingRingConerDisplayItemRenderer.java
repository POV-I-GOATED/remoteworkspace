package net.mcreator.stellar.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.stellar.block.model.BoxingRingConerDisplayModel;
import net.mcreator.stellar.block.display.BoxingRingConerDisplayItem;

public class BoxingRingConerDisplayItemRenderer extends GeoItemRenderer<BoxingRingConerDisplayItem> {
	public BoxingRingConerDisplayItemRenderer() {
		super(new BoxingRingConerDisplayModel());
	}

	@Override
	public RenderType getRenderType(BoxingRingConerDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
