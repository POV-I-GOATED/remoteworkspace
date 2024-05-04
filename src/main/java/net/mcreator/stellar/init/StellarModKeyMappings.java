
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.stellar.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.stellar.network.RClickMessage;
import net.mcreator.stellar.network.LasershortyerMessage;
import net.mcreator.stellar.StellarMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class StellarModKeyMappings {
	public static final KeyMapping R_CLICK = new KeyMapping("key.stellar.r_click", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				StellarMod.PACKET_HANDLER.sendToServer(new RClickMessage(0, 0));
				RClickMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping LASERSHORTYER = new KeyMapping("key.stellar.lasershortyer", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				StellarMod.PACKET_HANDLER.sendToServer(new LasershortyerMessage(0, 0));
				LasershortyerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				LASERSHORTYER_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - LASERSHORTYER_LASTPRESS);
				StellarMod.PACKET_HANDLER.sendToServer(new LasershortyerMessage(1, dt));
				LasershortyerMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long LASERSHORTYER_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(R_CLICK);
		event.register(LASERSHORTYER);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				R_CLICK.consumeClick();
				LASERSHORTYER.consumeClick();
			}
		}
	}
}
