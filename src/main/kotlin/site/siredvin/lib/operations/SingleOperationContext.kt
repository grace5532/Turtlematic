package site.siredvin.lib.operations

import java.io.Serializable

class SingleOperationContext(var count: Int, val distance: Int) : Serializable {

    fun extraCount(extra: Int): SingleOperationContext {
        count += extra
        return SingleOperationContext(extra, distance)
    }
}