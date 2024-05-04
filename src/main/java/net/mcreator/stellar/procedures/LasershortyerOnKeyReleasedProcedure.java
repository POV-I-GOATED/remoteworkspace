package net.mcreator.stellar.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.network.StellarModVariables;

public class LasershortyerOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (5 == (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role) {
			{
				boolean _setval = false;
				entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Blcks = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
