
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.stellar.item.CoolItem;
import net.mcreator.stellar.StellarMod;

public class StellarModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, StellarMod.MODID);
	public static final RegistryObject<Item> COOL = REGISTRY.register("cool", () -> new CoolItem());
}
