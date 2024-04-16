package com.electro.adorabell.ui.signup.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.electro.adorabell.R
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.core.models.Shape
import nl.dionsegijn.konfetti.core.models.Size
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.concurrent.TimeUnit

class signup_complete : Fragment() {

    private lateinit var konfettiView: KonfettiView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup_complete, container, false)

        konfettiView = view.findViewById(R.id.konfettiView)
        return view
    }

    override fun onResume() {
        super.onResume()
        startConfetti()
    }

    private fun startConfetti() {
        val party = Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xFFC0CB, 0xE6E6FA, 0xD8BFD8),
            emitter = Emitter(duration = 5, TimeUnit.SECONDS).max(100),
            shapes = listOf(Shape.Square, Shape.Circle),
            size = listOf(Size(12)), // Wrap Size(12) within a list
            position = Position.Relative(0.5, 0.3)
        )
        konfettiView.start(party)
    }
}
