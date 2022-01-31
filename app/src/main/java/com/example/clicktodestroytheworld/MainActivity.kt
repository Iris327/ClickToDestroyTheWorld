package com.example.clicktodestroytheworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.File

class MainActivity : AppCompatActivity() {
    var score = 0 //keeps track of player score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variable declarations
        val incrementBtn = findViewById<Button>(R.id.incrementButton)
        val scoreText = findViewById<TextView>(R.id.playerScore)
        val upgradeBtn = findViewById<Button>(R.id.upgradeButton)
        var storyText = findViewById<TextView>(R.id.storyText)

        //set story text margins
        /*val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins( 10, 10, 10, 10)
        storyText.layoutParams = params
        */
        //disable upgradeBtn until score reaches certain value
        upgradeBtn.isEnabled = false

        //increments the player score after increment score button is clicked
        incrementBtn?.setOnClickListener() {
            score++
            scoreText.text = score.toString()
            storyText.text = File("storyFile.txt").readText()
        }
    }
}