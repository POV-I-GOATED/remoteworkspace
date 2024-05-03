package net.mcreator.stellar.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.stellar.network.StellarModVariables;
import net.mcreator.stellar.init.StellarModMobEffects;

public class UraniumOreEntityCollidesInTheBlocksProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role == 4)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(StellarModMobEffects.RADATION.get(), 20, 2, true, true));
		}
	}
}
