package com.honziggi.adventure_creation_kit.hud

import com.honziggi.adventure_creation_kit.MODID
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RenderGuiOverlayEvent
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import kotlin.math.ceil

@Mod.EventBusSubscriber(modid = MODID, value = [Dist.CLIENT], bus = Mod.EventBusSubscriber.Bus.FORGE)
object HeartHudOverlay {
    @Suppress("DEPRECATION")
    val HEART_TEXTURE = ResourceLocation(MODID, "textures/gui/quarter_hearts.png")

    @JvmStatic
    @SubscribeEvent
    fun onRender(event: RenderGuiOverlayEvent.Pre) {
        if (event.overlay.id != VanillaGuiOverlay.PLAYER_HEALTH.id()) return

        println("Overlay event: ${event.overlay.id}")
        val player = Minecraft.getInstance().player ?: return
        val health = player.health.coerceAtMost(player.maxHealth)
        val hearts = ceil(player.maxHealth / 2.0).toInt()

        //Cancel vanilla rendering

        val xStart = 10
        val yStart = 10

        for (i in 0 until hearts) {
            val heartValue = (health - i * 2.0).coerceIn(0.0, 2.0)
            val spriteX = when {
                heartValue >= 2.0 -> 0 //full
                heartValue >= 1.5 -> 9
                heartValue >= 1.0 -> 18
                heartValue >= 0.5 -> 27 //1/4
                else -> 36
            }.toFloat()

            event.guiGraphics.blit(
                HEART_TEXTURE, xStart + i * 9, yStart,
                spriteX, 0.0f,
                9, 9,
                45, 9
            )
        }
        event.guiGraphics.drawString(
            Minecraft.getInstance().font,
            "Fuck you", xStart, yStart - 10, 0xFFFFFF
        )

        event.isCanceled = true
    }
}