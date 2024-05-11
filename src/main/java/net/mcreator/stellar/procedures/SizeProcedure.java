package net.mcreator.stellar.procedures;

import net.minecraft.world.entity.Entity;

public class SizeProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDouble("Size") + 3;
	}
}
