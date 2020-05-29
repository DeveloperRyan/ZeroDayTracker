package com.zerodaytracker.zerodaytracker

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BrowseHabitsActivity : Activity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse_habits)

        recyclerView = findViewById(R.id.rvHabits)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BrowseHabitsAdapter(Habit.createHabitList(25))
    }
}