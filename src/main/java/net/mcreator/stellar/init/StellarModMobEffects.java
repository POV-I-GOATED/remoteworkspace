
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.stellar.potion.RadationMobEffect;
import net.mcreator.stellar.StellarMod;

public class StellarModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, StellarMod.MODID);
	public static final RegistryObject<MobEffect> RADATION = REGISTRY.register("radation", () -> new RadationMobEffect());
}
