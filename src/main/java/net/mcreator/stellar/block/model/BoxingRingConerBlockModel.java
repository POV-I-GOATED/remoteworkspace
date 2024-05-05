package net.mcreator.stellar.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.block.entity.BoxingRingConerTileEntity;

public class BoxingRingConerBlockModel extends GeoModel<BoxingRingConerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoxingRingConerTileEntity animatable) {
		return new ResourceLocation("stellar", "animations/newcorn.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoxingRingConerTileEntity animatable) {
		return new ResourceLocation("stellar", "geo/newcorn.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoxingRingConerTileEntity entity) {
		return new ResourceLocation("stellar", "textures/block/boxing.png");
	}
}
