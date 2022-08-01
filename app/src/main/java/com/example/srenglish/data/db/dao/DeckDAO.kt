package com.example.srenglish.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.srenglish.data.db.entity.DeckEntity

@Dao
interface DeckDAO {
    @Insert
    suspend fun insert(deck: DeckEntity): Long

    @Update
    suspend fun update(deck: DeckEntity)

    @Query("DELETE FROM deck WHERE deck_id = :deck_id")
    suspend fun delete(deck_id: Long)

    @Query("SELECT * FROM deck")
    suspend fun getAll(): List<DeckEntity>
}