package com.vicks.jollyapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class JollyData(
    var email:MutableState<String> = mutableStateOf(""),
    var password : MutableState<String> = mutableStateOf("")

)
