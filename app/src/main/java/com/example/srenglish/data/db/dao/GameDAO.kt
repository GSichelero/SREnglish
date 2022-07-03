package com.example.srenglish.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.srenglish.data.db.entity.GameEntity
import com.example.srenglish.data.db.entity.relationship.GameWithWords
import com.example.srenglish.data.db.entity.relationship.GameWordCrossRef

@Dao
interface GameDAO {
    @Insert
    suspend fun insert(game: GameEntity): Long

    @Update
    suspend fun update(game: GameEntity)

    @Query("DELETE FROM game WHERE game_id = :game_id")
    suspend fun delete(game_id: Long)

    @Query("SELECT * FROM game")
    fun getAll(): LiveData<List<GameEntity>>

    @Insert
    suspend fun insertGameWordCrossRef(crossRef: GameWordCrossRef)

    @Transaction
    @Query("SELECT * FROM game WHERE game_id = :game_id")
    fun getGameWithWords(game_id: Long): LiveData<List<GameWithWords>>


}