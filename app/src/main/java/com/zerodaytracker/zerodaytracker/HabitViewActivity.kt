package com.zerodaytracker.zerodaytracker

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HabitViewActivity : AppCompatActivity() {
    private lateinit var habitTitle: TextView
    private lateinit var habitStreak: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_view)
        val intentTitle = intent.getStringExtra("HABIT_TITLE")
        val intentStreak = intent.getStringExtra("HABIT_STREAK")
        val intentColor = intent.getIntExtra("HABIT_COLOR", R.color.design_default_color_primary)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(intentColor))

        habitTitle = findViewById(R.id.habitTitle)
        habitTitle.text = intentTitle

        habitStreak = findViewById(R.id.habitStreak)
        habitStreak.text = intentStreak
    }
}
