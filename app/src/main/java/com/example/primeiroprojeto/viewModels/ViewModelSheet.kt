package com.example.primeiroprojeto.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelSheet: ViewModel() {
    private val _Sheet = mutableStateOf(false)

    val sheet: MutableState<Boolean> = _Sheet
}