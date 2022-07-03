package com.example.srenglish.data.db.entity.relationship

import androidx.room.Embedded
import androidx.room.Relation
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.data.db.entity.GameEntity

data class DeckWithGames (
    @Embedded val deck: DeckEntity,
    @Relation(
        parentColumn = "game_id",
        entityColumn = "deck_id"
    )
    val games: List<GameEntity>
)