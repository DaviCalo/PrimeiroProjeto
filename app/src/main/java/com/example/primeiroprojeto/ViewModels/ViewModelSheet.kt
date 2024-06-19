package com.example.primeiroprojeto.ViewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelSheet: ViewModel() {
    private val _Sheet = mutableStateOf(false)

    val Sheet: MutableState<Boolean> = _Sheet
}