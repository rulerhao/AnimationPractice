package com.example.animationpractice

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

class HeartAnimation {
    private val waitTime = 100L
    private val scaleTime = 350L
    private val compressTime = 150L

    private val outerAnimation1Time = scaleTime
    val outerAnimation1Scale = ScaleAnimation(
        1f, 1.5f, 1f, 1.5f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f
    ).apply {
        duration = outerAnimation1Time
        fillAfter = true
    }
    val outerAnimation1Alpha = AlphaAnimation(
        1f, 0.15f
    ).apply {
        duration = outerAnimation1Time
        fillAfter = true
    }

    private val outerAnimation2Time = scaleTime
    val outerAnimation2Scale = ScaleAnimation(
        1.5f, 2f, 1.5f, 2f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f
    ).apply {
        duration = outerAnimation2Time
        fillAfter = true
    }
    val outerAnimation2Alpha = AlphaAnimation(
        0.15f, 0.05f
    ).apply {
        duration = outerAnimation2Time
        fillAfter = true
    }

    private val outerAnimation3Time = compressTime
    val outerAnimation3Alpha = AlphaAnimation(
        0.05f, 0.0f
    ).apply {
        duration = outerAnimation3Time
        fillAfter = true
    }

    private val middleAnimation1Time = scaleTime
    val middleAnimation1Scale = ScaleAnimation(
        1.0f, 1.0f, 1.0f, 1.0f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f
    ).apply {
        duration = middleAnimation1Time
        fillAfter = true
    }

    private val middleAnimation2Time = scaleTime
    val middleAnimation2Scale = ScaleAnimation(
        1.0f, 1.5f, 1.0f, 1.5f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f
    ).apply {
        duration = middleAnimation2Time
        fillAfter = true
    }
    val middleAnimation2Alpha = AlphaAnimation(
        1.0f, 0.15f
    ).apply {
        duration = middleAnimation2Time
        fillAfter = true
    }

    private val middleAnimation3Time = compressTime
    val middleAnimation3Scale = ScaleAnimation(
        1.5f, 1.0f, 1.5f, 1.0f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0.5f
    ).apply {
        duration = middleAnimation3Time
        fillAfter = true
    }
    val middleAnimation3Alpha = AlphaAnimation(
        0.15f, 0.0f
    ).apply {
        duration = middleAnimation3Time
        fillAfter = true
    }
}