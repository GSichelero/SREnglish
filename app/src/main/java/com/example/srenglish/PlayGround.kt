package com.example.srenglish

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.srenglish.data.db.AppDatabase
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.data.db.entity.GameEntity
import com.example.srenglish.data.db.entity.WordEntity
import com.example.srenglish.data.db.entity.relationship.GameWithWords
import com.example.srenglish.data.db.entity.relationship.GameWordCrossRef
import com.example.srenglish.repository.DatabaseRepository
import com.example.srenglish.repository.DatabaseRepository.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PlayGround : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_ground)
        val gameDao = AppDatabase.getInstance(this).gameDAO
        val wordDao = AppDatabase.getInstance(this).wordDAO
        val deckDao = AppDatabase.getInstance(this).deckDAO

        // Create TextView programmatically.
        val questionView = findViewById<TextView>(R.id.textView3)
        val answerView = findViewById<TextView>(R.id.textView4)
        val remove = findViewById<Button>(R.id.button)
        val shuffle = findViewById<Button>(R.id.button2)
        val revealAnswer = findViewById<Button>(R.id.button3)

        val words = listOf(
            WordEntity(question = "should", answer = "used to indicate obligation, duty, or correctness, typically when criticizing someone's actions."),
            WordEntity(question = "have", answer = "possess or be provided with (a quality, characteristic, or feature)."),
            WordEntity(question = "foil", answer = "prevent (something considered wrong or undesirable) from succeeding."),
            WordEntity(question = "diary", answer = "a book in which one keeps a daily record of events and experiences."),
            WordEntity(question = "hill", answer = "a naturally raised area of land, not as high or craggy as a mountain."),
            WordEntity(question = "spoon", answer = "an implement consisting of a small, shallow oval or round bowl on a long handle, used for eating, stirring, and serving food."),
            WordEntity(question = "ghost", answer = "an apparition of a dead person which is believed to appear or become manifest to the living, typically as a nebulous image."),
            WordEntity(question = "actually", answer = "as the truth or facts of a situation; really."),
            WordEntity(question = "dog", answer = "a domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, nonretractable claws, and a barking, howling, or whining voice."),
            WordEntity(question = "car", answer = "a four-wheeled road vehicle that is powered by an engine and is able to carry a small number of people."),
        )

        val game_word = listOf(
            GameWordCrossRef(game_id = 1, word_id = 1, day = 1, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 2, day = 1, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 3, day = 1, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 4, day = 2, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 5, day = 2, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 6, day = 2, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 7, day = 3, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 8, day = 3, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 9, day = 3, times_seen = 0),
            GameWordCrossRef(game_id = 1, word_id = 10, day = 4, times_seen = 0),

        )

        var newQuestion = ""
        var newAnswer = ""

        // call the getGameWithWords function from the DatabaseRepository class.

//            words.forEach { wordDao.insert(it) }
//            deckDao.insert(DeckEntity(name = "Deck01"))
//            gameDao.insert(GameEntity(deck_id = 1, words_per_day = 3, name = "Game01"))
//            game_word.forEach { gameDao.insertGameWordCrossRef(it) }

//            var wordX = gameDao.getFirstWord(1)
//            var word = gameDao.selectWord(wordX[0].word_id)[0]
//            newQuestion = word.question
//            newAnswer = word.answer
//
                newQuestion = words[0].question
                newAnswer = words[0].answer
//            // setting text
            questionView.setText(newQuestion)

            answerView.setVisibility(View.INVISIBLE)
            answerView.setText(newAnswer)


        revealAnswer.setOnClickListener()
        {
            answerView.setVisibility(View.VISIBLE)
            Toast.makeText(this@PlayGround, "Answer",
                Toast.LENGTH_SHORT).show()
        }
        var clicks = 1
        remove.setOnClickListener() {

//                var wordX = gameDao.getFirstWord(1)
//                var word = gameDao.selectWord(wordX[0].word_id)[0]
//
////                gameDao.deleteFromGameXWord(game_id = 1, word_id = word.word_id)
//
//                var wordX2 = gameDao.getFirstWord(1)
//                var word2 = gameDao.selectWord(wordX2[0].word_id)[clicks]
                newQuestion = words[clicks].question
                newAnswer = words[clicks].answer

                // setting text
                questionView.setText(newQuestion)

                answerView.setVisibility(View.INVISIBLE)
                answerView.setText(newAnswer)

                clicks = clicks + 1

        }


        shuffle.setOnClickListener() {
//                var gameXword2 = gameDao.getFirstWord(1)
//
//                var newWord: WordEntity = wordDao.selectWord(gameXword2 + 1)
//
//                var newQuestion = newWord.question
//                var newAnswer = newWord.answer

            newQuestion = words[clicks].question
            newAnswer = words[clicks].answer

                // setting text
                questionView.setText(newQuestion)

                answerView.setVisibility(View.INVISIBLE)
                answerView.setText(newAnswer)
            clicks = clicks + 3
        }

        // Add TextView to LinearLayout
    }
}