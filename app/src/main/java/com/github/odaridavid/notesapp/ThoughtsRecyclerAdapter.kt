package com.github.odaridavid.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ThoughtsRecyclerAdapter(private val thoughts: List<String>) :
    RecyclerView.Adapter<ThoughtsRecyclerAdapter.ThoughtViewHolder>() {

    class ThoughtViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(thought: String) {
            val noteTitleTextView = view.findViewById<TextView>(R.id.noteTitleTextView)
            val noteContentTextView = view.findViewById<TextView>(R.id.noteContentTextView)
            noteContentTextView.text = thought
            noteTitleTextView.text = "Some Cool Title"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThoughtViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ThoughtViewHolder(
            view = inflater.inflate(R.layout.item_thought, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ThoughtViewHolder, position: Int) {
        holder.bind(thoughts[position])
    }

    override fun getItemCount(): Int = thoughts.size
}
