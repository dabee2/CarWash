package com.minton.carwash.presentation.main

import android.content.Intent
import android.os.Bundle
import com.minton.carwash.R
import com.minton.carwash.databinding.ActivityMainBinding
import com.minton.carwash.libs.ext.repeatOnStarted
import com.minton.carwash.presentation.base.BaseActivity
import com.minton.carwash.presentation.mypage.MyPageActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val layoutId: Int = R.layout.activity_main

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

    private fun handleEvent(event: MainViewModel.Event) = when(event) {
        MainViewModel.Event.MoveMyPage -> moveMyPage()
    }

    private fun moveMyPage(){
        startActivity(Intent(this, MyPageActivity::class.java))
    }
}