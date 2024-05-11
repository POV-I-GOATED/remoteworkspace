package net.mcreator.stellar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class XProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		String thisd = "";
		if (entity.getPersistentData().getDouble("TF") == 1) {
			if (entity.getPersistentData().getDouble("VP") == 1) {
				if (!world.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
						.isEmpty()) {
					thisd = new java.text.DecimalFormat("##.##").format(((Entity) world
							.getEntitiesOfClass(Villager.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getX());
				}
			} else if (entity.getPersistentData().getDouble("VP") == 2) {
				if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
						.isEmpty()) {
					thisd = new java.text.DecimalFormat("##.##").format(((Entity) world
							.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ"))), 3, 3, 3), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((entity.getPersistentData().getDouble("LocX")), (entity.getPersistentData().getDouble("LocY")), (entity.getPersistentData().getDouble("LocZ")))).findFirst().orElse(null)).getX());
				}
			} else {
				thisd = new java.text.DecimalFormat("##.##").format(entity.getX());
			}
		} else {
			thisd = new java.text.DecimalFormat("##.##").format(entity.getX());
		}
		return "Your/ Your Enity X position is:" + thisd;
	}
}
