package com.kotlinegitim.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.kotlinegitim.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var currentTime:Long = 0
        binding.btnStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()+currentTime
            binding.kronometre.start()
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))


        }
        binding.btnPause.setOnClickListener {
            currentTime = binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }
        binding.btnReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            currentTime = 0
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }

    }
}