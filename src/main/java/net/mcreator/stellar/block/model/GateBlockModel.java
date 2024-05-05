package net.mcreator.stellar.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.block.entity.GateTileEntity;

public class GateBlockModel extends GeoModel<GateTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(GateTileEntity animatable) {
		return new ResourceLocation("stellar", "animations/gate.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GateTileEntity animatable) {
		return new ResourceLocation("stellar", "geo/gate.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GateTileEntity entity) {
		return new ResourceLocation("stellar", "textures/block/boxing.png");
	}
}
