package com.minton.carwash.presentation.login

import android.content.Intent
import android.os.Bundle
import com.minton.carwash.R
import com.minton.carwash.databinding.ActivityLoginBinding
import com.minton.carwash.libs.ext.repeatOnStarted
import com.minton.carwash.presentation.base.BaseActivity
import com.minton.carwash.presentation.main.MainActivity
import com.minton.carwash.presentation.signup.SignUpActivity

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutId: Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupUiEvent()
        setupObserve()
    }

    private fun setupUiEvent() {

    }

    private fun setupObserve() {
        repeatOnStarted {
            viewModel.eventFlow.collect { handleEvent(it) }
        }
    }

    private fun handleEvent(event: LoginViewModel.Event) = when (event) {
        LoginViewModel.Event.Login -> moveMain()
        LoginViewModel.Event.SingUp -> moveSignUp()
    }

    private fun moveMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun moveSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
}