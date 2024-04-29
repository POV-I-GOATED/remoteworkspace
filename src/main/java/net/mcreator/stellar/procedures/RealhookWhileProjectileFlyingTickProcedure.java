package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class RealhookWhileProjectileFlyingTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("X")), (entity.getPersistentData().getDouble("Y")), (entity.getPersistentData().getDouble("Z"))));
	}
}
