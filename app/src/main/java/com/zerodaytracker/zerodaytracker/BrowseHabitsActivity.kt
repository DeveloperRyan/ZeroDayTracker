package com.zerodaytracker.zerodaytracker

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BrowseHabitsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addHabitButton: FloatingActionButton
    private val viewModel: HabitsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse_habits)

        recyclerView = findViewById(R.id.rvHabits)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BrowseHabitsAdapter(viewModel.habits)

        var cardCount = 0

        addHabitButton = findViewById(R.id.addHabitButton)
        addHabitButton.setOnClickListener {
                viewModel.habits.add(Habit("New Habit", 0, chooseCardColor(cardCount++)))
                (recyclerView.adapter as BrowseHabitsAdapter).notifyItemInserted(viewModel.habits.size)
        }

    }


    private fun chooseCardColor(cardCount: Int): Int {
        val colors = resources.getIntArray(R.array.cardColors)
        return colors[cardCount % colors.size]
    }
}