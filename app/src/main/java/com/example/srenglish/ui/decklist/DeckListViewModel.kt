package com.example.srenglish.ui.decklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.srenglish.data.db.entity.DeckEntity
import com.example.srenglish.repository.DatabaseRepository
import kotlinx.coroutines.launch

class DeckListViewModel(
    private val repository: DatabaseRepository
) : ViewModel() {

    private val _allDecksEvent = MutableLiveData<List<DeckEntity>>()
    val allDecksEvent: LiveData<List<DeckEntity>>
        get() = _allDecksEvent

    fun getDecks() = viewModelScope.launch {
        _allDecksEvent.postValue(repository.getAllDecks())
    }
}