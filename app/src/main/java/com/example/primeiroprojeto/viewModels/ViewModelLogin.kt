package com.example.primeiroprojeto.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelLogin: ViewModel() {

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
}