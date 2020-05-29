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
                val streak = itemView.dayCounter.text.toString().toInt()
                itemView.dayCounter.text = streak.dec().toString()
            }

            override fun onIncrease(position: Int) {
                val streak = itemView.dayCounter.text.toString().toInt()
                itemView.dayCounter.text = streak.inc().toString()
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


    class ViewHolder(itemView : View, listener : HabitClickListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val habitTitle: TextView = itemView.habitTitle
        val streak: TextView = itemView.dayCounter
        val decreaseCounterButton : Button = itemView.decreaseCounterButton
        val increaseCounterButton : Button = itemView.increaseCounterButton
        val listener = listener

        init {
            decreaseCounterButton.setOnClickListener(this)
            increaseCounterButton.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when (itemView.id) {
                itemView.decreaseCounterButton.id -> listener.onDecrease(this.layoutPosition)
                itemView.increaseCounterButton.id -> listener.onIncrease(this.layoutPosition)
            }
        }
    }

    interface HabitClickListener {
        fun onDecrease(position : Int)
        fun onIncrease(position : Int)
        fun onEdit(position : Int)
    }
}