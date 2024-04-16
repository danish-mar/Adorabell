package com.electro.adorabell.ui.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.electro.adorabell.R
import com.electro.adorabell.databinding.ActivitySignupBinding
import com.electro.adorabell.ui.signup.fragments.*

class SignupActivity : AppCompatActivity() {

    // Fragment index to keep track of the current fragment
    private var currentFragmentIndex = 0
    private lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load the initial fragment
        loadFragment(getFragment(currentFragmentIndex))

        // Set click listener for the "Next" button
        binding.buttonNext.setOnClickListener {
            // Increment the fragment index
            currentFragmentIndex++
            // Load the next fragment
            loadFragment(getFragment(currentFragmentIndex))
        }
    }

    // Function to load a fragment into the fragment container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right) // Add this line
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
    // Function to get the appropriate fragment based on the index
    private fun getFragment(index: Int): Fragment {
        return when (index) {
            0 -> signup_name()
            1 -> signup_username()
            2 -> signup_email()
            3 -> signup_password()
            4 -> signup_profile_picture()
            5 -> signup_complete()
            else -> signup_username()
        }
    }
}
