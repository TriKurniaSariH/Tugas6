package com.example.tugas2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val namaList: ArrayList<ItemAnime>) : RecyclerView.Adapter<MyAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageResId: ImageView = itemView.findViewById(R.id.imageAnime)
        val judul: TextView = itemView.findViewById(R.id.idJudulAnime)
        val nama: TextView = itemView.findViewById(R.id.idAuthorAnime)
        val genre: TextView = itemView.findViewById(R.id.idGenreAnime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = namaList[position]
        holder.imageResId.setImageResource(anime.imageResId)
        holder.judul.text = anime.judul
        holder.nama.text = "Author: ${anime.nama}"
        holder.genre.text = "Genre: ${anime.genre}"

        val context = holder.itemView.context
        holder.itemView.setOnClickListener {
            val intent = Intent(context, AnimeDetailActivity::class.java)
            intent.putExtra("anime", anime)
            context.startActivity(intent)
        }

        val animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_fade)
        holder.itemView.startAnimation(animation)
    }

    override fun getItemCount(): Int = namaList.size
}
