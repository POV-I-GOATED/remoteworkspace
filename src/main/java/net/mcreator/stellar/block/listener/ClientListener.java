package net.mcreator.stellar.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.stellar.init.StellarModBlockEntities;
import net.mcreator.stellar.block.renderer.GateTileRenderer;
import net.mcreator.stellar.block.renderer.BoxingRingLineTileRenderer;
import net.mcreator.stellar.block.renderer.BoxingRingConerTileRenderer;
import net.mcreator.stellar.StellarMod;

@Mod.EventBusSubscriber(modid = StellarMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(StellarModBlockEntities.BOXING_RING_LINE.get(), context -> new BoxingRingLineTileRenderer());
		event.registerBlockEntityRenderer(StellarModBlockEntities.BOXING_RING_CONER.get(), context -> new BoxingRingConerTileRenderer());
		event.registerBlockEntityRenderer(StellarModBlockEntities.GATE.get(), context -> new GateTileRenderer());
	}
}
