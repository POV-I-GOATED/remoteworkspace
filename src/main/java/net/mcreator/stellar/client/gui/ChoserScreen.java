package net.mcreator.stellar.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.stellar.world.inventory.ChoserMenu;
import net.mcreator.stellar.procedures.TextforboserProcedure;
import net.mcreator.stellar.network.ChoserButtonMessage;
import net.mcreator.stellar.StellarMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChoserScreen extends AbstractContainerScreen<ChoserMenu> {
	private final static HashMap<String, Object> guistate = ChoserMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_speed;
	Button button_strength;

	public ChoserScreen(ChoserMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("stellar:textures/screens/choser.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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

				TextforboserProcedure.execute(entity), 28, 41, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_speed = Button.builder(Component.translatable("gui.stellar.choser.button_speed"), e -> {
			if (true) {
				StellarMod.PACKET_HANDLER.sendToServer(new ChoserButtonMessage(0, x, y, z));
				ChoserButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 3, this.topPos + 15, 51, 20).build();
		guistate.put("button:button_speed", button_speed);
		this.addRenderableWidget(button_speed);
		button_strength = Button.builder(Component.translatable("gui.stellar.choser.button_strength"), e -> {
			if (true) {
				StellarMod.PACKET_HANDLER.sendToServer(new ChoserButtonMessage(1, x, y, z));
				ChoserButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 14, 67, 20).build();
		guistate.put("button:button_strength", button_strength);
		this.addRenderableWidget(button_strength);
	}
}
