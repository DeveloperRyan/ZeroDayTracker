package com.zerodaytracker.zerodaytracker

import kotlin.random.Random

class Habit(internal var title: String, internal var streak: Int, var cardColor: Int) {
    companion object {
        fun createHabitList(numItems: Int): ArrayList<Habit> {
            val habits = ArrayList<Habit>()
            for (i in 0..numItems) {
                habits.add(i,
                    Habit("Habit $i", Random.nextInt(0, 100), -1092784)
                )
            }
            return habits
        }
    }
}