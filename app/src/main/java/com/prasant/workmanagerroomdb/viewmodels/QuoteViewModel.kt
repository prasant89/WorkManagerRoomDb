package com.prasant.workmanagerroomdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prasant.workmanagerroomdb.model.data.QuoteList
import com.prasant.workmanagerroomdb.model.repo.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }
    }

    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}