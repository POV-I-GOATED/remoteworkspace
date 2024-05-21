package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

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
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).isEmpty()) {
				if (entity.getPersistentData().getDouble("Doing") == 0) {
					rand = Mth.nextInt(RandomSource.create(), 1, 20);
					if (rand == 1) {
						if (entity instanceof BoxersEntity) {
							((BoxersEntity) entity).setAnimation("Fight");
						}
						entity.getPersistentData().putDouble("Doing", 1);
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))
								.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("stellar:hurt")))), 15);
					}
					if (rand == 2) {
						if (entity instanceof BoxersEntity) {
							((BoxersEntity) entity).setAnimation("Block");
						}
						entity.getPersistentData().putDouble("Doing", 2);
					}
					if (rand == 3) {
						if (entity instanceof BoxersEntity) {
							((BoxersEntity) entity).setAnimation("Kick");
						}
						entity.getPersistentData().putDouble("Doing", 3);
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))
								.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("stellar:hurt")))), 15);
					}
					if (rand == 4) {
						if (entity instanceof BoxersEntity) {
							((BoxersEntity) entity).setAnimation("Super_Punch");
						}
						entity.getPersistentData().putDouble("Doing", 4);
					}
				}
				if (entity.getPersistentData().getDouble("Doing") == 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1, 100, false, false));
					entity.getPersistentData().putDouble("Time", (entity.getPersistentData().getDouble("Time") + 1));
					if (entity.getPersistentData().getDouble("Time") >= 60) {
						entity.getPersistentData().putDouble("Time", 0);
						entity.getPersistentData().putDouble("Doing", 0);
						if (entity instanceof BoxersEntity) {
							((BoxersEntity) entity).setAnimation("empty");
						}
					}
				}
				if (entity.getPersistentData().getDouble("Doing") == 4) {
					if (entity.getPersistentData().getDouble("Time") % 5 == 3) {
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null))
								.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("stellar:hurt")))), 5);
					}
					entity.getPersistentData().putDouble("Time", (entity.getPersistentData().getDouble("Time") + 1));
					if (entity.getPersistentData().getDouble("Time") >= 46) {
						entity.getPersistentData().putDouble("Time", 0);
						entity.getPersistentData().putDouble("Doing", 0);
					}
				}
				if (entity.getPersistentData().getDouble("Doing") == 3) {
					entity.getPersistentData().putDouble("Time", (entity.getPersistentData().getDouble("Time") + 1));
					if (entity.getPersistentData().getDouble("Time") >= 10) {
						entity.getPersistentData().putDouble("Time", 0);
						entity.getPersistentData().putDouble("Doing", 0);
					}
				}
				if (entity.getPersistentData().getDouble("Doing") == 1) {
					entity.getPersistentData().putDouble("Time", (entity.getPersistentData().getDouble("Time") + 1));
					if (entity.getPersistentData().getDouble("Time") >= 10) {
						entity.getPersistentData().putDouble("Time", 0);
						entity.getPersistentData().putDouble("Doing", 0);
					}
				}
			}
		}
	}
}
