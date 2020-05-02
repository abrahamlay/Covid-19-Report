package com.abrahamlay.data.mapper

import io.reactivex.functions.Function
import java.util.*


/**
 * Created by Abraham Lay on 28/04/20.
 */

abstract class BaseMapper<FROM, TO>() : Function<FROM, TO> {
    @Throws(Exception::class)
    open fun apply(fromList: Collection<FROM>): Collection<TO?>? {
        val result: MutableCollection<TO?> = ArrayList()
        for (from in fromList) {
            val item = apply(from)
            result.add(item)
        }
        return result
    }

    @Throws(Exception::class)
    override fun apply(from: FROM): TO? {
        return null
    }
}