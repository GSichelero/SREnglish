package com.example.srenglish.data.db.entity.relationship

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.data.db.entity.WordEntity

data class DeckWithWords (
    @Embedded val deck: DeckEntity,
    @Relation(
        parentColumn = "deck_id",
        entityColumn = "word_id",
        associateBy = Junction(DeckWordCrossRef::class)
    )
    val words: List<WordEntity>
)