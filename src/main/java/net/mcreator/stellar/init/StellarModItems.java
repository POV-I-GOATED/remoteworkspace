
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.stellar.item.UranumSwordItem;
import net.mcreator.stellar.item.UraniumaItem;
import net.mcreator.stellar.item.UraniumItem;
import net.mcreator.stellar.item.SummonerItem;
import net.mcreator.stellar.item.RerollerItem;
import net.mcreator.stellar.item.HooksItem;
import net.mcreator.stellar.item.CrownItem;
import net.mcreator.stellar.item.BoxingincreaerItem;
import net.mcreator.stellar.block.display.GateDisplayItem;
import net.mcreator.stellar.block.display.BoxingRingLineDisplayItem;
import net.mcreator.stellar.block.display.BoxingRingConerDisplayItem;
import net.mcreator.stellar.StellarMod;

public class StellarModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, StellarMod.MODID);
	public static final RegistryObject<Item> HOOKS = REGISTRY.register("hooks", () -> new HooksItem());
	public static final RegistryObject<Item> REROLLER = REGISTRY.register("reroller", () -> new RerollerItem());
	public static final RegistryObject<Item> KNITE_SPAWN_EGG = REGISTRY.register("knite_spawn_egg", () -> new ForgeSpawnEggItem(StellarModEntities.KNITE, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> SUMMONER = REGISTRY.register("summoner", () -> new SummonerItem());
	public static final RegistryObject<Item> URANIUM_BLOCK = block(StellarModBlocks.URANIUM_BLOCK);
	public static final RegistryObject<Item> URANIUM_ORE = block(StellarModBlocks.URANIUM_ORE);
	public static final RegistryObject<Item> URANIUM = REGISTRY.register("uranium", () -> new UraniumItem());
	public static final RegistryObject<Item> URANUM_SWORD = REGISTRY.register("uranum_sword", () -> new UranumSwordItem());
	public static final RegistryObject<Item> CROWN_HELMET = REGISTRY.register("crown_helmet", () -> new CrownItem.Helmet());
	public static final RegistryObject<Item> BOXINGINCREAER = REGISTRY.register("boxingincreaer", () -> new BoxingincreaerItem());
	public static final RegistryObject<Item> URANIUMA_HELMET = REGISTRY.register("uraniuma_helmet", () -> new UraniumaItem.Helmet());
	public static final RegistryObject<Item> URANIUMA_CHESTPLATE = REGISTRY.register("uraniuma_chestplate", () -> new UraniumaItem.Chestplate());
	public static final RegistryObject<Item> URANIUMA_LEGGINGS = REGISTRY.register("uraniuma_leggings", () -> new UraniumaItem.Leggings());
	public static final RegistryObject<Item> URANIUMA_BOOTS = REGISTRY.register("uraniuma_boots", () -> new UraniumaItem.Boots());
	public static final RegistryObject<Item> BOXING_RING_LINE = REGISTRY.register(StellarModBlocks.BOXING_RING_LINE.getId().getPath(), () -> new BoxingRingLineDisplayItem(StellarModBlocks.BOXING_RING_LINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> BOXING_RING_CONER = REGISTRY.register(StellarModBlocks.BOXING_RING_CONER.getId().getPath(), () -> new BoxingRingConerDisplayItem(StellarModBlocks.BOXING_RING_CONER.get(), new Item.Properties()));
	public static final RegistryObject<Item> GATE = REGISTRY.register(StellarModBlocks.GATE.getId().getPath(), () -> new GateDisplayItem(StellarModBlocks.GATE.get(), new Item.Properties()));

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
