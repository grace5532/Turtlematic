package site.siredvin.lib.peripherals

import dan200.computercraft.api.peripheral.IComputerAccess
import dan200.computercraft.api.peripheral.IPeripheral
import site.siredvin.lib.peripherals.owner.IPeripheralOwner

interface IBasePeripheral<T : IPeripheralOwner?> : IPeripheral {
    val isEnabled: Boolean
    val connectedComputers: List<IComputerAccess>
    val peripheralOwner: T
}