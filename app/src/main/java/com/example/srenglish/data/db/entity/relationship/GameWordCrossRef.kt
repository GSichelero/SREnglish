package com.example.srenglish.data.db.entity.relationship

import androidx.room.Entity

@Entity(tableName = "game_word", primaryKeys = ["word_id", "game_id"])
data class GameWordCrossRef (
    val word_id: Long,
    val game_id: Long,
    val day: Long,
    val times_seen: Long
)