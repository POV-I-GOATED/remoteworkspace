package net.mcreator.stellar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.stellar.network.StellarModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AttackProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (5 == (sourceentity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			if (-1 == (sourceentity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).damage) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Weak Shot"), true);
			} else if (0 == (sourceentity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).damage) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Normal Shot"), true);
			} else if (-2 == (sourceentity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).damage) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Super Weak shot"), true);
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Strong Shot"), true);
			}
		}
	}
}
