package site.siredvin.apcode.plugins

import dan200.computercraft.api.lua.LuaFunction
import dan200.computercraft.api.lua.MethodResult
import dan200.computercraft.api.peripheral.IPeripheral
import net.minecraft.world.InteractionResult
import site.siredvin.lib.metaphysics.IFeedableAutomataCore
import site.siredvin.lib.peripherals.BaseAutomataCorePeripheral
import site.siredvin.lib.peripherals.owner.TurtlePeripheralOwner

class AutomataSoulFeedingPlugin(automataCore: BaseAutomataCorePeripheral) : AutomataCorePlugin(automataCore) {
    @LuaFunction(mainThread = true)
    fun feedSoul(): MethodResult {
        val owner: TurtlePeripheralOwner = automataCore!!.peripheralOwner
        if (owner.toolInMainHand.item !is IFeedableAutomataCore) {
            return MethodResult.of(null, "Well, you should feed correct mechanical soul!")
        }
        // TODO: Fix
//        val result: InteractionResult = owner.withPlayer(APFakePlayer::useOnEntity)
        val result = InteractionResult.FAIL
        automataCore.addRotationCycle(3)
        return MethodResult.of(true, result.toString())
    }

    override fun isSuitable(peripheral: IPeripheral): Boolean {
        return peripheral::class.java == BaseAutomataCorePeripheral::class.java
    }
}