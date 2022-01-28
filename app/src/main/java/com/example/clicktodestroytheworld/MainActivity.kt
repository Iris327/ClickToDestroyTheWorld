package com.example.clicktodestroytheworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    var score = 0 //keeps track of player score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variable declarations
        val incrementBtn = findViewById<Button>(R.id.incrementButton)
        val scoreText = findViewById<TextView>(R.id.playerScore)

        //increments the player score after increment score button is clicked
        incrementBtn?.setOnClickListener() {
            score++
            scoreText.text = score.toString()
        }
    }
}