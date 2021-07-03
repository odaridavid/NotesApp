package com.github.odaridavid.notesapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val enterYourThoughtsEditText = findViewById<EditText>(R.id.enterYourThoughtsEditText)
        val saveYourThoughtsButton = findViewById<Button>(R.id.saveYourThoughtsButton)
        val viewYourThoughtsTextView = findViewById<TextView>(R.id.viewYourThoughtsTextView)

        saveYourThoughtsButton.setOnClickListener {
           val yourThoughtsText = enterYourThoughtsEditText.text.toString()
            if (yourThoughtsText.isNotBlank()){
                viewYourThoughtsTextView.text = yourThoughtsText
                viewYourThoughtsTextView.visibility = View.VISIBLE
                enterYourThoughtsEditText.setText("")
            }
        }

        randomFunction { no ->

            no+no

        }
    }
}

fun randomFunction(block:(Int)->(Int)){

}
