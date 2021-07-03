package com.github.odaridavid.notesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var yourThoughtsBody: String? = null
    private var yourThoughtsTitle: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val thoughtsTitleEditText = findViewById<EditText>(R.id.enterYourThoughtsEditText)
        val saveYourThoughtsButton = findViewById<Button>(R.id.saveYourThoughtsButton)
        val viewYourThoughtsTextView = findViewById<TextView>(R.id.viewYourThoughtsTextView)
        val thoughtsBodyEditText = findViewById<EditText>(R.id.thoughtsBody)

        saveYourThoughtsButton.setOnClickListener {
            yourThoughtsTitle = thoughtsTitleEditText.text.toString()
            yourThoughtsBody = thoughtsBodyEditText.text.toString()
            if (yourThoughtsTitle!!?.isNotBlank() && yourThoughtsBody!!.isNotBlank()) {
                viewYourThoughtsTextView.text = yourThoughtsTitle + "\n" + yourThoughtsBody
                viewYourThoughtsTextView.visibility = View.VISIBLE
                thoughtsBodyEditText.setText("")
                thoughtsTitleEditText.setText("")
            }
        }

        viewYourThoughtsTextView.setOnClickListener {

            if (yourThoughtsBody.isNullOrEmpty() || yourThoughtsTitle.isNullOrEmpty()) return@setOnClickListener

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", yourThoughtsTitle)
            intent.putExtra("body", yourThoughtsBody)
            startActivity(intent)
        }

    }
}

