package net.mcreator.stellar.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.entity.KniteEntity;

public class KniteModel extends GeoModel<KniteEntity> {
	@Override
	public ResourceLocation getAnimationResource(KniteEntity entity) {
		return new ResourceLocation("stellar", "animations/knight.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KniteEntity entity) {
		return new ResourceLocation("stellar", "geo/knight.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KniteEntity entity) {
		return new ResourceLocation("stellar", "textures/entities/" + entity.getTexture() + ".png");
	}

}
