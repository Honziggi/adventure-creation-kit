package com.honziggi.adventure_creation_kit.init

import com.honziggi.adventure_creation_kit.hud.HeartHudOverlay
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = "adventure_creation_kit", value = [Dist.CLIENT], bus = Mod.EventBusSubscriber.Bus.MOD)
object ClientModEventSubscriber {

    @SubscribeEvent
    fun onRegisterOverlays(event: RegisterGuiOverlaysEvent) {
        // 👇 This line forces HeartHudOverlay to be initialized and its event registered
        HeartHudOverlay.toString()
    }
}
