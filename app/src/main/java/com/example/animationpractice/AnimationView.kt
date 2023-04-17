package com.example.animationpractice

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AnimationView: ConstraintLayout, LifecycleObserver {

    private val waitTime = 100L
    private val scaleTime = 350L
    private val compressTime = 150L

    private val heartOuter by lazy { this.findViewById<ImageView>(R.id.heart_outer) }
    private val heartMiddle by lazy { this.findViewById<ImageView>(R.id.heart_middle) }

    private lateinit var lifecycleScope: LifecycleCoroutineScope

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int): super(context, attrs, defStyleAttr)

    private val animation = HeartAnimation()

    init {
        View.inflate(context, R.layout.heart_animation_layout, this)
    }

    fun registerLifecycleOwner(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
        lifecycleScope = lifecycle.coroutineScope
    }

    fun startAnimation() {
        startAnimationOuter(lifecycleScope)
        startAnimationMiddle()
    }

    private fun startAnimationOuter(lifecycleScope: LifecycleCoroutineScope) {
        var animationSet1: AnimationSet? = null
        var animationSet2: AnimationSet? = null
        var animationSet3: AnimationSet? = null

        animationSet1 = AnimationSet(true).apply {
            addAnimation(animation.outerAnimation1Scale)
            addAnimation(animation.outerAnimation1Alpha)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    lifecycleScope.launch {
                        delay(waitTime)
                        heartOuter.startAnimation(animationSet2)
                    }
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
            fillAfter = true
        }

        animationSet2 = AnimationSet(true).apply {
            addAnimation(animation.outerAnimation2Scale)
            addAnimation(animation.outerAnimation2Alpha)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    lifecycleScope.launch {
                        delay(waitTime)
                        heartOuter.startAnimation(animationSet3)
                    }
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
            fillAfter = true
        }

        animationSet3 = AnimationSet(true).apply {
            addAnimation(animation.outerAnimation3Alpha)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    lifecycleScope.launch {
                        delay(waitTime)
                        heartOuter.startAnimation(animationSet1)
                    }
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
            fillAfter = true
        }

        heartOuter.startAnimation(animationSet1)
    }

    private fun startAnimationMiddle() {
        var animationSet1: AnimationSet? = null
        var animationSet2: AnimationSet? = null
        var animationSet3: AnimationSet? = null

        animationSet1 = AnimationSet(true).apply {
            addAnimation(animation.middleAnimation1Scale)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    lifecycleScope.launch {
                        delay(waitTime)
                        heartMiddle.startAnimation(animationSet2)
                    }
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
            fillAfter = true
        }

        animationSet2 = AnimationSet(true).apply {
            addAnimation(animation.middleAnimation2Scale)
            addAnimation(animation.middleAnimation2Alpha)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    lifecycleScope.launch {
                        delay(waitTime)
                        heartMiddle.startAnimation(animationSet3)
                    }
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
            fillAfter = true
        }

        animationSet3 = AnimationSet(true).apply {
            addAnimation(animation.middleAnimation3Scale)
            addAnimation(animation.middleAnimation3Alpha)
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {}
                override fun onAnimationEnd(animation: Animation) {
                    lifecycleScope.launch {
                        delay(waitTime)
                        heartMiddle.startAnimation(animationSet1)
                    }
                }
                override fun onAnimationRepeat(animation: Animation) {}
            })
            fillAfter = true
        }
        heartMiddle.startAnimation(animationSet1)
    }
}