package net.mcreator.stellar.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.stellar.entity.HookEntity;

public class HookModel extends GeoModel<HookEntity> {
	@Override
	public ResourceLocation getAnimationResource(HookEntity entity) {
		return new ResourceLocation("stellar", "animations/priste.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HookEntity entity) {
		return new ResourceLocation("stellar", "geo/priste.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HookEntity entity) {
		return new ResourceLocation("stellar", "textures/entities/" + entity.getTexture() + ".png");
	}

}
