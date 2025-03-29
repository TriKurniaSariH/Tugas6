package com.example.tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter(private val namaList: ArrayList<ItemCharacter>) : RecyclerView.Adapter<MyAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageResId: ImageView = itemView.findViewById(R.id.imageCharacter)
        val nama : TextView = itemView.findViewById(R.id.idNamaKarakter)
        val position: TextView = itemView.findViewById(R.id.idJabatanKarakter)
        val bounty: TextView = itemView.findViewById(R.id.idBountyKarakter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemCharacter = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_character,parent, false )
        return CharacterViewHolder(itemCharacter)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.imageResId.setImageResource(currentItem.imageResId)
        holder.nama.text = currentItem.nama
        holder.position.text = currentItem.position
        holder.bounty.text = currentItem.bounty
    }

}
