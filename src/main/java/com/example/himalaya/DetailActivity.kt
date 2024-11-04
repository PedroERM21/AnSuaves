package com.example.himalaya

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView = findViewById<ImageView>(R.id.imageViewFull)
        val imageRes = intent.getIntExtra("imageRes", 0)
        imageView.setImageResource(imageRes)

        imageView.transitionName = "sharedImageView"


    }
}