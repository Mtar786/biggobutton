package edu.uw.ischool.mrahma3.bigbutton

import android.animation.ObjectAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var counter = 0
    var start = true
    var currentAnimation: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.pushButton);
        button.setOnClickListener {
            onClick(button)
        }
    }

    private fun onClick(button: Button) {
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.anim)
        if (start) {
            button.startAnimation(animation)
            currentAnimation = animation
        } else {
            currentAnimation?.cancel()
        }
        start = !start



        val randomBackgroundColor = Color.argb(255, (0..255).random(), (0..255).random(), (0..255).random())
        button.setBackgroundColor(randomBackgroundColor)
        val randomTextColor = Color.argb(255, (0..255).random(), (0..255).random(), (0..255).random())
        button.setTextColor(randomTextColor)
        if (counter == 0) {
            counter+= 1
            button.setText(R.string.first)
        } else {
            counter++
            button.text = getString(R.string.repeat, counter)
        }
    }
}