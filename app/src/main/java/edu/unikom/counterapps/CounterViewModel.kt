package edu.unikom.counterapps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor() : ViewModel() {
    
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int> = _counter
    
    init {
        _counter.value = 0
    }
    
    fun increment() {
        _counter.value = (_counter.value ?: 0) + 1
    }
    
    fun decrement() {
        _counter.value = (_counter.value ?: 0) - 1
    }
} 