package com.randomuser.presentation

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.randomuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel.liveUser.observe(this) {

            Glide.with(applicationContext)
                .load(Uri.parse(it.picture))
                .into(binding.imageAvatar)

            binding.etFirstName.setText(it.firstName)
            binding.etLastName.setText(it.lastName)
        }

        binding.buttonNewUser.setOnClickListener {
            viewModel.loadUser()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}