
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.stellar.world.inventory.ChoserMenu;
import net.mcreator.stellar.StellarMod;

public class StellarModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, StellarMod.MODID);
	public static final RegistryObject<MenuType<ChoserMenu>> CHOSER = REGISTRY.register("choser", () -> IForgeMenuType.create(ChoserMenu::new));
}
