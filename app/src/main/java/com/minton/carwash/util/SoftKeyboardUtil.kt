package com.minton.carwash.util

import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

object SoftKeyboardUtil {
    fun showSoftKeyboard(view: EditText) { // 소프트키보드 올리기
        val imm =
            view.context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        view.requestFocus()
        imm.showSoftInput(view, 0)
    }

    fun hideSoftKeyboard(view: EditText) {
        val imm =
            view.context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}