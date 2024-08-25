package com.example.imageview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imageview.databinding.ActivityMainBinding
import com.example.imageview.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var checkPic = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.toolbarSecond.title = "Альбом фотографий"

        setSupportActionBar(binding.toolbarSecond)

        binding.picIV.setImageDrawable(
            ContextCompat.getDrawable(this, Cats().cats[checkPic])
        )
        binding.nextPicBTN.setOnClickListener {
            if (checkPic < 4) {
                checkPic++
                binding.picIV.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        Cats().cats[checkPic]
                    )
                )
            } else {
                val intent = Intent(this, FinishActivity::class.java)
                startActivity(intent)
            }
        }
        binding.backPicBTN.setOnClickListener {
            if (checkPic == 0) {
                Toast.makeText(this, "Это первое фото", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else {
                checkPic--
                binding.picIV.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        Cats().cats[checkPic]
                    )
                )
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_second, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuSecond -> {
                finishAndRemoveTask()
                finishAffinity()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}