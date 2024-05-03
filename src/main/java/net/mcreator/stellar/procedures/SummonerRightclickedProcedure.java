package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.stellar.network.StellarModVariables;
import net.mcreator.stellar.init.StellarModItems;
import net.mcreator.stellar.init.StellarModEntities;
import net.mcreator.stellar.entity.KniteEntity;
import net.mcreator.stellar.StellarMod;

import java.util.Comparator;

public class SummonerRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(StellarModItems.SUMMONER.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if ((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role == 3) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			StellarMod.queueServerWork(1, () -> {
				if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
					_toTame.tame(_owner);
				StellarMod.queueServerWork(1, () -> {
					{
						Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null));
						_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
					}
					StellarMod.queueServerWork(1, () -> {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						StellarMod.queueServerWork(1, () -> {
							if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
								_toTame.tame(_owner);
							StellarMod.queueServerWork(1, () -> {
								{
									Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null));
									_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
								}
								StellarMod.queueServerWork(1, () -> {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
									StellarMod.queueServerWork(1, () -> {
										if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
											_toTame.tame(_owner);
										StellarMod.queueServerWork(1, () -> {
											{
												Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(x, y, z)).findFirst().orElse(null));
												_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
											}
											StellarMod.queueServerWork(1, () -> {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
													if (entityToSpawn != null) {
														entityToSpawn.setDeltaMovement(0, 0, 0);
													}
												}
												StellarMod.queueServerWork(1, () -> {
													if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
														_toTame.tame(_owner);
													StellarMod.queueServerWork(1, () -> {
														{
															Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null));
															_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
															if (_ent instanceof ServerPlayer _serverPlayer)
																_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
														}
														StellarMod.queueServerWork(1, () -> {
															if (world instanceof ServerLevel _level) {
																Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																if (entityToSpawn != null) {
																	entityToSpawn.setDeltaMovement(0, 0, 0);
																}
															}
															StellarMod.queueServerWork(1, () -> {
																if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																	}
																}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
																	_toTame.tame(_owner);
																StellarMod.queueServerWork(1, () -> {
																	{
																		Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																			}
																		}.compareDistOf(x, y, z)).findFirst().orElse(null));
																		_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
																		if (_ent instanceof ServerPlayer _serverPlayer)
																			_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
																	}
																	StellarMod.queueServerWork(1, () -> {
																		if (world instanceof ServerLevel _level) {
																			Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																			if (entityToSpawn != null) {
																				entityToSpawn.setDeltaMovement(0, 0, 0);
																			}
																		}
																		StellarMod.queueServerWork(1, () -> {
																			if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																				}
																			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
																				_toTame.tame(_owner);
																			StellarMod.queueServerWork(1, () -> {
																				{
																					Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																						}
																					}.compareDistOf(x, y, z)).findFirst().orElse(null));
																					_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
																					if (_ent instanceof ServerPlayer _serverPlayer)
																						_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(),
																								_ent.getXRot());
																				}
																				StellarMod.queueServerWork(1, () -> {
																					if (world instanceof ServerLevel _level) {
																						Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																						if (entityToSpawn != null) {
																							entityToSpawn.setDeltaMovement(0, 0, 0);
																						}
																					}
																					StellarMod.queueServerWork(1, () -> {
																						if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																							}
																						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
																							_toTame.tame(_owner);
																						StellarMod.queueServerWork(1, () -> {
																							{
																								Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																									}
																								}.compareDistOf(x, y, z)).findFirst().orElse(null));
																								_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
																								if (_ent instanceof ServerPlayer _serverPlayer)
																									_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(),
																											_ent.getXRot());
																							}
																							StellarMod.queueServerWork(1, () -> {
																								if (world instanceof ServerLevel _level) {
																									Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																									if (entityToSpawn != null) {
																										entityToSpawn.setDeltaMovement(0, 0, 0);
																									}
																								}
																								StellarMod.queueServerWork(1, () -> {
																									if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																										}
																									}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
																										_toTame.tame(_owner);
																									StellarMod.queueServerWork(1, () -> {
																										{
																											Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream()
																													.sorted(new Object() {
																														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																														}
																													}.compareDistOf(x, y, z)).findFirst().orElse(null));
																											_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
																											if (_ent instanceof ServerPlayer _serverPlayer)
																												_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)),
																														_ent.getYRot(), _ent.getXRot());
																										}
																										StellarMod.queueServerWork(1, () -> {
																											if (world instanceof ServerLevel _level) {
																												Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																												if (entityToSpawn != null) {
																													entityToSpawn.setDeltaMovement(0, 0, 0);
																												}
																											}
																											StellarMod.queueServerWork(1, () -> {
																												if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream()
																														.sorted(new Object() {
																															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																															}
																														}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
																													_toTame.tame(_owner);
																												StellarMod.queueServerWork(1, () -> {
																													{
																														Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream()
																																.sorted(new Object() {
																																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																		return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																																	}
																																}.compareDistOf(x, y, z)).findFirst().orElse(null));
																														_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
																														if (_ent instanceof ServerPlayer _serverPlayer)
																															_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y,
																																	(z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
																													}
																													StellarMod.queueServerWork(1, () -> {
																														if (world instanceof ServerLevel _level) {
																															Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
																															if (entityToSpawn != null) {
																																entityToSpawn.setDeltaMovement(0, 0, 0);
																															}
																														}
																														StellarMod.queueServerWork(1, () -> {
																															if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream()
																																	.sorted(new Object() {
																																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																			return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																																		}
																																	}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame
																																	&& entity instanceof Player _owner)
																																_toTame.tame(_owner);
																															StellarMod.queueServerWork(1, () -> {
																																{
																																	Entity _ent = ((Entity) world
																																			.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream()
																																			.sorted(new Object() {
																																				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																																				}
																																			}.compareDistOf(x, y, z)).findFirst().orElse(null));
																																	_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y, (z + Mth.nextInt(RandomSource.create(), 5, 10)));
																																	if (_ent instanceof ServerPlayer _serverPlayer)
																																		_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y,
																																				(z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
																																}
																																StellarMod.queueServerWork(1, () -> {
																																	if (world instanceof ServerLevel _level) {
																																		Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z),
																																				MobSpawnType.MOB_SUMMONED);
																																		if (entityToSpawn != null) {
																																			entityToSpawn.setDeltaMovement(0, 0, 0);
																																		}
																																	}
																																	StellarMod.queueServerWork(1, () -> {
																																		if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true)
																																				.stream().sorted(new Object() {
																																					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																																					}
																																				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame
																																				&& entity instanceof Player _owner)
																																			_toTame.tame(_owner);
																																		StellarMod.queueServerWork(1, () -> {
																																			{
																																				Entity _ent = ((Entity) world
																																						.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true)
																																						.stream().sorted(new Object() {
																																							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																																							}
																																						}.compareDistOf(x, y, z)).findFirst().orElse(null));
																																				_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y,
																																						(z + Mth.nextInt(RandomSource.create(), 5, 10)));
																																				if (_ent instanceof ServerPlayer _serverPlayer)
																																					_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y,
																																							(z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
																																			}
																																			StellarMod.queueServerWork(1, () -> {
																																				if (world instanceof ServerLevel _level) {
																																					Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z),
																																							MobSpawnType.MOB_SUMMONED);
																																					if (entityToSpawn != null) {
																																						entityToSpawn.setDeltaMovement(0, 0, 0);
																																					}
																																				}
																																				StellarMod.queueServerWork(1, () -> {
																																					if (((Entity) world
																																							.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true)
																																							.stream().sorted(new Object() {
																																								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																																								}
																																							}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame
																																							&& entity instanceof Player _owner)
																																						_toTame.tame(_owner);
																																					StellarMod.queueServerWork(1, () -> {
																																						{
																																							Entity _ent = ((Entity) world.getEntitiesOfClass(KniteEntity.class,
																																									AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
																																										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																																											return Comparator
																																													.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																																										}
																																									}.compareDistOf(x, y, z)).findFirst().orElse(null));
																																							_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 5, 10)), y,
																																									(z + Mth.nextInt(RandomSource.create(), 5, 10)));
																																							if (_ent instanceof ServerPlayer _serverPlayer)
																																								_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 5, 10)), y,
																																										(z + Mth.nextInt(RandomSource.create(), 5, 10)), _ent.getYRot(), _ent.getXRot());
																																						}
																																					});
																																				});
																																			});
																																		});
																																	});
																																});
																															});
																														});
																													});
																												});
																											});
																										});
																									});
																								});
																							});
																						});
																					});
																				});
																			});
																		});
																	});
																});
															});
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		}
	}
}
