
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.stellar.StellarMod;

public class StellarModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StellarMod.MODID);
	public static final RegistryObject<CreativeModeTab> STELLLAR = REGISTRY.register("stelllar",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.stellar.stelllar")).icon(() -> new ItemStack(StellarModItems.REROLLER.get())).displayItems((parameters, tabData) -> {
				tabData.accept(StellarModItems.HOOKS.get());
				tabData.accept(StellarModItems.REROLLER.get());
			}).withSearchBar().build());
}
