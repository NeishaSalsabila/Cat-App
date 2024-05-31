package com.neisha.catapps

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageViewLogo: ImageView = findViewById(R.id.imageViewLogo)

        Glide.with(this)
            .load(R.drawable.logo_splash)
            .into(imageViewLogo)

        val scaleX = ObjectAnimator.ofFloat(imageViewLogo, "scaleX", 0.5f, 1f)
        val scaleY = ObjectAnimator.ofFloat(imageViewLogo, "scaleY", 0.5f, 1f)

        scaleX.duration = 1000
        scaleY.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY)
        animatorSet.start()

        Handler().postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()
        }, SPLASH_TIME_OUT)
    }
}