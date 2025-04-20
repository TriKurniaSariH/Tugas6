package com.example.tugas2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etBirthday: EditText
    private lateinit var etPhone: EditText
    private lateinit var etInstagram: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvName: TextView
    private lateinit var btnEdit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        // Inisialisasi view
        etName = findViewById(R.id.etName)
        etBirthday = findViewById(R.id.etBirthday)
        etPhone = findViewById(R.id.etPhone)
        etInstagram = findViewById(R.id.etInstagram)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvName = findViewById(R.id.tvName)
        btnEdit = findViewById(R.id.btnSave)

        btnEdit.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        // BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.nav_profile

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.nav_list -> {
                    startActivity(Intent(this, ListAnimeActivity::class.java))
                    true
                }
                R.id.nav_profile -> true
                else -> false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadProfile()
    }

    private fun loadProfile() {
        val sharedPref = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        etName.setText(sharedPref.getString("name", ""))
        etBirthday.setText(sharedPref.getString("birthday", ""))
        etPhone.setText(sharedPref.getString("phone", ""))
        etInstagram.setText(sharedPref.getString("instagram", ""))
        etEmail.setText(sharedPref.getString("email", ""))
        etPassword.setText(sharedPref.getString("password", ""))
        tvName.text = sharedPref.getString("name", "Anna Avetisyan")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


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
