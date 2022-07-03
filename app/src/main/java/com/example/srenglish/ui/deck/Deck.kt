package com.example.srenglish.ui.deck

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gsichelero.contactmanager.extension.hideKeyboard
import com.example.srenglish.R
import com.example.srenglish.data.db.AppDatabase
import com.example.srenglish.data.db.dao.DeckDAO
import com.example.srenglish.data.db.dao.GameDAO
import com.example.srenglish.data.db.dao.WordDAO
import com.example.srenglish.repository.DatabaseDataSource
import com.example.srenglish.repository.DatabaseRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_deck.*

class Deck : Fragment(R.layout.fragment_deck) {

    private val viewModel: DeckViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val deckDAO: DeckDAO = AppDatabase.getInstance(requireContext()).deckDAO
                val gameDAO: GameDAO = AppDatabase.getInstance(requireContext()).gameDAO
                val wordDAO: WordDAO = AppDatabase.getInstance(requireContext()).wordDAO

                val repository: DatabaseRepository = DatabaseDataSource(deckDAO, gameDAO, wordDAO)
                return DeckViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvents()
        setListeners()
    }

    private fun observeEvents() {
        viewModel.deckStateEventData.observe(viewLifecycleOwner) {
            deckState -> when (deckState) {
                is DeckViewModel.DeckState.Inserted -> {
                    clearFields()
                    hideKeyboard()
                }
            }
        }

        viewModel.messageStateEventData.observe(viewLifecycleOwner) {
            stringResId -> Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun clearFields() {
        input_name.text?.clear()
    }

    private fun hideKeyboard() {
        val parentActivity = requireActivity()
        if (parentActivity is AppCompatActivity) {
            parentActivity.hideKeyboard()
        }
    }

    private fun setListeners() {
        button_deck.setOnClickListener {
            val name = input_name.text.toString()

            viewModel.addDeck(name)
        }
    }
}