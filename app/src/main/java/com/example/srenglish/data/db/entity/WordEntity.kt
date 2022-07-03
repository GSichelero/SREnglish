package com.example.srenglish.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word")
data class WordEntity (
    @PrimaryKey(autoGenerate = true)
    val word_id: Long = 0,
    val question: String,
    val answer: String
)