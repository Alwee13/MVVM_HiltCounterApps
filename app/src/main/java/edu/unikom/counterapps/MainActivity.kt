package edu.unikom.counterapps

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import edu.unikom.counterapps.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val counterViewModel: CounterViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupObservers()
        setupClickListeners()
    }
    
    private fun setupObservers() {
        counterViewModel.counter.observe(this) { count ->
            binding.tvCounter.text = count.toString()
        }
    }
    
    private fun setupClickListeners() {
        binding.btnTambah.setOnClickListener {
            counterViewModel.increment()
        }
        
        binding.btnKurang.setOnClickListener {
            counterViewModel.decrement()
        }
    }
}