package com.vicks.jollyapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class JollyData(
    var email:MutableState<String> = mutableStateOf(""),
    var password : MutableState<String> = mutableStateOf(""),
    var error : MutableState<String> = mutableStateOf(""),
    var tick: MutableState<Boolean> = mutableStateOf(false),
    var cpassword:MutableState<String> = mutableStateOf(""),
    var invisible: MutableState<Boolean> = mutableStateOf(false)


)
