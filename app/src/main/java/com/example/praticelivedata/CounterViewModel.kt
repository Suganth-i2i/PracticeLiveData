package com.example.praticelivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class CounterViewModel : ViewModel() {
    var counter = MutableLiveData<Int>().apply {
        value = 0
    }

    fun incCount() {
        viewModelScope.launch(Dispatchers.Main) {
                counter.value?.let {
                    counter.setValue(it+1)
            }
        }
    }

    fun decCount() {
        viewModelScope.launch(Dispatchers.Main) {
            counter.value?.let {
                counter.setValue(it-1)
            }
        }
    }

    fun getCount(): LiveData<Int>{
        return counter
    }
}