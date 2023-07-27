package com.example.tamrin2

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.tamrin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var lastPoemIndex = -1
    private val aboutAppText = "about app:\napp name: tamrin2\nversion 1.2.3\ncreated by: mohammad\nLicence: GNU (GPL)"
    private val poems = listOf<String>(
        "خلوت گزیده را به تماشا چه حاجت است\n\nچون کوی دوست هست به صحرا چه حاجت است",
        "تنت به ناز طبیبان نیازمند مباد\n\nوجود نازکت آزرده گزند مباد",
        "یا رب سببی ساز که یارم به سلامت\n\nباز آید و برهاندم از بند ملامت",
        "به دام زلف تو دل مبتلای خویشتن است\n\nبکش بغمزه که اینش سزای خویشتن است",
        "شراب و عیش نهان چیست کار بی بنیاد\n\nزدیم بر صف ندان و هر چه بادا باد",
     )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener{showRandomPoem()}
        binding.aboutButton.setOnClickListener{showAboutUs()}
    }

    private fun showRandomPoem() {
        var poemIndex = 0
        do {
            poemIndex = (0..poems.size - 1).random()
        } while (poemIndex == lastPoemIndex)
        binding.textView0.text = poems[poemIndex]
    }

    private fun showAboutUs(){
        binding.textView0.text = aboutAppText
    }





}