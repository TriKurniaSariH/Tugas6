package com.example.tugas2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HorizontalAdapter(private val animeList: ArrayList<ItemAnime>) :
    RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageAnime: ImageView = itemView.findViewById(R.id.imageHorizontal)
        val judulAnime: TextView = itemView.findViewById(R.id.judulHorizontal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal_anime, parent, false)
        return HorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        val item = animeList[position]
        holder.imageAnime.setImageResource(item.imageResId)
        holder.judulAnime.text = item.judul

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, AnimeDetailActivity::class.java)
            intent.putExtra("anime", item)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = animeList.size
}
