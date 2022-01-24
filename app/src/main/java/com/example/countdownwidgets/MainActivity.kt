package com.example.countdownwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.example.countdownwidgets.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.chrono.MinguoChronology
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        remainingTime()
        countDown()
    }

    private fun remainingTime() {
        val remainingDays = 364 - (LocalDateTime.now().dayOfYear)
        if (remainingDays > 9) {
            binding.days.text = remainingDays.toString()
        } else {
            binding.days.text = "0" + remainingDays.toString()
        }

        val remainingHours = 23 - (LocalDateTime.now().hour)
        if (remainingHours > 9) {
            binding.hours.text = remainingHours.toString()
        } else {
            binding.hours.text = "0" + remainingHours.toString()
        }

        val remainingMin = 59 - (LocalDateTime.now().minute)
        if (remainingMin > 9) {
            binding.minutes.text = remainingMin.toString()
        } else {
            binding.minutes.text = "0" + remainingMin.toString()
        }
    }

    private fun countDown() {
        object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                if ((millisUntilFinished / 1000).toInt() > 9) {
                    binding.seconds.text = (millisUntilFinished / 1000).toString()
                } else {
                    binding.seconds.text = "0" + millisUntilFinished / 1000
                }
            }

            override fun onFinish() {
                remainingTime()
                countDown()
            }
        }.start()

    }
}