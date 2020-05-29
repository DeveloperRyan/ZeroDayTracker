package com.zerodaytracker.zerodaytracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.habit_card.view.*

class BrowseHabitsAdapter(private val habits: ArrayList<Habit>) :
    RecyclerView.Adapter<BrowseHabitsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.habit_card, parent, false)

        return ViewHolder(itemView, object: HabitClickListener {
            override fun onDecrease(position: Int) {
                habits[position].streak = habits[position].streak.dec()
                itemView.dayCounter.text = habits[position].streak.toString()
            }

            override fun onIncrease(position: Int) {
                habits[position].streak = habits[position].streak.inc()
                itemView.dayCounter.text = habits[position].streak.toString()
            }

            override fun onEdit(position: Int) {
                TODO("Change Activity to Edit")
            }
        })


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = habits[position]

        holder.habitTitle.text = currentItem.title
        holder.streak.text = currentItem.streak.toString()
    }

    override fun getItemCount() = habits.size


    class ViewHolder(itemView : View, private val listener: HabitClickListener) : RecyclerView.ViewHolder(itemView) {
        val habitTitle: TextView = itemView.habitTitle
        val streak: TextView = itemView.dayCounter
        private val decreaseCounterButton : Button = itemView.decreaseCounterButton
        private val increaseCounterButton : Button = itemView.increaseCounterButton

        init {
            decreaseCounterButton.setOnClickListener {
                listener.onDecrease(this.layoutPosition)
            }
            increaseCounterButton.setOnClickListener {
                listener.onIncrease(this.layoutPosition)
            }
        }

    interface HabitClickListener {
        fun onDecrease(position : Int)
        fun onIncrease(position : Int)
        fun onEdit(position : Int)
    }
}