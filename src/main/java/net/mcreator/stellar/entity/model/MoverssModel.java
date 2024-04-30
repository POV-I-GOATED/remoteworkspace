package net.mcreator.stellar.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.entity.MoverssEntity;

public class MoverssModel extends GeoModel<MoverssEntity> {
	@Override
	public ResourceLocation getAnimationResource(MoverssEntity entity) {
		return new ResourceLocation("stellar", "animations/priste.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MoverssEntity entity) {
		return new ResourceLocation("stellar", "geo/priste.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MoverssEntity entity) {
		return new ResourceLocation("stellar", "textures/entities/" + entity.getTexture() + ".png");
	}

}
