package com.example.tugas2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnimeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_detail)

        val anime = intent.getParcelableExtra<ItemAnime>("anime")

        val imageView = findViewById<ImageView>(R.id.detailImage)
        val judulText = findViewById<TextView>(R.id.detailJudul)
        val authorText = findViewById<TextView>(R.id.detailAuthor)
        val genreText = findViewById<TextView>(R.id.detailGenre)
        val deskripsiText = findViewById<TextView>(R.id.detailDeskripsi)

        anime?.let {
            imageView.setImageResource(it.imageResId)
            judulText.text = it.judul
            authorText.text = "Author: ${it.nama}"
            genreText.text = "Genre: ${it.genre}"
            deskripsiText.text = it.deskripsi
        }
    }
}
