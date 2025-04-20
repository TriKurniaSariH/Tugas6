package com.example.tugas2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AnimeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_detail)

        setupToolbar()
        showAnimeDetail()
    }

    private fun setupToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = ""
        }
    }

    private fun showAnimeDetail() {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Menangani klik menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.logout -> {
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
