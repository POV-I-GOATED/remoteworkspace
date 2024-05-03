
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StellarModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> MAX_SPEED = GameRules.register("maxSpeed", GameRules.Category.PLAYER, GameRules.IntegerValue.create(7));
	public static final GameRules.Key<GameRules.IntegerValue> MAX_STRENGTH = GameRules.register("maxStrength", GameRules.Category.PLAYER, GameRules.IntegerValue.create(5));
	public static final GameRules.Key<GameRules.IntegerValue> WEAKNESS = GameRules.register("weakness", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1));
}
