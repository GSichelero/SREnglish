package com.example.srenglish.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.srenglish.data.db.entity.DeckEntity

@Dao
interface DeckDAO {
    @Insert
    fun insert(deck: DeckEntity): Long

    @Update
    suspend fun update(deck: DeckEntity)

    @Query("DELETE FROM deck WHERE deck_id = :deck_id")
    suspend fun delete(deck_id: Long)

    @Query("SELECT * FROM deck")
    fun getAll(): LiveData<List<DeckEntity>>
}