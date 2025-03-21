package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2.databinding.ActivityForgotPwdBinding

class ForgotPwdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPwdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol "Send" -> Kirim kode verifikasi
        binding.btnNext.setOnClickListener {
            Toast.makeText(this, "Kode verifikasi telah dikirim!", Toast.LENGTH_SHORT).show()

        }

        // Tombol "Remember your password? Log In" -> Pindah ke LoginActivity
        binding.txtRememberPassword.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
