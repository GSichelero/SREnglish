package com.example.srenglish.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.srenglish.data.db.entity.WordEntity

@Dao
interface WordDAO {
    @Insert
    suspend fun insert(word: WordEntity): Long

    @Update
    suspend fun update(word: WordEntity)

    @Query("DELETE FROM word WHERE word_id = :word_id")
    suspend fun delete(word_id: Long)

    @Query("SELECT * FROM word")
    fun getAll(): LiveData<List<WordEntity>>
}