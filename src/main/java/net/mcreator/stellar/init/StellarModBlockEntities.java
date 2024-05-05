
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.stellar.block.entity.GateTileEntity;
import net.mcreator.stellar.block.entity.BoxingRingLineTileEntity;
import net.mcreator.stellar.block.entity.BoxingRingConerTileEntity;
import net.mcreator.stellar.StellarMod;

public class StellarModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, StellarMod.MODID);
	public static final RegistryObject<BlockEntityType<BoxingRingLineTileEntity>> BOXING_RING_LINE = REGISTRY.register("boxing_ring_line",
			() -> BlockEntityType.Builder.of(BoxingRingLineTileEntity::new, StellarModBlocks.BOXING_RING_LINE.get()).build(null));
	public static final RegistryObject<BlockEntityType<BoxingRingConerTileEntity>> BOXING_RING_CONER = REGISTRY.register("boxing_ring_coner",
			() -> BlockEntityType.Builder.of(BoxingRingConerTileEntity::new, StellarModBlocks.BOXING_RING_CONER.get()).build(null));
	public static final RegistryObject<BlockEntityType<GateTileEntity>> GATE = REGISTRY.register("gate", () -> BlockEntityType.Builder.of(GateTileEntity::new, StellarModBlocks.GATE.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
