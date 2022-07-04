package com.example.srenglish.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deck")
data class DeckEntity (
    @PrimaryKey(autoGenerate = true)
    val deck_id: Long = 1,
    val name: String
)