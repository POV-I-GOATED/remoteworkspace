package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.StellarMod;

public class MoverssOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		StellarMod.queueServerWork(2, () -> {
			entity.setDeltaMovement(new Vec3((entity.getPersistentData().getDouble("mystartx")), (entity.getPersistentData().getDouble("mystarty")), (entity.getPersistentData().getDouble("mystartz"))));
		});
	}
}
