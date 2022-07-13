package com.example.praticelivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var counter = MutableLiveData<Int>().apply {
        value = 0
    }

    fun incCount() {
        counter.value?.let {
            counter.value = it+1
        }
    }

    fun decCount() {
        counter.value?.let {
            counter.value = it-1
        }
    }

    fun getCount(): LiveData<Int>{
        return counter
    }
}