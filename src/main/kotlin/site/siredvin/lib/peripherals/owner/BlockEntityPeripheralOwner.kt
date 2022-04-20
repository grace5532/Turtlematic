package site.siredvin.lib.peripherals.owner

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import site.siredvin.lib.peripherals.IPeripheralTileEntity
import site.siredvin.lib.util.DataStorageUtil
import java.util.*

class BlockEntityPeripheralOwner<T>(val tileEntity: T) :
    BasePeripheralOwner() where T : BlockEntity, T : IPeripheralTileEntity {

    override val level: Level?
        get() = Objects.requireNonNull(tileEntity.level)
    override val pos: BlockPos
        get() = tileEntity.blockPos

    //        return tileEntity.getBlockState().getValue(APTileEntityBlock.FACING);
    // TODO: Change
    override val facing: Direction
        get() =//        return tileEntity.getBlockState().getValue(APTileEntityBlock.FACING);
            // TODO: Change
            Direction.DOWN
    override val owner: Player?
        get() = null
    override val dataStorage: CompoundTag
        get() = DataStorageUtil.getDataStorage(tileEntity)

    override fun markDataStorageDirty() {
        tileEntity.setChanged()
    }

    //    @Override
    //    public <T1> T1 withPlayer(Function<APFakePlayer, T1> function) {
    //        throw new RuntimeException("Not implemented yet");
    //    }
    override val toolInMainHand: ItemStack
        get() = ItemStack.EMPTY

    override fun storeItem(stored: ItemStack): ItemStack {
        // TODO: tricks with capability needed
        throw RuntimeException("Not implemented yet")
    }

    override fun destroyUpgrade() {
        level!!.removeBlock(tileEntity!!.blockPos, false)
    }

    override fun isMovementPossible(level: Level, pos: BlockPos): Boolean {
        return false
    }

    override fun move(level: Level, pos: BlockPos): Boolean {
        return false
    }
}