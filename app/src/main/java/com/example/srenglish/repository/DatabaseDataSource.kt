package com.example.srenglish.repository

import androidx.lifecycle.LiveData
import com.example.srenglish.data.db.dao.DeckDAO
import com.example.srenglish.data.db.dao.GameDAO
import com.example.srenglish.data.db.dao.WordDAO
import com.example.srenglish.data.db.entity.DeckEntity

class DatabaseDataSource(
    private val deckDAO: DeckDAO,
    private val gameDAO: GameDAO,
    private val wordDAO: WordDAO
) : DeckRepository {

    override suspend fun insertDeck(name: String): Long {
        val deck = DeckEntity(
            name = name
        )
        return deckDAO.insert(deck)
    }

    override suspend fun updateDeck(deck_id: Long, name: String) {
        val deck = DeckEntity(
            deck_id = deck_id,
            name = name
        )
        deckDAO.update(deck)
    }

    override suspend fun deleteDeck(deck_id: Long) {
        deckDAO.delete(deck_id)
    }

    override suspend fun getAllDecks(): LiveData<List<DeckEntity>> {
        return deckDAO.getAll()
    }
}