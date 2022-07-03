package com.example.srenglish.ui.deck

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.srenglish.repository.DatabaseRepository
import kotlinx.coroutines.launch

class DeckViewModel(
    private val repository: DatabaseRepository
): ViewModel() {

    private val _deckStateEventData = MutableLiveData<DeckState>()
    val deckStateEventData: LiveData<DeckState>
        get() = _deckStateEventData

    private val _messageStateEventData = MutableLiveData<String>()
    val messageStateEventData: LiveData<String>
        get() = _messageStateEventData

    fun addDeck(name: String) = viewModelScope.launch {
        try {
            val id = repository.insertDeck(name)
            if (id > 0) {
                _deckStateEventData.value = DeckState.Inserted
                _messageStateEventData.value = "Deck Added Successfully!"
            }
        } catch (ex: Exception) {
            Log.e(TAG, ex.toString())
        }
    }

    sealed class DeckState {
        object Inserted : DeckState()
    }

    companion object {
        private val TAG = DeckViewModel::class.java.simpleName
    }
}