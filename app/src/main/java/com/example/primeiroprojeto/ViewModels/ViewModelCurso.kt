package com.example.primeiroprojeto.ViewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelCurso: ViewModel(){
    private val _search = mutableStateOf("")

    val search: MutableState<String> = _search
}