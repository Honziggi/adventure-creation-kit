package com.honziggi.adventure_creation_kit.items

import net.minecraft.server.level.ServerPlayer
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import java.util.*

class HeartItems (
    private val healthIncrease: Double,
    private val uniqueKey: String,
    private val sound: SoundEvent = SoundEvents.PLAYER_LEVELUP
) : Item(Properties().stacksTo(1)) {

    override fun useOn(context: UseOnContext): InteractionResult {
        val player = context.player as? ServerPlayer ?: return InteractionResult.PASS
        if (context.level.isClientSide) return InteractionResult.SUCCESS

        val attribute = player.getAttribute(Attributes.MAX_HEALTH)
        val uuid = UUID.nameUUIDFromBytes(uniqueKey.toByteArray())

        if (attribute?.getModifier(uuid) != null) return InteractionResult.FAIL

        attribute?.addPermanentModifier(
            AttributeModifier(
                uuid, "Heart upgrade: $uniqueKey", healthIncrease, AttributeModifier.Operation.ADDITION
            )
        )

        player.playSound(sound, 1.0f, 1.0f)
        context.itemInHand.shrink(1)
        return InteractionResult.SUCCESS
    }
}