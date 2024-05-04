package net.mcreator.stellar.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.network.StellarModVariables;

public class TextforboserProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String Texts = "";
		return " Luck " + new java.text.DecimalFormat("##.##").format((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).ChanceLuck - 2) + " " + "Strength "
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).StrongLuck) + " " + "Block Power "
				+ new java.text.DecimalFormat("##.##").format((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Blocks - 1);
	}
}
