package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TugasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas)


        val txtTugas3 = findViewById<TextView>(R.id.txtTugas3)
        txtTugas3.setOnClickListener {
            val intent = Intent(this, ShareMessageActivity::class.java)
            startActivity(intent)
        }


        val txtTugas4 = findViewById<TextView>(R.id.txtTugas4)
        txtTugas4.setOnClickListener {
            val intent = Intent(this, ListAnimeActivity::class.java)
            startActivity(intent)
        }
    }
}
