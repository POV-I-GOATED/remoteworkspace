package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.stellar.init.StellarModEntities;
import net.mcreator.stellar.entity.MoverssEntity;
import net.mcreator.stellar.StellarMod;

import java.util.Comparator;

public class RealhookProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		Entity me = null;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = StellarModEntities.MOVERSS.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		entity.startRiding(((Entity) world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)));
		StellarMod.queueServerWork(1, () -> {
			if (!world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
				((Entity) world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPersistentData().putDouble("mystartx", ((immediatesourceentity.getPersistentData().getDouble("startX") - x) / 20));
				((Entity) world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPersistentData().putDouble("mystarty", ((immediatesourceentity.getPersistentData().getDouble("startY") - y) / 20));
				((Entity) world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getPersistentData().putDouble("mystartz", ((immediatesourceentity.getPersistentData().getDouble("startZ") - z) / 20));
				StellarMod.queueServerWork(20, () -> {
					if (!world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
						if (!((Entity) world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
							((Entity) world.getEntitiesOfClass(MoverssEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
					} else {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Fail"), false);
					}
				});
			} else {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Fail"), false);
			}
		});
	}
}
