package com.example.srenglish.repository

import androidx.lifecycle.LiveData
import com.example.srenglish.data.db.entity.DeckEntity

interface DeckRepository {

    suspend fun insertDeck(name: String): Long

    suspend fun updateDeck(deck_id: Long, name: String)

    suspend fun deleteDeck(deck_id: Long)

    suspend fun getAllDecks(): LiveData<List<DeckEntity>>
}