@file:Suppress("HasPlatformType", "unused")

package com.honziggi.adventure_creation_kit.init

import com.honziggi.adventure_creation_kit.MODID
import com.honziggi.adventure_creation_kit.blocks.NullBlock
import net.minecraft.world.level.block.Block
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object BlockRegistry {

    private val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID)

    fun register(bus: IEventBus) = BLOCKS.register(bus)

    val NULL_BLOCK = BLOCKS.register<Block>("null_block") { NullBlock }

}