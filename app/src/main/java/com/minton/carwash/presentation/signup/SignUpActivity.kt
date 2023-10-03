package com.minton.carwash.presentation.signup

import android.os.Bundle
import com.minton.carwash.R
import com.minton.carwash.databinding.ActivitySignUpBinding
import com.minton.carwash.presentation.base.BaseActivity

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel>() {
    override val layoutId: Int = R.layout.activity_sign_up

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}