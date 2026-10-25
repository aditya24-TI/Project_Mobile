package com.example.Aditya_3tia

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvStatus = findViewById<TextView?>(R.id.tvLoadingStatus)

        lifecycleScope.launch {
            tvStatus?.text = "Menghubungkan ke Pusat Layanan Kota..."
            delay(700)
            tvStatus?.text = "Sinkronisasi Peta & Sensor Fasilitas..."
            delay(700)
            tvStatus?.text = "Memverifikasi Akses Publik..."
            delay(600)
            tvStatus?.text = "Siap Digunakan"
            delay(400)

            val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}