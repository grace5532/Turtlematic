package site.siredvin.turtlematic.computercraft.turtle

import dan200.computercraft.api.turtle.ITurtleAccess
import dan200.computercraft.api.turtle.TurtleSide
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import site.siredvin.lib.computercraft.peripheral.owner.TurtlePeripheralOwner
import site.siredvin.lib.computercraft.turtle.FacingBlockTurtle
import site.siredvin.turtlematic.Turtlematic
import site.siredvin.turtlematic.computercraft.peripheral.misc.PistonPeripheral

class PistonTurtle: FacingBlockTurtle<PistonPeripheral>(ID, ItemStack(Items.PISTON)) {
    companion object {
        val ID = ResourceLocation(Turtlematic.MOD_ID, "piston")
    }

    override fun buildPeripheral(turtle: ITurtleAccess, side: TurtleSide): PistonPeripheral {
        return PistonPeripheral(TurtlePeripheralOwner(turtle, side))
    }
}