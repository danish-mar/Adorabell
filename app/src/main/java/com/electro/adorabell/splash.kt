package com.electro.adorabell

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.electro.adorabell.ui.login.login
import com.google.firebase.auth.FirebaseAuth

class splash : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 3000 // 3 seconds
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        firebaseAuth = FirebaseAuth.getInstance()

        Handler().postDelayed({
            checkLoggedInStatus()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }

    private fun checkLoggedInStatus() {
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            // User logged in
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        } else {
            // User not logged in
            val loginIntent = Intent(this, login::class.java)
            startActivity(loginIntent)
        }
        finish()
    }
}
