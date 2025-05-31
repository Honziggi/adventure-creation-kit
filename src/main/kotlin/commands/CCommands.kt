package com.honziggi.adventure_creation_kit.commands

import com.honziggi.adventure_creation_kit.MODID
import com.mojang.brigadier.arguments.DoubleArgumentType
import net.minecraft.commands.Commands
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraftforge.event.RegisterCommandsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
object CCommands {
    @SubscribeEvent
    fun onCommandRegister(event: RegisterCommandsEvent) {
        event.dispatcher.register(
            Commands.literal("sethealth")
                .then(
                    Commands.argument("amount", DoubleArgumentType.doubleArg(1.0, 100.0))
                    .executes { context ->
                        val player = context.source.playerOrException
                        val amount = DoubleArgumentType.getDouble(context, "amount")

                        val attr = player.getAttribute(Attributes.MAX_HEALTH)
                        if (attr != null) {
                            attr.baseValue = amount
                            player.health = amount.toFloat().coerceAtMost(player.maxHealth)
                            context.source.sendSuccess({ Component.literal("Set max health to $amount")}, true)
                        } else {
                            context.source.sendFailure(Component.literal("Failed to modify max health"))
                        }
                        1
                    })
        )
    }
}