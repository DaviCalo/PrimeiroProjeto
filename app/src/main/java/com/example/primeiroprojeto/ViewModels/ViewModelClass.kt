package com.example.primeiroprojeto.ViewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass: ViewModel() {
    private val _inputStringClass = mutableStateOf("")
    val inputStringClass: MutableState<String> = _inputStringClass

    private val _checkedClassBox = MutableLiveData<Map<Int, Boolean>>()
    val checkedClassBox: LiveData<Map<Int, Boolean>> = _checkedClassBox

    init {
        _checkedClassBox.value = mapOf(
            1 to false,
            2 to false,
            3 to false
        )
    }

    fun onCheckBoxClicked(id: Int, isChecked: Boolean){
        _checkedClassBox.value = _checkedClassBox.value?.toMutableMap()?.apply {
            this[id] = isChecked
        }
    }

    fun areAllCkeckBoxesChecked(): Boolean{
        return _checkedClassBox.value?.all { it.value } ?: false
    }

}