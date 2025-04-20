package com.example.tugas2

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    private lateinit var etEditName: EditText
    private lateinit var etEditBirthday: EditText
    private lateinit var etEditPhone: EditText
    private lateinit var etEditInstagram: EditText
    private lateinit var etEditEmail: EditText
    private lateinit var etEditPassword: EditText
    private lateinit var btnSaveChanges: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        etEditName = findViewById(R.id.etEditName)
        etEditBirthday = findViewById(R.id.etEditBirthday)
        etEditPhone = findViewById(R.id.etEditPhone)
        etEditInstagram = findViewById(R.id.etEditInstagram)
        etEditEmail = findViewById(R.id.etEditEmail)
        etEditPassword = findViewById(R.id.etEditPassword)
        btnSaveChanges = findViewById(R.id.btnSaveChanges)
        btnBack = findViewById(R.id.btnBack)

        // Load data yang sudah disimpan
        val sharedPref = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        etEditName.setText(sharedPref.getString("name", ""))
        etEditBirthday.setText(sharedPref.getString("birthday", ""))
        etEditPhone.setText(sharedPref.getString("phone", ""))
        etEditInstagram.setText(sharedPref.getString("instagram", ""))
        etEditEmail.setText(sharedPref.getString("email", ""))
        etEditPassword.setText(sharedPref.getString("password", ""))

        btnSaveChanges.setOnClickListener {
            with(sharedPref.edit()) {
                putString("name", etEditName.text.toString())
                putString("birthday", etEditBirthday.text.toString())
                putString("phone", etEditPhone.text.toString())
                putString("instagram", etEditInstagram.text.toString())
                putString("email", etEditEmail.text.toString())
                putString("password", etEditPassword.text.toString())
                apply()
            }
            Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnBack.setOnClickListener {
            finish()
        }

    }
}
