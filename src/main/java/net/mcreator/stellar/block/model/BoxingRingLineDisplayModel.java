package net.mcreator.stellar.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.block.display.BoxingRingLineDisplayItem;

public class BoxingRingLineDisplayModel extends GeoModel<BoxingRingLineDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BoxingRingLineDisplayItem animatable) {
		return new ResourceLocation("stellar", "animations/boxing_ring_line.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoxingRingLineDisplayItem animatable) {
		return new ResourceLocation("stellar", "geo/boxing_ring_line.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoxingRingLineDisplayItem entity) {
		return new ResourceLocation("stellar", "textures/block/boxing.png");
	}
}
