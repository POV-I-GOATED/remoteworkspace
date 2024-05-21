package net.mcreator.stellar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.stellar.network.StellarModVariables;
import net.mcreator.stellar.init.StellarModMobEffects;
import net.mcreator.stellar.init.StellarModItems;
import net.mcreator.stellar.init.StellarModGameRules;
import net.mcreator.stellar.init.StellarModEntities;
import net.mcreator.stellar.entity.KniteEntity;
import net.mcreator.stellar.StellarMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class DisablitysProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Strengh = 0;
		Entity playerr = null;
		if (3 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			if (3 == Mth.nextInt(RandomSource.create(), 1, 1000)) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = StellarModEntities.KNITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				StellarMod.queueServerWork(1, () -> {
					if (!world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(KniteEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
							_toTame.tame(_owner);
					}
				});
			}
		}
		if (1 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0));
		}
		if (3 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/item replace entity @s armor.head with stellar:crown_helmet{Unbreakable:1} 1");
				}
			}
		}
		if (!(3 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(StellarModItems.CROWN_HELMET.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (4 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 10, 0));
		}
		if (5 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			if ((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Blcks) {
				if ((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new StellarModVariables.PlayerVariables())).holdingR < (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Blocks * 10) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component
								.literal(("Block Power Left " + new java.text.DecimalFormat("##.##").format((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Blocks * 10
										- (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).holdingR))),
								true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 3, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1, 255, false, false));
				}
			} else {
				if ((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).holdingR > 0) {
					{
						double _setval = (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).holdingR - 0.1;
						entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.holdingR = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								("Block Power Regainded " + new java.text.DecimalFormat("##.##").format((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Blocks * 10
										- (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).holdingR))),
								true);
				}
			}
		}
		if (5 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			Strengh = Mth.nextInt(RandomSource.create(), -2, (int) (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).ChanceLuck);
			if (Strengh == -1) {
				{
					double _setval = -1;
					entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.damage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1, (world.getLevelData().getGameRules().getInt(StellarModGameRules.WEAKNESS)), false, false));
			} else if (Strengh == -2) {
				{
					double _setval = -2;
					entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.damage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1, 255, false, false));
			} else if (Strengh == 0) {
				{
					double _setval = 0;
					entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.damage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (Strengh == 1) {
				{
					double _setval = 0;
					entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.damage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					double _setval = 1;
					entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.damage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1,
							Mth.nextInt(RandomSource.create(), 0, (int) (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).StrongLuck), false, false));
			}
		}
		if (StellarModItems.URANIUMA_HELMET.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()) {
			if (StellarModItems.URANIUMA_CHESTPLATE.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()) {
				if (StellarModItems.URANIUMA_LEGGINGS.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem()) {
					if (StellarModItems.URANIUMA_BOOTS.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()) {
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, z), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((x + 1), y, z)).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((x + 1), y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, z), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((x + -1), y, z)).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((x + -1), y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 1)), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, (z + 1))).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, (z + 1))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + -1)), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + -1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, (z + -1))).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, (z + -1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, (z + -1))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, (z + -1)), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, (z + -1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((x + 1), y, (z + -1))).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, (z + -1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((x + 1), y, (z + -1))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, (z + 1)), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((x + -1), y, (z + 1))).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((x + -1), y, (z + 1))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, (z + -1)), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, (z + -1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((x + -1), y, (z + -1))).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + -1), y, (z + -1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((x + -1), y, (z + -1))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
						if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, (z + 1)), 2, 2, 2), e -> true).isEmpty()) {
							if (!(entity == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((x + 1), y, (z + 1))).findFirst().orElse(null)))) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 1), y, (z + 1)), 2, 2, 2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf((x + 1), y, (z + 1))).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 100, 2, true, true));
							}
						}
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("TF") == 1) {
			if (entity.getPersistentData().getDouble("VP") == 1) {
				if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
						.isEmpty()) {
					entity.getPersistentData().putDouble("LocX", (((Entity) world
							.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getX()));
					entity.getPersistentData().putDouble("LocY", (((Entity) world
							.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getY()));
					entity.getPersistentData().putDouble("LocZ", (((Entity) world
							.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getZ()));
				}
			}
			if (entity.getPersistentData().getDouble("VP") == 2) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
						.isEmpty()) {
					entity.getPersistentData().putDouble("LocX", (((Entity) world
							.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getX()));
					entity.getPersistentData().putDouble("LocY", (((Entity) world
							.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getY()));
					entity.getPersistentData().putDouble("LocZ", (((Entity) world
							.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getZ()));
				}
			}
		}
	}
}
