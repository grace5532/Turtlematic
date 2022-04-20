package site.siredvin.lib.peripherals

import dan200.computercraft.api.lua.LuaException
import dan200.computercraft.api.lua.MethodResult
import dan200.computercraft.api.turtle.ITurtleAccess
import dan200.computercraft.api.turtle.TurtleSide
import net.minecraft.core.BlockPos
import site.siredvin.lib.metaphysics.IAutomataCoreTier
import site.siredvin.lib.operations.SingleOperation
import site.siredvin.lib.operations.SingleOperationContext
import site.siredvin.lib.peripherals.owner.TurtlePeripheralOwner
import site.siredvin.lib.util.DataStorageUtil

abstract class BaseAutomataCorePeripheral(
    type: String,
    turtle: ITurtleAccess,
    side: TurtleSide,
    tier: IAutomataCoreTier
) : BasePeripheral<TurtlePeripheralOwner>(
    type, TurtlePeripheralOwner(
        turtle, side
    )
) {
    private val tier: IAutomataCoreTier
    private val attributes: MutableMap<String, Boolean> = HashMap()

    init {
        peripheralOwner.attachFuel(tier.maxFuelConsumptionRate)
        peripheralOwner.attachOperation(possibleOperations())
        this.tier = tier
    }

    @JvmOverloads
    fun addRotationCycle(count: Int = 1) {
        DataStorageUtil.RotationCharge.addCycles(peripheralOwner, count)
    }

    fun possibleOperations(): List<IPeripheralOperation<*>> {
        return ArrayList()
    }

    override val peripheralConfiguration: MutableMap<String?, Any?>?
        get() {
            val data = super.peripheralConfiguration
            data!!["interactionRadius"] = interactionRadius
            return data
        }
    val interactionRadius: Int
        get() = tier.interactionRadius

    fun forUnknownDistance(): SingleOperationContext {
        return SingleOperationContext(1, interactionRadius)
    }

    fun toDistance(target: BlockPos?): SingleOperationContext {
        return SingleOperationContext(1, pos.distManhattan(target))
    }

    @Throws(LuaException::class)
    fun <T> withOperation(
        operation: IPeripheralOperation<T>,
        context: T,
        function: IPeripheralFunction<T, MethodResult>,
        check: IPeripheralCheck<T>?
    ): MethodResult {
        return withOperation(operation, context, check, function) { addRotationCycle() }
    }

    @Throws(LuaException::class)
    fun withOperation(
        operation: SingleOperation,
        function: IPeripheralFunction<SingleOperationContext, MethodResult>
    ): MethodResult {
        return withOperation(operation, forUnknownDistance(), function, null)
    }

    @Throws(LuaException::class)
    fun withOperation(
        operation: SingleOperation,
        function: IPeripheralFunction<SingleOperationContext, MethodResult>,
        check: IPeripheralCheck<SingleOperationContext>?
    ): MethodResult {
        return withOperation(operation, forUnknownDistance(), function, check)
    }

    fun hasAttribute(attribute: String): Boolean {
        return attributes.getOrDefault(attribute, false)
    }

    fun setAttribute(attribute: String) {
        attributes[attribute] = true
    }

    companion object {
        const val ATTR_STORING_TOOL_DURABILITY = "storingToolDurability"
    }
}