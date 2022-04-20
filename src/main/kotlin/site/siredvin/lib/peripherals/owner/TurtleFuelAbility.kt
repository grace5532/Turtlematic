package site.siredvin.lib.peripherals.owner

import dan200.computercraft.ComputerCraft

class TurtleFuelAbility(owner: TurtlePeripheralOwner, override val maxFuelConsumptionRate: Int) :
    FuelAbility<TurtlePeripheralOwner>(owner) {

    override fun _consumeFuel(count: Int): Boolean {
        return owner.turtle.consumeFuel(count)
    }

    override val isFuelConsumptionDisable: Boolean
        get() = !ComputerCraft.turtlesNeedFuel
    override val fuelCount: Int
        get() = owner.turtle.fuelLevel
    override val fuelMaxCount: Int
        get() = owner.turtle.fuelLimit

    override fun addFuel(count: Int) {
        owner.turtle.addFuel(count)
    }
}