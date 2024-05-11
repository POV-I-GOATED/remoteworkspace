package net.mcreator.stellar.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.stellar.world.inventory.LocatorMenu;
import net.mcreator.stellar.procedures.ZProcedure;
import net.mcreator.stellar.procedures.YProcedure;
import net.mcreator.stellar.procedures.XProcedure;
import net.mcreator.stellar.procedures.SHowsProcedure;
import net.mcreator.stellar.procedures.NameProcedure;
import net.mcreator.stellar.procedures.ItemsProcedure;
import net.mcreator.stellar.network.LocatorButtonMessage;
import net.mcreator.stellar.StellarMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class LocatorScreen extends AbstractContainerScreen<LocatorMenu> {
	private final static HashMap<String, Object> guistate = LocatorMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_player;
	Button button_villager;

	public LocatorScreen(LocatorMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (SHowsProcedure.execute(world, entity) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 139, this.topPos + 99, 75, 0f + (float) Math.atan((this.leftPos + 139 - mouseX) / 40.0), (float) Math.atan((this.topPos + 50 - mouseY) / 40.0), livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				XProcedure.execute(world, entity), -190, -80, -1, false);
		guiGraphics.drawString(this.font,

				YProcedure.execute(world, entity), -188, -35, -1, false);
		guiGraphics.drawString(this.font,

				ZProcedure.execute(world, entity), -189, -2, -1, false);
		guiGraphics.drawString(this.font,

				ItemsProcedure.execute(world, entity), -188, 42, -1, false);
		guiGraphics.drawString(this.font,

				NameProcedure.execute(world, entity), -186, 90, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_player = Button.builder(Component.translatable("gui.stellar.locator.button_player"), e -> {
			if (true) {
				StellarMod.PACKET_HANDLER.sendToServer(new LocatorButtonMessage(0, x, y, z));
				LocatorButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -81, this.topPos + -116, 56, 20).build();
		guistate.put("button:button_player", button_player);
		this.addRenderableWidget(button_player);
		button_villager = Button.builder(Component.translatable("gui.stellar.locator.button_villager"), e -> {
			if (true) {
				StellarMod.PACKET_HANDLER.sendToServer(new LocatorButtonMessage(1, x, y, z));
				LocatorButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 30, this.topPos + -114, 67, 20).build();
		guistate.put("button:button_villager", button_villager);
		this.addRenderableWidget(button_villager);
	}
}
