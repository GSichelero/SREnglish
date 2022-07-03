package com.example.srenglish.data.db.entity.relationship

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.data.db.entity.WordEntity

@Entity(primaryKeys = ["word_id", "deck_id"])
data class DeckWordCrossRef (
    val word_id: Long,
    val deck_id: Long
)