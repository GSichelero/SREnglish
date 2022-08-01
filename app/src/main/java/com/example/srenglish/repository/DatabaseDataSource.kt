package com.example.srenglish.repository

import androidx.lifecycle.LiveData
import com.example.srenglish.data.db.dao.DeckDAO
import com.example.srenglish.data.db.dao.GameDAO
import com.example.srenglish.data.db.dao.WordDAO
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.data.db.entity.GameEntity
import com.example.srenglish.data.db.entity.WordEntity
import com.example.srenglish.data.db.entity.relationship.GameWithWords
import com.example.srenglish.data.db.entity.relationship.GameWordCrossRef

class DatabaseDataSource(
    private val deckDAO: DeckDAO,
    private val gameDAO: GameDAO,
    private val wordDAO: WordDAO
) : DatabaseRepository {
// DECKS
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

    override suspend fun getAllDecks(): List<DeckEntity> {
        return deckDAO.getAll()
    }

// GAMES
    override suspend fun insertGame(name: String, deck_id: Long, words_per_day: Long): Long {
        val game = GameEntity(
            name = name,
            words_per_day = words_per_day,
            deck_id = deck_id
        )
        return gameDAO.insert(game)
    }

    override suspend fun updateGame(game_id: Long, name: String, deck_id: Long, words_per_day: Long) {
        val game = GameEntity(
            game_id = game_id,
            name = name,
            words_per_day = words_per_day,
            deck_id = deck_id
        )
        gameDAO.update(game)
    }

    override suspend fun deleteGame(game_id: Long) {
        gameDAO.delete(game_id)
    }

    override suspend fun getAllGames(): LiveData<List<GameEntity>> {
        return gameDAO.getAll()
    }

    override suspend fun insertGameWordCrossRef(game_id: Long, word_id: Long, day: Long, times_seen: Long) {
        val game_word_x_ref = GameWordCrossRef(
            game_id = game_id,
            word_id = word_id,
            day = day,
            times_seen = times_seen
        )
        gameDAO.insertGameWordCrossRef(game_word_x_ref)
    }

    override suspend fun getGameWithWords(game_id: Long): LiveData<List<GameWithWords>> {
        return gameDAO.getGameWithWords(game_id)
    }

// WORDS
    override suspend fun insertWord(question: String, answer: String): Long {
        val word = WordEntity(
            question = question,
            answer = answer
        )
        return wordDAO.insert(word)
    }

    override suspend fun updateWord(word_id: Long, question: String, answer: String) {
        val word = WordEntity(
            word_id = word_id,
            question = question,
            answer = answer
        )
        wordDAO.update(word)
    }

    override suspend fun deleteWord(word_id: Long) {
        wordDAO.delete(word_id)
    }

    override suspend fun getAllWords(): LiveData<List<WordEntity>> {
        return wordDAO.getAll()
    }
}