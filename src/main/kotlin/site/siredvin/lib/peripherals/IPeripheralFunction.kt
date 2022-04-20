package site.siredvin.lib.peripherals

import dan200.computercraft.api.lua.LuaException

fun interface IPeripheralFunction<T, R> {
    @Throws(LuaException::class)
    fun apply(var1: T): R
}