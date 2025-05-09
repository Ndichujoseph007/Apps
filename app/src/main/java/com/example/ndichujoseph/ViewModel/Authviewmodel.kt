package com.example.ndichujoseph.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ndichujoseph.repostory.AuthRepository

class AuthViewModel : ViewModel() {
    private val repository: AuthRepository = AuthRepository()

    var isRegistered by mutableStateOf<Boolean?>(null)
        private set
    var isLoggedIn by mutableStateOf<Boolean?>(null)
        private set

    fun register(email: String, password: String) {
        repository.register(email, password) { success ->
            isRegistered = success
        }
    }

    fun login(email: String, password: String) {
        repository.login(email, password) { success ->
            isLoggedIn = success
        }
    }
    fun logout(){
        repository.logout()
        isLoggedIn=false
    }
}