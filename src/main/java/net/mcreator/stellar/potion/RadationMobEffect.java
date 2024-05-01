
package net.mcreator.stellar.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.stellar.procedures.RadationOnEffectActiveTickProcedure;

public class RadationMobEffect extends MobEffect {
	public RadationMobEffect() {
		super(MobEffectCategory.HARMFUL, -13369549);
	}

	@Override
	public String getDescriptionId() {
		return "effect.stellar.radation";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RadationOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
