package com.example.ndichujoseph.repostory

import com.google.firebase.auth.FirebaseAuth

class AuthRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun register(email: String, password: String, onResult: (Boolean) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                onResult(task.isSuccessful)
            }
    }
}