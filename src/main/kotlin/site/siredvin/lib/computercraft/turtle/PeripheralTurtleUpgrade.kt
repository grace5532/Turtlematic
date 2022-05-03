package site.siredvin.lib.computercraft.turtle

import dan200.computercraft.api.turtle.TurtleUpgradeType
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import site.siredvin.lib.api.peripheral.IBasePeripheral
import site.siredvin.lib.util.turtleAdjective

abstract class PeripheralTurtleUpgrade<T : IBasePeripheral<*>> : BaseTurtleUpgrade<T> {
    constructor(id: ResourceLocation, adjective: String, item: ItemStack) : super(
        id,
        TurtleUpgradeType.PERIPHERAL,
        adjective,
        item
    )

    constructor(id: ResourceLocation, item: ItemStack) : super(
        id,
        TurtleUpgradeType.PERIPHERAL,
        turtleAdjective(id),
        item
    )
}