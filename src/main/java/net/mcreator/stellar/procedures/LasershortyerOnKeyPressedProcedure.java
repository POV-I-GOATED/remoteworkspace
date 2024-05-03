package net.mcreator.stellar.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.network.StellarModVariables;
import net.mcreator.stellar.init.StellarModEntities;
import net.mcreator.stellar.entity.LaserEntity;

public class LasershortyerOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).Role == 1) {
			{
				Entity _shootFrom = entity;
				Level projectileLevel = _shootFrom.level();
				if (!projectileLevel.isClientSide()) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
							AbstractArrow entityToSpawn = new LaserEntity(StellarModEntities.LASER.get(), level);
							entityToSpawn.setOwner(shooter);
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setKnockback(knockback);
							entityToSpawn.setSilent(true);
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, entity, 2, 3);
					_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
					_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		}
	}
}
