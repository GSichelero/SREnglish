package com.example.srenglish.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.srenglish.data.db.dao.DeckDAO
import com.example.srenglish.data.db.dao.GameDAO
import com.example.srenglish.data.db.dao.WordDAO
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.data.db.entity.GameEntity
import com.example.srenglish.data.db.entity.WordEntity
import com.example.srenglish.data.db.entity.relationship.DeckWordCrossRef
import com.example.srenglish.data.db.entity.relationship.GameWordCrossRef

@Database(entities = [
    DeckEntity::class,
    GameEntity::class,
    WordEntity::class,
    DeckWordCrossRef::class,
    GameWordCrossRef::class
                     ], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract val deckDAO: DeckDAO
    abstract val gameDAO: GameDAO
    abstract val wordDAO: WordDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance: AppDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                }

                return instance
            }
        }
    }
}