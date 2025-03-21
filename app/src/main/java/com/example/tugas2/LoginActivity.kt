package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol Login → Pindah ke halaman utama (HomeActivity)
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Tombol "Forgot Password?" → Pindah ke ForgotPasswordActivity
        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPwdActivity::class.java)
            startActivity(intent)
        }

        // Tombol "Register" → Pindah ke RegisterActivity
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
