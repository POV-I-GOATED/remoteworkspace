package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.StellarMod;

import java.util.Comparator;

public class MoverOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).isEmpty()) {
			StellarMod.queueServerWork(4, () -> {
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).startRiding(entity);
				entity.getPersistentData().putDouble("X", ((entity.getPersistentData().getDouble("X2") - x) / 20));
				entity.getPersistentData().putDouble("Y", ((entity.getPersistentData().getDouble("Y2") - y) / 20));
				entity.getPersistentData().putDouble("Z", ((entity.getPersistentData().getDouble("Z2") - z) / 20));
			});
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
