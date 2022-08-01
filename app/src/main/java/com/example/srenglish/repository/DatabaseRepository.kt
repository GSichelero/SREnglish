package com.example.srenglish.repository

import androidx.lifecycle.LiveData
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.data.db.entity.GameEntity
import com.example.srenglish.data.db.entity.WordEntity
import com.example.srenglish.data.db.entity.relationship.GameWithWords

interface DatabaseRepository {
// DECKS
    suspend fun insertDeck(name: String): Long

    suspend fun updateDeck(deck_id: Long, name: String)

    suspend fun deleteDeck(deck_id: Long)

    suspend fun getAllDecks(): List<DeckEntity>

// GAMES
    suspend fun insertGame(name: String, words_per_day: Long, deck_id: Long): Long

    suspend fun updateGame(game_id: Long, name: String, words_per_day: Long, deck_id: Long)

    suspend fun deleteGame(game_id: Long)

    suspend fun getAllGames(): LiveData<List<GameEntity>>

    suspend fun insertGameWordCrossRef(game_id: Long, word_id: Long, day: Long, times_seen: Long)

    suspend fun getGameWithWords(game_id: Long): LiveData<List<GameWithWords>>

// WORDS
    suspend fun insertWord(question: String, answer: String): Long

    suspend fun updateWord(word_id: Long, question: String, answer: String)

    suspend fun deleteWord(word_id: Long)

    suspend fun getAllWords(): LiveData<List<WordEntity>>
}