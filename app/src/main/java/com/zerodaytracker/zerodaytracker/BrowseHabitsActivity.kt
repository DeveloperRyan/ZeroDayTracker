package com.zerodaytracker.zerodaytracker

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BrowseHabitsActivity : Activity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addHabitButton: FloatingActionButton
    private val habits: ArrayList<Habit> = Habit.createHabitList(25)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse_habits)

        recyclerView = findViewById(R.id.rvHabits)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BrowseHabitsAdapter(habits)

        var cardCount = 0

        addHabitButton = findViewById(R.id.addHabitButton)
        addHabitButton.setOnClickListener {
                habits.add(Habit("New Habit", 1234, chooseCardColor(cardCount++)))
                (recyclerView.adapter as BrowseHabitsAdapter).notifyItemInserted(habits.size)
        }
    }


    private fun chooseCardColor(cardCount: Int): Int {
        val colors = resources.getIntArray(R.array.cardColors)
        return colors[cardCount % colors.size]
    }
}