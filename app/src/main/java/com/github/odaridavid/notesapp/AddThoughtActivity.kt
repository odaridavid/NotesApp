package com.github.odaridavid.notesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddThoughtActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val enterYourThoughtsEditText = findViewById<EditText>(R.id.enterYourThoughtsEditText)
        val saveYourThoughtsButton = findViewById<Button>(R.id.saveYourThoughtsButton)

        saveYourThoughtsButton.setOnClickListener {
            val yourThoughtsText = enterYourThoughtsEditText.text.toString()
            ThoughtsDataSource.addThought(thought = yourThoughtsText)
            if (yourThoughtsText.isNotBlank()) {
                enterYourThoughtsEditText.setText("")
            }
        }
    }
}

