package com.zerodaytracker.zerodaytracker

import kotlin.random.Random

class Habit(val title: String, val streak: Int) {

    companion object {
        fun createHabitList(numItems: Int): ArrayList<Habit> {
            val habits = ArrayList<Habit>()
            for (i in 0..numItems) {
                habits.add(i,
                    Habit("com.zerodaytracker.zerodaytracker.Habit $i", Random.nextInt(0, 100))
                )
            }

            return habits
        }
    }
}