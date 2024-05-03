package net.mcreator.stellar.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.network.StellarModVariables;

public class ChoserThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role == 5)) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
