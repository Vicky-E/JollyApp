package com.vicks.jollyapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class JollyView(application: Application):AndroidViewModel(application){
    var JData = JollyData()
    fun validate() : Boolean {
        val characters: String= "~!@#\$%^&*()_-+=<>,.?/{}[]|"
        if (!JData.email.value.contains("@") || JData.email.value.length < 10) {
            JData.error.value = "Error Invalid email format"
            return false
        }
        if (!JData.email.value.contains(".")) {
            JData.error.value = "Error Invalid email format"
            return false
        }
        else if(JData.password.value.length < 6) {
            JData.error.value = "Password must be at least 6 characters"
            return false
        }
        else if(!JData.password.value.any {it in characters}) {
            JData.error.value = "Password must contain a special character"
            return false
        }
        else if(!JData.password.value.any {it.isUpperCase()}) {
            JData.error.value = "Password must contain an uppercase character"
            return false
        }
        else if(!JData.password.value.any {it.isLowerCase()}) {
            JData.error.value = "Password must contain a lowercase character"
            return false
        }
        else if(JData.password.value != JData.cpassword.value) {
            JData.error.value = "Passwords must match on both fields"
            return false
        }
        else if (!JData.tick.value) {
            JData.error.value = "Terms and condition must be accepted"
            return false
        }
        else {
            JData.error.value = ""
            return true
        }

    }

}
