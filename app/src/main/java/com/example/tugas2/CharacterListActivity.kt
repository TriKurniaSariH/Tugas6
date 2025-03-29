package com.example.tugas2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharacterListActivity : AppCompatActivity() {

    private lateinit var characterRecyclerView: RecyclerView
    private lateinit var characterAdapter: MyAdapter
    private lateinit var listCharacter: ArrayList<ItemCharacter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

        characterRecyclerView = findViewById(R.id.characterRV)
        listCharacter = ArrayList()

        listCharacter.add(ItemCharacter(R.drawable.luffy, "Monkey D. Luffy", "Kapten Mugiwara Pirates", "1.111.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.zoro, "Roronoa Zoro", "Wakil Kapten", "3.000.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.sanji, "Vinsmoke Sanji", "Koki", "1.032.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.nami, "Nami", "Navigator", "366.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.usopp, "God Usopp", "Penembak Jitu", "500.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.robin, "Nico Robin", "Arkeolog", "930.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.franky, "Franky", "Tukang Kapal", "394.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.brook, "The SK Brook", "Musisi", "383.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.jinbe, "Jinbei", "Sang Petarung", "1.100.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.shanks, "Shanks", "Kapten Red Hair Pirates", "4.048.900.000"))
        listCharacter.add(ItemCharacter(R.drawable.mihawk, "Dracule Mihawk", "Pendekar Pedang Terkuat", "3.590.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.boa, "Boa Hancock", "Kapten Kuja Pirates", "1.659.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.law, "Trafalgar D. Water Law", "Kapten Heart Pirates", "3.000.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.dragon, "Monkey D. Dragon", "Pemimpin Pasukan Revolusi", "???,???,???"))
        listCharacter.add(ItemCharacter(R.drawable.sabo, "Sabo", "Kepala Staf Revolusi", "602.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.mingo, "Donquixote Doflamingo", "Mantan Raja Dressrosa ", " 340.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.marco, "Marco the Phoenix", "Mantan Komandan Divisi 1 Whitebeard Pirates", " 1.374.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.ace, "Portgas D. Ace", "Mantan Komandan Divisi 2 Whitebeard Pirates", "550.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.kuma, "Bartholomew Kuma", "Mantan Shichibukai, Pacifista", " 296.000.000"))
        listCharacter.add(ItemCharacter(R.drawable.coco, "Sir Crocodile", "Pemimpin Cross Guild", "1.965.000.000"))

        characterRecyclerView.layoutManager = LinearLayoutManager(this)
        characterRecyclerView.setHasFixedSize(true)
        characterAdapter = MyAdapter(listCharacter)
        characterRecyclerView.adapter = characterAdapter
    }
}
