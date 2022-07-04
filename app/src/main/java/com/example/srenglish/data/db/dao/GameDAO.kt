package com.example.srenglish.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.srenglish.data.db.entity.GameEntity
import com.example.srenglish.data.db.entity.WordEntity
import com.example.srenglish.data.db.entity.relationship.GameWithWords
import com.example.srenglish.data.db.entity.relationship.GameWordCrossRef


@Dao
interface GameDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(game: GameEntity): Long

    @Update
    suspend fun update(game: GameEntity)

    @Query("DELETE FROM game WHERE game_id =:game_id")
    suspend fun delete(game_id: Long)

    @Query("SELECT * FROM game")
    fun getAll(): LiveData<List<GameEntity>>

    @Insert
    fun insertGameWordCrossRef(crossRef: GameWordCrossRef)

    @Transaction
    @Query("SELECT * FROM game WHERE game_id =:game_id")
    fun getGameWithWords(game_id: Long): List<GameWithWords>

    @Query("SELECT * FROM game_word")
    fun getGamesWords(): List<GameWordCrossRef>

    @Query("SELECT * FROM game_word WHERE game_id =:game_id AND day != 0 ORDER BY day")
    fun getFirstWord(game_id: Long): List<GameWordCrossRef>

    @Query("UPDATE game_word SET day = 0 WHERE game_id =:game_id AND word_id =:word_id")
    fun deleteFromGameXWord(game_id: Long, word_id: Long)

    @Query("SELECT * FROM word WHERE word_id =:word_id")
    fun selectWord(word_id: Long): List<WordEntity>


}