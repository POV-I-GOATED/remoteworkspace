package net.mcreator.stellar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.stellar.network.StellarModVariables;
import net.mcreator.stellar.init.StellarModItems;
import net.mcreator.stellar.init.StellarModGameRules;

public class Button2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).StrongLuck <= (world.getLevelData().getGameRules().getInt(StellarModGameRules.MAX_STRENGTH))) {
			{
				double _setval = (entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new StellarModVariables.PlayerVariables())).StrongLuck + 1;
				entity.getCapability(StellarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.StrongLuck = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(StellarModItems.BOXINGINCREAER.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
