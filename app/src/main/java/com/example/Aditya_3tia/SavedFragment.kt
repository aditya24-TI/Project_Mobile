package com.example.Aditya_3tia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Aditya_3tia.databinding.FragmentSavedBinding

class SavedFragment : Fragment() {
    private var _binding: FragmentSavedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbarSaved)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        val openDetail = {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }

        binding.btnDetailSaved1.setOnClickListener { openDetail() }
        binding.btnDetailSaved2.setOnClickListener { openDetail() }

        binding.btnNotificationSaved.setOnClickListener {
            Toast.makeText(requireContext(), "Semua fasilitas tersimpan beroperasi normal.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
