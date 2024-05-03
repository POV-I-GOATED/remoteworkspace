
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.entity.RealhookEntity;
import net.mcreator.stellar.entity.MoverssEntity;
import net.mcreator.stellar.entity.MoverEntity;
import net.mcreator.stellar.entity.LaserEntity;
import net.mcreator.stellar.entity.KniteEntity;
import net.mcreator.stellar.StellarMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StellarModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, StellarMod.MODID);
	public static final RegistryObject<EntityType<RealhookEntity>> REALHOOK = register("projectile_realhook",
			EntityType.Builder.<RealhookEntity>of(RealhookEntity::new, MobCategory.MISC).setCustomClientFactory(RealhookEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MoverEntity>> MOVER = register("mover",
			EntityType.Builder.<MoverEntity>of(MoverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MoverEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MoverssEntity>> MOVERSS = register("moverss",
			EntityType.Builder.<MoverssEntity>of(MoverssEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MoverssEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KniteEntity>> KNITE = register("knite",
			EntityType.Builder.<KniteEntity>of(KniteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KniteEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LaserEntity>> LASER = register("projectile_laser",
			EntityType.Builder.<LaserEntity>of(LaserEntity::new, MobCategory.MISC).setCustomClientFactory(LaserEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MoverEntity.init();
			MoverssEntity.init();
			KniteEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MOVER.get(), MoverEntity.createAttributes().build());
		event.put(MOVERSS.get(), MoverssEntity.createAttributes().build());
		event.put(KNITE.get(), KniteEntity.createAttributes().build());
	}
}
