package com.example.tugas2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val namaList: ArrayList<ItemAnime>
) : RecyclerView.Adapter<MyAdapter.AnimeViewHolder>() {

    private val favoriteSet = mutableSetOf<String>()

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageResId: ImageView = itemView.findViewById(R.id.imageAnime)
        val judul: TextView = itemView.findViewById(R.id.idJudulAnime)
        val nama: TextView = itemView.findViewById(R.id.idAuthorAnime)
        val genre: TextView = itemView.findViewById(R.id.idGenreAnime)
        val btnFavorite: ImageButton = itemView.findViewById(R.id.btnFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = namaList[position]
        val context = holder.itemView.context

        holder.imageResId.setImageResource(anime.imageResId)
        holder.judul.text = anime.judul
        holder.nama.text = "Author: ${anime.nama}"
        holder.genre.text = "Genre: ${anime.genre}"

        val animation = AnimationUtils.loadAnimation(context, R.anim.item_animation_fade)
        holder.itemView.startAnimation(animation)

        val isFavorite = favoriteSet.contains(anime.judul)
        holder.btnFavorite.setImageResource(
            if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
        )

        holder.itemView.setOnClickListener {
            val intent = Intent(context, AnimeDetailActivity::class.java)
            intent.putExtra("anime", anime)
            context.startActivity(intent)
        }

        holder.btnFavorite.setOnClickListener {
            val isNowFavorite = favoriteSet.contains(anime.judul)

            if (isNowFavorite) {
                favoriteSet.remove(anime.judul)
                ListAnimeActivity.favoriteAnimeList.removeAll { it.judul == anime.judul }
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_border)
            } else {
                favoriteSet.add(anime.judul)
                ListAnimeActivity.favoriteAnimeList.add(anime)
                holder.btnFavorite.setImageResource(R.drawable.ic_favorite_filled)
            }
        }
    }

    override fun getItemCount(): Int = namaList.size

    fun getFavoriteList(): List<ItemAnime> {
        return namaList.filter { favoriteSet.contains(it.judul) }
    }
}