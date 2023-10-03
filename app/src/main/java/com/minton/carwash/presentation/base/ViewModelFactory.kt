package com.minton.carwash.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minton.carwash.presentation.login.LoginViewModel
import com.minton.carwash.presentation.main.MainViewModel
import com.minton.carwash.presentation.mypage.MyPageViewModel
import com.minton.carwash.presentation.signup.SignUpViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    companion object {
        val instance by lazy { ViewModelFactory() }
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel() as T
        } else if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        } else if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            return SignUpViewModel() as T
        } else if (modelClass.isAssignableFrom(MyPageViewModel::class.java)) {
            return MyPageViewModel() as T
        }
        throw IllegalArgumentException("뷰모델 생성 불가")
    }
}