package com.gamzecoskun.kronometre

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.core.content.ContextCompat
import com.gamzecoskun.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var timeStop: Long = 0

        with(binding) {
            btnStart.setOnClickListener {
                chronometer.base = SystemClock.elapsedRealtime() + timeStop
                chronometer.start()
                btnStart.visibility = View.GONE
                btnPause.visibility = View.VISIBLE
                imageView.setImageDrawable(getDrawable(R.drawable.pause))
            }

            btnPause.setOnClickListener {
                timeStop=chronometer.base -SystemClock.elapsedRealtime()
                chronometer.stop()
                btnStart.visibility = View.VISIBLE
                btnPause.visibility = View.GONE
                imageView.setImageDrawable(getDrawable(R.drawable.start))
            }

            btnReset.setOnClickListener {
                chronometer.base = SystemClock.elapsedRealtime() + timeStop
                chronometer.stop()
                timeStop=0
                btnStart.visibility = View.GONE
                btnPause.visibility = View.VISIBLE
                imageView.setImageDrawable(getDrawable(R.drawable.start))
            }
        }

    }
}


