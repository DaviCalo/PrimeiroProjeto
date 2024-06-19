package com.example.primeiroprojeto

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelPP : ViewModel() {

    private val _LogEmail = mutableStateOf("")
    private val _LogPsssword = mutableStateOf("")

    val LogEmail: MutableState<String> = _LogEmail
    val LogPassword: MutableState<String> = _LogPsssword

    fun changeEmail(email: String){
        LogEmail.value = email
    }
    fun changePassword(password: String){
        LogPassword.value = password
    }



    private val  _Search = mutableStateOf("")

    val Search: MutableState<String> = _Search


    fun changeSearch(name: String){
        Search.value = name
    }
}