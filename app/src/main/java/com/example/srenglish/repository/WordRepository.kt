package com.example.srenglish.repository

import androidx.lifecycle.LiveData
import com.example.srenglish.data.db.entity.WordEntity

interface WordRepository {

    suspend fun insertWord(question: String, answer: String): Long

    suspend fun updateWord(word_id: Long, question: String, answer: String)

    suspend fun deleteWord(word_id: Long)

    suspend fun getAllWords(): LiveData<List<WordEntity>>
}