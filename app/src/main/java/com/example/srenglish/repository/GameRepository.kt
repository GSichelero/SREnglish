package com.example.srenglish.repository

import androidx.lifecycle.LiveData
import com.example.srenglish.data.db.entity.GameEntity

interface GameRepository {

    suspend fun insertGame(name: String): Long

    suspend fun updateGame(game_id: Long, name: String)

    suspend fun deleteGame(game_id: Long)

    suspend fun getAllGames(): LiveData<List<GameEntity>>
}