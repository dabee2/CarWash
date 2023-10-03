package com.minton.carwash.presentation.base

import androidx.lifecycle.ViewModel
import com.minton.carwash.libs.event.MutableEventFlow
import com.minton.carwash.libs.event.asEventFlow

abstract class BaseViewModel : ViewModel() {

    private val _baseEventFlow = MutableEventFlow<Event>()
    val baseEventFlow = _baseEventFlow.asEventFlow()

    sealed class Event {
        data class ShowToast(val message: String) : Event()
    }
}