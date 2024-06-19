package com.example.primeiroprojeto

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelPP : ViewModel() {

    private val _LogEmail = mutableStateOf("")
    private val _LogPsssword = mutableStateOf("")

    val logEmail: MutableState<String> = _LogEmail
    val logPassword: MutableState<String> = _LogPsssword

    fun changeEmail(email: String){
        logEmail.value = email
    }
    fun changePassword(password: String){
        logPassword.value = password
    }



    private val  _Search = mutableStateOf("")
    val search: MutableState<String> = _Search


    fun changeSearch(name: String){
        search.value = name
    }
}