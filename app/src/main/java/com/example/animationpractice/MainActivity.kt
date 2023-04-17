package com.example.animationpractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val heart: AnimationView by lazy { findViewById<AnimationView?>(R.id.heart).apply {
        registerLifecycleOwner(lifecycle)
    } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        heart.startAnimation()
    }

}