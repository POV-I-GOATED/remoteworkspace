package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.stellar.entity.BoxersEntity;

import java.util.Comparator;

public class BoxersOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rand = 0;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty()) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), 1);
			if (entity.getPersistentData().getDouble("Transform") == 1) {
				if (entity.getPersistentData().getDouble("Transform") == 1) {
					if (Mth.nextInt(RandomSource.create(), 0, 1) == 1) {
						if (entity instanceof BoxersEntity animatable)
							animatable.setTexture("boxs");
					} else {
						if (entity instanceof BoxersEntity animatable)
							animatable.setTexture("box");
					}
				}
				if (entity.getPersistentData().getDouble("Size") <= 5) {
					entity.getPersistentData().putDouble("Size", (entity.getPersistentData().getDouble("Size") + 0.1));
					entity.setCustomName(Component.literal("True Boxer"));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(300);
				} else {
					if (entity instanceof BoxersEntity animatable)
						animatable.setTexture("boxs");
				}
			} else {
				if (entity instanceof BoxersEntity animatable)
					animatable.setTexture("box");
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 200) {
				entity.getPersistentData().putDouble("Transform", 1);
			}
		}
	}
}
