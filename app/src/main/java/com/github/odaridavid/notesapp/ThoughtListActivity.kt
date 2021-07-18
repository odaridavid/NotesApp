package com.github.odaridavid.notesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ThoughtListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val noNotesTextView = findViewById<TextView>(R.id.noNotesTextView)
        val thoughtsRecyclerView = findViewById<RecyclerView>(R.id.thoughtsRecyclerView)
        displayThoughts(noNotesTextView = noNotesTextView, thoughtsRecyclerView)

        val addNoteFab = findViewById<FloatingActionButton>(R.id.addNoteFloatingButton)
        addNoteFab.setOnClickListener {
            openAddNoteActivity()
        }
    }

    private fun displayThoughts(noNotesTextView: TextView, thoughtsRecyclerView: RecyclerView) {
        if (ThoughtsDataSource.provideThoughts().isNotEmpty()) {
            thoughtsRecyclerView.adapter = ThoughtsRecyclerAdapter(thoughts = ThoughtsDataSource.provideThoughts())
            noNotesTextView.visibility = View.GONE
        }
    }

    private fun openAddNoteActivity() {
        val intent = Intent(this, AddThoughtActivity::class.java)
        startActivity(intent)
    }
}
