package net.mcreator.stellar.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.stellar.block.model.GateDisplayModel;
import net.mcreator.stellar.block.display.GateDisplayItem;

public class GateDisplayItemRenderer extends GeoItemRenderer<GateDisplayItem> {
	public GateDisplayItemRenderer() {
		super(new GateDisplayModel());
	}

	@Override
	public RenderType getRenderType(GateDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
