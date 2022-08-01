package com.example.srenglish.ui.decklist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.srenglish.R
import com.example.srenglish.data.db.AppDatabase
import com.example.srenglish.data.db.dao.DeckDAO
import com.example.srenglish.data.db.dao.GameDAO
import com.example.srenglish.data.db.dao.WordDAO
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.repository.DatabaseDataSource
import com.example.srenglish.repository.DatabaseRepository
import com.example.srenglish.ui.deck.DeckViewModel
import kotlinx.android.synthetic.main.fragment_deck_list.*

class DeckList : Fragment(R.layout.fragment_deck_list) {

    private val viewModel: DeckListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val deckDAO: DeckDAO = AppDatabase.getInstance(requireContext()).deckDAO
                val gameDAO: GameDAO = AppDatabase.getInstance(requireContext()).gameDAO
                val wordDAO: WordDAO = AppDatabase.getInstance(requireContext()).wordDAO

                val repository: DatabaseRepository = DatabaseDataSource(deckDAO, gameDAO, wordDAO)
                return DeckListViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModelEvents()
        configureViewListeners()

    }

    private fun observeViewModelEvents() {
        viewModel.allDecksEvent.observe(viewLifecycleOwner)  { allDecks ->
            val deckListAdapter = DeckListAdapter(allDecks)
            
            with(recycler_decks) {
                setHasFixedSize(true)
                adapter = deckListAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDecks()
    }

    private fun configureViewListeners() {
        fabAddDeck.setOnClickListener {
            findNavController().navigate(R.id.deck)
        }
    }

}