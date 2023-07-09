package com.example.verybasiccomposestate.examples

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateHoistingViewModel: ViewModel() {
    private val _count = mutableStateOf(0)
    private val _anotherCount = MutableLiveData(0)

    val count: State<Int> = _count
    val anotherCount: LiveData<Int> = _anotherCount

    fun increaseCount() {
        _count.value++
    }

    fun decreaseCount() {
        _count.value--
    }

    fun increaseAnotherCount() {
        _anotherCount.value = _anotherCount.value?.plus(1)
    }

    fun decreaseAnotherCount() {
        _anotherCount.value = _anotherCount.value?.minus(1)
    }
}