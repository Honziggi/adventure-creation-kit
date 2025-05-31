package com.honziggi.adventure_creation_kit.blocks


import net.minecraft.world.level.block.Block

object NullBlock : Block(
    Properties
        .of()
        .instabreak()
        .friction(10f)
)