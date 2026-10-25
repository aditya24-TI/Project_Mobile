package com.example.Aditya_3tia

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.example.Aditya_3tia.Home.pertemuan_5.LimaActivity
import com.example.Aditya_3tia.Home.pertemuan_6.EnamActivity
import com.example.Aditya_3tia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val username = intent.getStringExtra("EXTRA_USERNAME")
            ?: sharedPref.getString("username", "aditya.cahyo") ?: "aditya.cahyo"
        val password = intent.getStringExtra("EXTRA_PASSWORD") ?: "••••••••"

        binding.tvResultUsername.text = username
        binding.tvResultPassword.text = if (password.isNotEmpty() && password != "Tidak ada") password else "••••••••"

        val openDetail = {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
        binding.btnDetail.setOnClickListener { openDetail() }
        binding.btnDetail2.setOnClickListener { openDetail() }

        binding.btnOpenMap.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Fasilitas+Publik+Terdekat"))
            startActivity(mapIntent)
        }

        binding.btnNotification.setOnClickListener {
            Toast.makeText(this, "Semua layanan fasilitas kota berjalan normal hari ini.", Toast.LENGTH_SHORT).show()
        }

        binding.btnToLima.setOnClickListener {
            startActivity(Intent(this, LimaActivity::class.java))
        }
        binding.btnToEnam.setOnClickListener {
            startActivity(Intent(this, EnamActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        setupCategoryFilters()
        setupSearch()
    }

    private fun setupCategoryFilters() {
        val primaryColor = ContextCompat.getColor(this, R.color.civic_primary)
        val inactiveBgColor = ContextCompat.getColor(this, R.color.civic_surface_container_high)
        val textColorActive = ContextCompat.getColor(this, R.color.white)
        val textColorInactive = ContextCompat.getColor(this, R.color.civic_on_surface_variant)

        val chips = listOf(
            binding.chipAll to "all",
            binding.chipPark to "park",
            binding.chipHospital to "hospital",
            binding.chipBus to "bus",
            binding.chipLibrary to "library"
        )

        fun updateChips(selectedCategory: String) {
            for ((chip, category) in chips) {
                val isSelected = category == selectedCategory
                chip.backgroundTintList = ColorStateList.valueOf(if (isSelected) primaryColor else inactiveBgColor)
                chip.setTextColor(if (isSelected) textColorActive else textColorInactive)
            }

            binding.cardFacility1.visibility = if (selectedCategory == "all" || selectedCategory == "park") View.VISIBLE else View.GONE
            binding.cardFacility2.visibility = if (selectedCategory == "all" || selectedCategory == "hospital") View.VISIBLE else View.GONE
        }

        binding.chipAll.setOnClickListener { updateChips("all") }
        binding.chipPark.setOnClickListener { updateChips("park") }
        binding.chipHospital.setOnClickListener { updateChips("hospital") }
        binding.chipBus.setOnClickListener { updateChips("bus") }
        binding.chipLibrary.setOnClickListener { updateChips("library") }
    }

    private fun setupSearch() {
        binding.etFacilitySearch.doAfterTextChanged { text ->
            val query = text?.toString()?.trim()?.lowercase().orEmpty()
            if (query.isEmpty()) {
                binding.cardFacility1.visibility = View.VISIBLE
                binding.cardFacility2.visibility = View.VISIBLE
            } else {
                binding.cardFacility1.visibility = if ("taman kota bungkul rekreasi".contains(query)) View.VISIBLE else View.GONE
                binding.cardFacility2.visibility = if ("rsud kota madya rumah sakit igd kesehatan".contains(query)) View.VISIBLE else View.GONE
            }
        }
    }
}
