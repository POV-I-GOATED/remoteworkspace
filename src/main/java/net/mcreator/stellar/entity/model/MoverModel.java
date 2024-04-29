package net.mcreator.stellar.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.entity.MoverEntity;

public class MoverModel extends GeoModel<MoverEntity> {
	@Override
	public ResourceLocation getAnimationResource(MoverEntity entity) {
		return new ResourceLocation("stellar", "animations/priste.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MoverEntity entity) {
		return new ResourceLocation("stellar", "geo/priste.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MoverEntity entity) {
		return new ResourceLocation("stellar", "textures/entities/" + entity.getTexture() + ".png");
	}

}
