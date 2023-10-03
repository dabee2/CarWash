package com.minton.carwash.presentation.main

import androidx.lifecycle.viewModelScope
import com.minton.carwash.libs.event.MutableEventFlow
import com.minton.carwash.libs.event.asEventFlow
import com.minton.carwash.presentation.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    fun moveMyPage() {
        event(Event.MoveMyPage)
    }

    fun event(event: Event) {
        viewModelScope.launch { _eventFlow.emit(event) }
    }

    sealed class Event {
        object MoveMyPage : Event()
    }
}