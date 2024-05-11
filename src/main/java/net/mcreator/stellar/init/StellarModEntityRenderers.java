
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.stellar.client.renderer.RealhookRenderer;
import net.mcreator.stellar.client.renderer.MoverssRenderer;
import net.mcreator.stellar.client.renderer.MoverRenderer;
import net.mcreator.stellar.client.renderer.LaserRenderer;
import net.mcreator.stellar.client.renderer.KniteRenderer;
import net.mcreator.stellar.client.renderer.BoxersRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class StellarModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(StellarModEntities.REALHOOK.get(), RealhookRenderer::new);
		event.registerEntityRenderer(StellarModEntities.MOVER.get(), MoverRenderer::new);
		event.registerEntityRenderer(StellarModEntities.MOVERSS.get(), MoverssRenderer::new);
		event.registerEntityRenderer(StellarModEntities.KNITE.get(), KniteRenderer::new);
		event.registerEntityRenderer(StellarModEntities.LASER.get(), LaserRenderer::new);
		event.registerEntityRenderer(StellarModEntities.BOXERS.get(), BoxersRenderer::new);
	}
}
