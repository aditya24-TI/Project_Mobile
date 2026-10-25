package com.example.Aditya_3tia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Aditya_3tia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var isBookmarked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Back action (Preserved exactly as existing)
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Bookmark Toggle Action
        binding.btnBookmark.setOnClickListener {
            isBookmarked = !isBookmarked
            if (isBookmarked) {
                binding.ivBookmark.setImageResource(R.drawable.ic_bookmark)
                binding.ivBookmark.setColorFilter(ContextCompat.getColor(this, R.color.civic_primary_container))
                binding.tvBookmarkLabel.text = "Tersimpan"
                Toast.makeText(this, "Fasilitas disimpan ke favorit Anda.", Toast.LENGTH_SHORT).show()
            } else {
                binding.ivBookmark.setImageResource(R.drawable.ic_bookmark_border)
                binding.ivBookmark.setColorFilter(ContextCompat.getColor(this, R.color.civic_on_surface_variant))
                binding.tvBookmarkLabel.text = "Simpan"
                Toast.makeText(this, "Fasilitas dihapus dari favorit.", Toast.LENGTH_SHORT).show()
            }
        }

        // Share Action
        val shareAction = {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Taman Kota Bungkul - Smart Public Facility")
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Temukan Taman Kota Bungkul: Ruang terbuka hijau publik cerdas dengan Wi-Fi gratis, jalur jogging, dan arena ramah disabilitas di Smart Public Facility App!"
                )
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan Informasi Fasilitas"))
        }
        binding.btnShareDetail.setOnClickListener { shareAction() }
        binding.btnShareHeader.setOnClickListener { shareAction() }

        // Navigation Action to Maps
        val openMap = {
            val mapUri = Uri.parse("geo:0,0?q=Taman+Bungkul+Surabaya")
            val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/?q=Taman+Bungkul+Surabaya"))
                startActivity(webIntent)
            }
        }
        binding.btnNavigate.setOnClickListener { openMap() }
        binding.btnDirections.setOnClickListener { openMap() }
        binding.btnMapPreview.setOnClickListener { openMap() }

        // Quick Call Contact
        binding.btnQuickCall.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"))
            startActivity(callIntent)
        }
    }
}