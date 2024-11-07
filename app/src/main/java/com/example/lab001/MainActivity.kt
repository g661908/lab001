package com.example.lab001

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var imgView: ImageView? = null
    private var sw: Switch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgView = findViewById(R.id.imageView)
        sw = findViewById(R.id.spin_switch)

        // Null safety check on ImageView and Switch
        imgView?.let { imageView ->
            sw?.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Create a rotating animation
                    val rotate = RotateAnimation(
                        0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    rotate.duration = 5000 // Rotation duration in milliseconds
                    rotate.repeatCount = Animation.INFINITE // Make it repeat indefinitely
                    rotate.interpolator = LinearInterpolator() // Smooth constant speed

                    imageView.startAnimation(rotate) // Start the animation on image view
                } else {
                    imageView.clearAnimation() // Stop the rotation when switch is off
                }
            }
        }
    }
}
