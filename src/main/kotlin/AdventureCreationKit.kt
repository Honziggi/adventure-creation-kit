package com.honziggi.adventure_creation_kit

import com.honziggi.adventure_creation_kit.init.BlockItemRegistry
import com.honziggi.adventure_creation_kit.init.BlockRegistry
import com.honziggi.adventure_creation_kit.init.ItemRegistry
import com.honziggi.adventure_creation_kit.keybind.KeyBindHandler.registerKeybindings
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

const val MODID = "adventure_creation_kit"

@Mod(MODID)
object AdventureCreationKit {

    val LOGGER: Logger = LogManager.getLogger("adventure_creation_kit")

    init {
        LOGGER.log(Level.INFO, "$MODID random logger message!")

        MOD_BUS.addListener(::onClientSetup)

        ItemRegistry.register(MOD_BUS)
        BlockRegistry.register(MOD_BUS)
        BlockItemRegistry.register(MOD_BUS)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
        MOD_BUS.addListener(::registerKeybindings)
    }

}