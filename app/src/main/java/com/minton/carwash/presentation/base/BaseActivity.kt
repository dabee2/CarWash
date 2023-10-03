package com.minton.carwash.presentation.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelLazy
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected val TAG: String = this::class.java.simpleName
    protected lateinit var binding: B

    @get:LayoutRes
    protected abstract val layoutId: Int

    private val viewModelClass = ((javaClass.genericSuperclass as ParameterizedType?)
        ?.actualTypeArguments
        ?.get(1) as Class<VM>).kotlin

    protected open val viewModel by ViewModelLazy(
        viewModelClass,
        { viewModelStore },
        { ViewModelFactory.instance },
        { defaultViewModelCreationExtras },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("$TAG",">> ${this::class.java.simpleName}.onCreate()")
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        with(binding) {
            val vm = 1 // BR class vm = 1 (XML의 vm)
            setVariable(vm, viewModel)
            lifecycleOwner = this@BaseActivity
        }

    }

    override fun onStart() {
        Log.v("$TAG",">> ${this::class.java.simpleName}.onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.v("$TAG",">> ${this::class.java.simpleName}.onResume()")
        super.onResume()
    }

    override fun onNewIntent(intent: Intent?) {
        Log.v("$TAG", ">> ${this::class.java.simpleName}.onNewIntent()")
        super.onNewIntent(intent)
    }

    override fun onPause() {
        Log.v("$TAG", ">> ${this::class.java.simpleName}.onPause()")
        super.onPause()
    }

    override fun onDestroy() {
        Log.v("$TAG", ">> ${this::class.java.simpleName}.onDestroy()")
        super.onDestroy()
    }
}