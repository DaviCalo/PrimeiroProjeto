package com.example.primeiroprojeto.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
class ViewModelSup:  ViewModel() {
    private val _InputSeach = mutableStateOf("")

    val inputSeach: MutableState<String> = _InputSeach
}