package com.example.Aditya_3tia.More

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Aditya_3tia.LoginActivity
import com.example.Aditya_3tia.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "aditya.cahyo") ?: "aditya.cahyo"

        if (username != "aditya.cahyo") {
            binding.tvCitizenName.text = username
        }

        // Notification Switch Interaction (Exact behavior from Stitch)
        binding.switchNotif.setOnCheckedChangeListener { _, isChecked ->
            val state = if (isChecked) "diaktifkan" else "dinonaktifkan"
            Toast.makeText(requireContext(), "Notifikasi $state", Toast.LENGTH_SHORT).show()
        }

        // Menu Items Click Listeners
        binding.btnMenuEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Profil warga terverifikasi Dukcapil.", Toast.LENGTH_SHORT).show()
        }

        binding.btnMenuSaved.setOnClickListener {
            Toast.makeText(requireContext(), "4 Fasilitas telah tersimpan di daftar favorit Anda.", Toast.LENGTH_SHORT).show()
        }

        binding.btnMenuHistory.setOnClickListener {
            Toast.makeText(requireContext(), "Menampilkan riwayat kunjungan fasilitas kota.", Toast.LENGTH_SHORT).show()
        }

        binding.btnMenuLanguage.setOnClickListener {
            Toast.makeText(requireContext(), "Bahasa antarmuka saat ini: Bahasa Indonesia.", Toast.LENGTH_SHORT).show()
        }

        binding.btnMenuHelp.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Pusat Bantuan & Pengaduan")
                .setMessage("Hubungi Call Center Smart City 112 atau kirim pesan pengaduan fasilitas melalui menu Pengaduan.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        binding.btnMenuAbout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Smart Public Facility")
                .setMessage("Versi 2.4.0\nPortal Sistem Informasi Fasilitas Umum Terpadu Kota Cerdas berbasis Material 3.\nDikembangkan oleh Tim Mahasiswa TI.")
                .setPositiveButton("Tutup") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        binding.btnNotificationMore.setOnClickListener {
            Toast.makeText(requireContext(), "Tidak ada notifikasi baru.", Toast.LENGTH_SHORT).show()
        }

        // Logout Action
        binding.btnLogoutMore.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout Akun")
                .setMessage("Apakah Anda yakin ingin keluar dari akun Smart Public Facility?")
                .setPositiveButton("Ya, Keluar") { dialog, _ ->
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

        // Preserved coursework adapter for compatibility
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listViewItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}