package net.mcreator.stellar.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.block.display.GateDisplayItem;

public class GateDisplayModel extends GeoModel<GateDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(GateDisplayItem animatable) {
		return new ResourceLocation("stellar", "animations/gate.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GateDisplayItem animatable) {
		return new ResourceLocation("stellar", "geo/gate.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GateDisplayItem entity) {
		return new ResourceLocation("stellar", "textures/block/boxing.png");
	}
}
