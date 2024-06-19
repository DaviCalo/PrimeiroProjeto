package com.example.primeiroprojeto.ViewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
class ViewModelSup:  ViewModel() {
    private val _InputSeach = mutableStateOf("")

    val InputSeach: MutableState<String> = _InputSeach
}