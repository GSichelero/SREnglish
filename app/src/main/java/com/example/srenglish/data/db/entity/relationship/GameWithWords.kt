package com.example.srenglish.data.db.entity.relationship

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.srenglish.data.db.entity.GameEntity
import com.example.srenglish.data.db.entity.WordEntity

data class GameWithWords (
    @Embedded val game: GameEntity,
    @Relation(
        parentColumn = "game_id",
        entityColumn = "word_id",
        associateBy = Junction(GameWordCrossRef::class)
    )
    val words: List<WordEntity>
)