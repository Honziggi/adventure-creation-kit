package com.honziggi.adventure_creation_kit.creativetabs

import com.honziggi.adventure_creation_kit.MODID
import com.honziggi.adventure_creation_kit.blocks.NullBlock
import com.honziggi.adventure_creation_kit.items.SadObsidianMaker
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Suppress("unused")
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ExampleCreativeModTab {

    @SubscribeEvent
    fun buildContents(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey == ResourceLocation(MODID, "example")) {
            event.accept(ItemStack(NullBlock))
            event.accept(ItemStack(SadObsidianMaker))
        }
    }
}
