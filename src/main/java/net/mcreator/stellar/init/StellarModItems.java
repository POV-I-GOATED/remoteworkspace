
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.stellar.item.SummonerItem;
import net.mcreator.stellar.item.RerollerItem;
import net.mcreator.stellar.item.HooksItem;
import net.mcreator.stellar.StellarMod;

public class StellarModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, StellarMod.MODID);
	public static final RegistryObject<Item> HOOKS = REGISTRY.register("hooks", () -> new HooksItem());
	public static final RegistryObject<Item> REROLLER = REGISTRY.register("reroller", () -> new RerollerItem());
	public static final RegistryObject<Item> KNITE_SPAWN_EGG = REGISTRY.register("knite_spawn_egg", () -> new ForgeSpawnEggItem(StellarModEntities.KNITE, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> SUMMONER = REGISTRY.register("summoner", () -> new SummonerItem());
}
