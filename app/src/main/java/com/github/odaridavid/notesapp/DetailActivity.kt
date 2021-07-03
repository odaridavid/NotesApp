package com.github.odaridavid.notesapp

import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import java.util.jar.Manifest

class DetailActivity : AppCompatActivity() {

    private var yourThoughtsBody: String? = null
    private var yourThoughtsTitle: String? = null

    lateinit var titleTextView: TextView
    lateinit var bodyTextView: TextView
    lateinit var sendEmail: ImageView
    lateinit var shareText: ImageView
    lateinit var takeImage: Button
    lateinit var imageView: ImageView
    lateinit var pickImage: Button

    //Camera permision
    val cameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->

            if (isGranted) {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                cameraLauncher.launch(intent)

            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show()
            }


        }

    //Storage permission
    val storagePermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->

            if (isGranted) {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"
                Intent.createChooser(intent, "Select Image")
                galleryLauncher.launch(intent)
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show()
            }


        }

    //Launch camera
    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {
                val bitmap = result.data?.extras?.get("data") as Bitmap
                imageView.setImageBitmap(bitmap)
            }
        }

    //Launch Gallery
    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {
                val uri = result.data?.data
                imageView.setImageURI(uri)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView = findViewById(R.id.title)
        bodyTextView = findViewById(R.id.thoughtsBody)
        sendEmail = findViewById(R.id.email)
        shareText = findViewById(R.id.share)
        takeImage = findViewById(R.id.takeImage)
        imageView = findViewById(R.id.imageView)
        pickImage = findViewById(R.id.pickImage)

        yourThoughtsBody = intent.getStringExtra("body")
        yourThoughtsTitle = intent.getStringExtra("title")

        titleTextView.text = yourThoughtsTitle
        bodyTextView.text = yourThoughtsBody

        takeImage.setOnClickListener {
            cameraPermission.launch(android.Manifest.permission.CAMERA)
        }

        pickImage.setOnClickListener {
            storagePermission.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        sendEmail.setOnClickListener {
            shareEmail()
        }
        shareText.setOnClickListener {
            shareText()
        }
    }

    private fun shareText() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, yourThoughtsBody)
        startActivity(Intent.createChooser(intent, "Share Via:"))
    }


    private fun shareEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ivy@gmail.com", "sandra@gmail.com"))
        intent.putExtra(Intent.EXTRA_SUBJECT, yourThoughtsTitle)
        intent.putExtra(Intent.EXTRA_TEXT, yourThoughtsBody)
        startActivity(Intent.createChooser(intent, "Choose an email client"))
    }
}