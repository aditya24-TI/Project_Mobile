package com.example.Aditya_3tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.Aditya_3tia.DetailActivity
import com.example.Aditya_3tia.Home.pertemuan_5.LimaActivity
import com.example.Aditya_3tia.Home.pertemuan_6.EnamActivity
import com.example.Aditya_3tia.LoginActivity
import com.example.Aditya_3tia.R
import com.example.Aditya_3tia.databinding.FragmentHomeBinding
import com.google.android.material.button.MaterialButton

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val username = requireActivity().intent.getStringExtra("EXTRA_USERNAME")
            ?: sharedPref.getString("username", "aditya.cahyo") ?: "aditya.cahyo"
        val password = requireActivity().intent.getStringExtra("EXTRA_PASSWORD") ?: "••••••••"

        binding.tvResultUsername.text = username
        binding.tvResultPassword.text = if (password.isNotEmpty() && password != "Tidak ada") password else "••••••••"

        // Navigation to DetailActivity
        val openDetail = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }
        binding.btnDetail.setOnClickListener { openDetail() }
        binding.btnDetail2.setOnClickListener { openDetail() }
        binding.btnDetail3.setOnClickListener { openDetail() }
        binding.btnDetail4.setOnClickListener { openDetail() }

        // Interactive Map
        binding.btnOpenMap.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Fasilitas+Publik+Terdekat"))
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(mapIntent)
            } else {
                val webMapIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/?q=Fasilitas+Publik"))
                startActivity(webMapIntent)
            }
        }

        // Notification Button
        binding.btnNotification.setOnClickListener {
            Toast.makeText(requireContext(), "Semua layanan fasilitas kota berjalan normal hari ini.", Toast.LENGTH_SHORT).show()
        }

        // Coursework Navigation (Preserved)
        binding.btnToLima.setOnClickListener {
            startActivity(Intent(requireContext(), LimaActivity::class.java))
        }
        binding.btnToEnam.setOnClickListener {
            startActivity(Intent(requireContext(), EnamActivity::class.java))
        }

        // Logout Confirmation Dialog (Preserved)
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // Category Filter Chips Logic
        setupCategoryFilters()

        // Real-time Search Logic
        setupSearch()
    }

    private fun setupCategoryFilters() {
        val primaryColor = ContextCompat.getColor(requireContext(), R.color.civic_primary)
        val inactiveBgColor = ContextCompat.getColor(requireContext(), R.color.civic_surface_container_high)
        val textColorActive = ContextCompat.getColor(requireContext(), R.color.white)
        val textColorInactive = ContextCompat.getColor(requireContext(), R.color.civic_on_surface_variant)

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
            binding.cardFacility3.visibility = if (selectedCategory == "all" || selectedCategory == "hospital") View.VISIBLE else View.GONE
            binding.cardFacility4.visibility = if (selectedCategory == "all" || selectedCategory == "library") View.VISIBLE else View.GONE
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
                binding.cardFacility3.visibility = View.VISIBLE
                binding.cardFacility4.visibility = View.VISIBLE
            } else {
                binding.cardFacility1.visibility = if ("taman kota bungkul rekreasi".contains(query)) View.VISIBLE else View.GONE
                binding.cardFacility2.visibility = if ("rsud kota madya rumah sakit igd kesehatan".contains(query)) View.VISIBLE else View.GONE
                binding.cardFacility3.visibility = if ("puskesmas harapan jaya kesehatan bpjs".contains(query)) View.VISIBLE else View.GONE
                binding.cardFacility4.visibility = if ("perpustakaan umum daerah buku literasi".contains(query)) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
