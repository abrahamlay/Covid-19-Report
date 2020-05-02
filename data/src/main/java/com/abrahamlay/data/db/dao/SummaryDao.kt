package com.abrahamlay.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import com.abrahamlay.domain.entities.SummaryData
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Abraham Lay on 29/04/20.
 */

@Dao
interface SummaryDao : BaseDao<SummaryData> {

    @Query("SELECT * FROM SummaryData")
    override fun selectObjectAll(): Flowable<SummaryData>

    @Query("SELECT * FROM SummaryData")
    override fun selectCollectionAll(): Flowable<List<SummaryData>>

    @Query("SELECT * FROM SummaryData WHERE id = :id")
    fun select(id: Int): Flowable<SummaryData>

    @Transaction
    fun replace(summaryData: SummaryData?): Completable {
        return try {
            summaryData?.let {
                deleteAll()
                insert(summaryData)
            }
            Completable.complete()
        } catch (e: Exception) {
            Completable.error(e)
        }
    }

    @Delete
    override fun delete(t: SummaryData): Int

    @Query("DELETE FROM SummaryData")
    override fun deleteAll()

}