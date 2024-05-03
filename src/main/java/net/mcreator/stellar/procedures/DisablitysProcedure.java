package net.mcreator.stellar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.stellar.network.StellarModVariables;
import net.mcreator.stellar.init.StellarModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DisablitysProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double Strengh = 0;
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
			Strengh = Mth.nextInt(RandomSource.create(), -2, (int) StellarModVariables.MapVariables.get(world).ChanceLuck);
			if (Strengh == -1) {
				{
					double _setval = -1;
					entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.damage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1, 1, true, true));
			} else if (Strengh == -2) {
				{
					double _setval = -2;
					entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.damage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1, 255, true, true));
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
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1, Mth.nextInt(RandomSource.create(), 0, (int) StellarModVariables.MapVariables.get(world).StrongLuck), true, true));
			}
		}
	}
}
