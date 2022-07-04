package com.example.srenglish.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameEntity (
    @PrimaryKey(autoGenerate = true)
    val game_id: Long = 1,
    val name: String,
    val words_per_day: Long,
    val deck_id: Long
)