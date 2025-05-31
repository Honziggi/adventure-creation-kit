@file:Suppress("HasPlatformType", "unused")

package com.honziggi.adventure_creation_kit.init

import com.honziggi.adventure_creation_kit.MODID
import com.honziggi.adventure_creation_kit.items.HeartItems
import com.honziggi.adventure_creation_kit.items.SadObsidianMaker
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ItemRegistry {

    // for register
    private val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    fun register(bus: IEventBus) = ITEMS.register(bus)

    // ==================== //
    //     Normal Items     //
    // ==================== //

    val SAD_OBSIDIAN_MAKER = ITEMS.register("sad_obsidian_maker") { SadObsidianMaker }
    val HEART_PIECE = ITEMS.register("heart_piece") { HeartItems(0.5, "heart_piece") }
    val HEART_CONTAINER = ITEMS.register("heart_container") { HeartItems(2.0, "heart_container") }

}