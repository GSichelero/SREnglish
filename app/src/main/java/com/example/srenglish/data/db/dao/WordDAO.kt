package com.example.srenglish.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.srenglish.data.db.entity.WordEntity
import com.example.srenglish.data.db.entity.relationship.GameWithWords

@Dao
interface WordDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: WordEntity): Long

    @Update
    suspend fun update(word: WordEntity)

    @Query("DELETE FROM word WHERE word_id = :word_id")
    suspend fun delete(word_id: Long)

    @Query("SELECT * FROM word")
    fun getAll(): LiveData<List<WordEntity>>

    @Query("SELECT * FROM word WHERE word_id = :word_id")
    fun selectWord(word_id: Long): WordEntity
}