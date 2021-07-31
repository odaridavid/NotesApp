package com.github.odaridavid.notesapp

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class ImageActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        imageView = findViewById(R.id.image)

        loadPicasso()
//        loadCoil()
//        loadGlide()


    }

    private fun loadPicasso() {
        Picasso.get().load("http://www.mandysam.com/img/random.jpg").into(imageView)
    }

    private fun loadGlide() {
        Glide.with(this)
            .load("http://www.mandysam.com/img/random.jpg")
            .placeholder(R.drawable.download)
            .into(imageView)
    }

    private fun loadCoil() {
        imageView.load("http://www.mandysam.com/img/random.jpg") //coil
    }
}