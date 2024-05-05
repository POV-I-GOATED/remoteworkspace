package net.mcreator.stellar.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.block.entity.BoxingRingLineTileEntity;

public class BoxingRingLineBlockModel extends GeoModel<BoxingRingLineTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoxingRingLineTileEntity animatable) {
		return new ResourceLocation("stellar", "animations/boxing_ring_line.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoxingRingLineTileEntity animatable) {
		return new ResourceLocation("stellar", "geo/boxing_ring_line.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoxingRingLineTileEntity entity) {
		return new ResourceLocation("stellar", "textures/block/boxing.png");
	}
}
