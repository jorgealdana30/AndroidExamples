package com.jorgealdana.eventbusexample.classes.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainActivityViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val stateCount: StateFlow<Int> = _count.asStateFlow()

    fun setCount(newValue: Int) {
        _count.update {
            newValue
        }
    }
}