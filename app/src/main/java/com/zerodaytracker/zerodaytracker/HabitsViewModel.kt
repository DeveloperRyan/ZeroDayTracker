package com.zerodaytracker.zerodaytracker

import androidx.lifecycle.ViewModel

class HabitsViewModel : ViewModel() {
    var habits: ArrayList<Habit> = Habit.createHabitList(10)
}