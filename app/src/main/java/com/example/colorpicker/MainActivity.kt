package com.example.colorpicker

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.slider.Slider
import java.text.DecimalFormat




@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bg: LinearLayout = findViewById(R.id.bg)
        val headText:TextView = findViewById(R.id.headText)
        val redSlider:Slider = findViewById(R.id.redSlider)
        val greenSlider:Slider = findViewById(R.id.greenSlider)
        val blueSlider:Slider = findViewById(R.id.blueSlider)

        fun invertTextColor(bg: LinearLayout, textView: TextView) {
            val bgColor = bg.background

            if (bgColor is ColorDrawable) {
                // Get the color of the background
                val backgroundColor = bgColor.color
                val invertedColor = Color.rgb(
                    255 - Color.red(backgroundColor),
                    255 - Color.green(backgroundColor),
                    255 - Color.blue(backgroundColor)
                )
                textView.setTextColor(invertedColor)
            }

        }

        val hexArray = arrayOf(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
        )
        val redArray = arrayOf(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
        )
        val blueArray = arrayOf(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
        )
        val greenArray = arrayOf(
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
        )

        var red = hexArray.random()
        var green = hexArray.random()
        var blue = hexArray.random()

        headText.text = "#$red$green$blue"
        bg.setBackgroundColor(Color.parseColor("#$red$red$green$green$blue$blue"))


        redSlider.value = redArray.indexOf(red).toFloat()
        greenSlider.value = greenArray.indexOf(green).toFloat()
        blueSlider.value = blueArray.indexOf(blue).toFloat()


        headText.setOnClickListener {
            red = hexArray.random()
            green = hexArray.random()
            blue = hexArray.random()

            headText.text = "#$red$green$blue"
            bg.setBackgroundColor(Color.parseColor("#$red$red$green$green$blue$blue"))

            redSlider.value = red.toInt(16).toFloat()
            greenSlider.value = green.toInt(16).toFloat()
            blueSlider.value = blue.toInt(16).toFloat()
        }

        blueSlider.addOnChangeListener { blueslider, value, fromUser ->
            if (fromUser) {
                blue= hexArray[value.toInt()]

                headText.text = "#$red$green$blue"
                bg.setBackgroundColor(Color.parseColor("#$red$red$green$green$blue$blue"))

                invertTextColor(bg, headText)
            }
        }

        greenSlider.addOnChangeListener { greenslider, value, fromUser ->
            if (fromUser) {
                green = hexArray[value.toInt()]

                headText.text = "#$red$green$blue"
                bg.setBackgroundColor(Color.parseColor("#$red$red$green$green$blue$blue"))

                invertTextColor(bg, headText)
            }
        }

        redSlider.addOnChangeListener { redslider, value, fromUser ->
            if (fromUser) {
                red= hexArray[value.toInt()]

                headText.text = "#$red$green$blue"
                bg.setBackgroundColor(Color.parseColor("#$red$red$green$green$blue$blue"))

                invertTextColor(bg, headText)
            }
        }


    }
}