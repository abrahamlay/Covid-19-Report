package com.abrahamlay.data.datastore

import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 02/05/20.
 */
interface DataStore<DATA> {
    fun findFromAPI(): Flowable<DATA>
    fun findFromDb(): Flowable<DATA>
    fun findAll(): Flowable<DATA> {
        return findFromAPI().onErrorResumeNext(findFromDb())
    }

    fun persist(data: DATA): Completable
}