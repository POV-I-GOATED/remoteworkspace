package net.mcreator.stellar.procedures;

import net.minecraft.world.entity.Entity;

public class SProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double yes = 0;
		if (entity.getPersistentData().getDouble("Transform") == 1) {
			yes = 5;
		} else {
			yes = 2;
		}
		return yes;
	}
}
