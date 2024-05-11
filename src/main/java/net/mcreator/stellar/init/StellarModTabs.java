
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.stellar.StellarMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StellarModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StellarMod.MODID);
	public static final RegistryObject<CreativeModeTab> STELLLAR = REGISTRY.register("stelllar",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.stellar.stelllar")).icon(() -> new ItemStack(StellarModItems.REROLLER.get())).displayItems((parameters, tabData) -> {
				tabData.accept(StellarModItems.HOOKS.get());
				tabData.accept(StellarModItems.REROLLER.get());
				tabData.accept(StellarModItems.SUMMONER.get());
				tabData.accept(StellarModBlocks.URANIUM_BLOCK.get().asItem());
				tabData.accept(StellarModBlocks.URANIUM_ORE.get().asItem());
				tabData.accept(StellarModItems.URANIUM.get());
				tabData.accept(StellarModItems.URANUM_SWORD.get());
				tabData.accept(StellarModItems.CROWN_HELMET.get());
				tabData.accept(StellarModItems.BOXINGINCREAER.get());
				tabData.accept(StellarModItems.URANIUMA_HELMET.get());
				tabData.accept(StellarModItems.URANIUMA_CHESTPLATE.get());
				tabData.accept(StellarModItems.URANIUMA_LEGGINGS.get());
				tabData.accept(StellarModItems.URANIUMA_BOOTS.get());
				tabData.accept(StellarModItems.L_OCATR.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(StellarModItems.KNITE_SPAWN_EGG.get());
			tabData.accept(StellarModItems.BOXERS_SPAWN_EGG.get());
		}
	}
}
