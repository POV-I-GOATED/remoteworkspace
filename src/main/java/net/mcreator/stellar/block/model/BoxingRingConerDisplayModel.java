package net.mcreator.stellar.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.block.display.BoxingRingConerDisplayItem;

public class BoxingRingConerDisplayModel extends GeoModel<BoxingRingConerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BoxingRingConerDisplayItem animatable) {
		return new ResourceLocation("stellar", "animations/newcorn.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoxingRingConerDisplayItem animatable) {
		return new ResourceLocation("stellar", "geo/newcorn.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoxingRingConerDisplayItem entity) {
		return new ResourceLocation("stellar", "textures/block/boxing.png");
	}
}
