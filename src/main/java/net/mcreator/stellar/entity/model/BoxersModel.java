package net.mcreator.stellar.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.entity.BoxersEntity;

public class BoxersModel extends GeoModel<BoxersEntity> {
	@Override
	public ResourceLocation getAnimationResource(BoxersEntity entity) {
		return new ResourceLocation("stellar", "animations/box.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BoxersEntity entity) {
		return new ResourceLocation("stellar", "geo/box.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BoxersEntity entity) {
		return new ResourceLocation("stellar", "textures/entities/" + entity.getTexture() + ".png");
	}

}
