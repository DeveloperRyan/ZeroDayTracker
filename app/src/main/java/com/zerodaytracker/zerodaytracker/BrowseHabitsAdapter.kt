package com.zerodaytracker.zerodaytracker

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.habit_card.view.*

class BrowseHabitsAdapter(private val habits: ArrayList<Habit>) :
    RecyclerView.Adapter<BrowseHabitsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.habit_card, parent, false)

        return ViewHolder(itemView, object: HabitClickListener {
            override fun onCardClick(position: Int) {
                val context = itemView.context
                val intent = Intent(context, HabitViewActivity::class.java)
                    .putExtra("HABIT_TITLE", habits[position].title)
                    .putExtra("HABIT_STREAK", habits[position].streak.toString())
                    .putExtra("HABIT_COLOR", habits[position].cardColor)
                context.startActivity(intent)
            }

            override fun onDecrease(position: Int) {
                if (habits[position].streak > 0) {
                    habits[position].streak = habits[position].streak.dec()
                    itemView.dayCounter.text = habits[position].streak.toString()
                }
            }

            override fun onIncrease(position: Int) {
                habits[position].streak = habits[position].streak.inc()
                itemView.dayCounter.text = habits[position].streak.toString()
            }

            override fun onEdit(position: Int) {
                habits[position].streak = habits[position].streak.dec()
                itemView.dayCounter.text = habits[position].streak.toString()
            }
        })


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = habits[position]

        holder.habitTitle.text = currentItem.title
        holder.streak.text = currentItem.streak.toString()
        holder.cardContainer.setBackgroundColor(habits[position].cardColor)
    }

    override fun getItemCount() = habits.size


    class ViewHolder(itemView : View, private val listener: HabitClickListener) : RecyclerView.ViewHolder(itemView) {
        val habitTitle: TextView = itemView.habitTitle
        val streak: TextView = itemView.dayCounter
        val cardContainer: LinearLayout = itemView.cardContainer

        private val decreaseCounterButton : Button = itemView.decreaseCounterButton
        private val increaseCounterButton : Button = itemView.increaseCounterButton
        val editCardButton : ImageView = itemView.editButton

        init {
            itemView.setOnClickListener {
                listener.onCardClick(this.layoutPosition)
            }
            decreaseCounterButton.setOnClickListener {
                listener.onDecrease(this.layoutPosition)
            }
            increaseCounterButton.setOnClickListener {
                listener.onIncrease(this.layoutPosition)
            }
            editCardButton.setOnClickListener {
                listener.onEdit(this.layoutPosition)
            }
        }

    }

    interface HabitClickListener {
        fun onCardClick(position : Int)
        fun onDecrease(position : Int)
        fun onIncrease(position : Int)
        fun onEdit(position : Int)
    }
}