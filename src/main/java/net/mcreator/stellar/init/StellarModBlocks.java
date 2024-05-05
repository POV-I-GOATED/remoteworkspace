
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.stellar.block.UraniumOreBlock;
import net.mcreator.stellar.block.UraniumBlockBlock;
import net.mcreator.stellar.block.GateBlock;
import net.mcreator.stellar.block.BoxingRingLineBlock;
import net.mcreator.stellar.block.BoxingRingConerBlock;
import net.mcreator.stellar.StellarMod;

public class StellarModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, StellarMod.MODID);
	public static final RegistryObject<Block> URANIUM_BLOCK = REGISTRY.register("uranium_block", () -> new UraniumBlockBlock());
	public static final RegistryObject<Block> URANIUM_ORE = REGISTRY.register("uranium_ore", () -> new UraniumOreBlock());
	public static final RegistryObject<Block> BOXING_RING_LINE = REGISTRY.register("boxing_ring_line", () -> new BoxingRingLineBlock());
	public static final RegistryObject<Block> BOXING_RING_CONER = REGISTRY.register("boxing_ring_coner", () -> new BoxingRingConerBlock());
	public static final RegistryObject<Block> GATE = REGISTRY.register("gate", () -> new GateBlock());
}
