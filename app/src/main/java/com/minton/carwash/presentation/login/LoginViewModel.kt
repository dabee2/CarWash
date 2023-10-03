package com.minton.carwash.presentation.login

import androidx.lifecycle.viewModelScope
import com.minton.carwash.libs.event.MutableEventFlow
import com.minton.carwash.libs.event.asEventFlow
import com.minton.carwash.presentation.base.BaseViewModel
import com.minton.carwash.util.RegularExpression
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel() {
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()
    private val _inputId = MutableStateFlow("")
    val inputId = _inputId.asStateFlow()
    private val _inputPw = MutableStateFlow("")
    val inputPw = _inputPw.asStateFlow()
    private val _idHelperText = MutableStateFlow("")
    val idHelperText = _idHelperText.asStateFlow()
    private val _pwHelperText = MutableStateFlow("")
    val pwHelperText = _pwHelperText.asStateFlow()

    fun changeId(changedId: String) {
        _inputId.value = changedId
    }

    fun changePw(changedPw: String) {
        _inputPw.value = changedPw
    }

    fun setIdHelperText(msg: String) {
        _idHelperText.value = msg
    }

    fun setPwHelperText(msg: String) {
        _pwHelperText.value = msg
    }

    fun checkValidateId(): Boolean {
        return if (!RegularExpression.isValidCarNumber(inputId.value)) {
            setIdHelperText("차량번호 오류 다시입력")
            false
        } else {
            setIdHelperText("")
            true
        }
    }

    fun checkValidatePw(): Boolean {
        return if (!RegularExpression.isValidPhone(inputPw.value)) {
            setPwHelperText("번호 오류 다시입력")
            false
        } else {
            setPwHelperText("")
            true
        }
    }

    fun login() {
        if (!checkValidateId() || !checkValidatePw()) return

        event(Event.Login)
    }

    fun signUp() {
        event(Event.SingUp)
    }

    private fun event(event: Event) {
        viewModelScope.launch { _eventFlow.emit(event) }
    }

    sealed class Event {
        object Login : Event()
        object SingUp : Event()
    }
}