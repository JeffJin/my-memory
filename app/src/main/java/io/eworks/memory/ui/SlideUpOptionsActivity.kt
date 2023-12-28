package io.eworks.memory.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.eworks.memory.R
import io.eworks.memory.databinding.ActivitySlideUpOptionsBinding

class SlideUpOptionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySlideUpOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlideUpOptionsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_slide_up_options)

        populateIntentExtras()
    }

    private fun populateIntentExtras() {
        val value1 = intent.getStringExtra("key1")
        val value2 = intent.getStringExtra("key2")

        val textView: TextView = findViewById(R.id.text_slide_up);
        textView.text = "$value1 ------ $value2"
    }
}