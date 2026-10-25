package com.example.Aditya_3tia

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Aditya_3tia.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var isPasswordVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            val savedUsername = sharedPref.getString("username", "aditya.cahyo") ?: "aditya.cahyo"
            val intent = Intent(this, BaseActivity::class.java)
            intent.putExtra("EXTRA_USERNAME", savedUsername)
            intent.putExtra("EXTRA_PASSWORD", savedUsername)
            startActivity(intent)
            finish()
            return
        }

        // Toggle Password Visibility
        binding.btnTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                binding.edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.btnTogglePassword.setImageResource(R.drawable.ic_eye_off)
            } else {
                binding.edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.btnTogglePassword.setImageResource(R.drawable.ic_eye)
            }
            binding.edtPassword.setSelection(binding.edtPassword.text.length)
        }

        // Alternative IKD Login (Opsi Cepat Identitas Kependudukan Digital)
        binding.btnIkd.setOnClickListener {
            binding.edtUsername.setText("aditya.cahyo")
            binding.edtPassword.setText("aditya.cahyo")
            Toast.makeText(this, "Identitas Digital (IKD) Terdeteksi: aditya.cahyo", Toast.LENGTH_SHORT).show()
        }

        // Forgot password notice
        binding.tvForgotPassword.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Reset Password")
                .setMessage("Silakan hubungi loket Diskominfo atau Kelurahan terdekat untuk verifikasi data kependudukan Anda.")
                .setPositiveButton("Mengerti") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // Primary Login Logic (Preserved exactly as existing)
        binding.btnLogin.setOnClickListener {
            val inputedUsername = binding.edtUsername.text.toString().trim()
            val inputedPassword = binding.edtPassword.text.toString().trim()

            if (inputedUsername.isNotEmpty() && inputedUsername == inputedPassword) {
                val editor = sharedPref.edit()
                if (binding.checkBox.isChecked) {
                    editor.putBoolean("isLogin", true)
                }
                editor.putString("username", inputedUsername)
                editor.apply()

                val intent = Intent(this, BaseActivity::class.java)
                intent.putExtra("EXTRA_USERNAME", inputedUsername)
                intent.putExtra("EXTRA_PASSWORD", inputedPassword)
                startActivity(intent)
                finish()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username dan Password harus sama dan tidak boleh kosong.")
                    .setPositiveButton("Coba Lagi") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }
    }
}