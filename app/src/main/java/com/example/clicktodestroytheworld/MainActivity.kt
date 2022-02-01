package com.example.clicktodestroytheworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {
    var score = 0 //keeps track of player score
    var br: BufferedReader? = null //used to read from story file

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variable declarations
        val incrementBtn = findViewById<Button>(R.id.incrementButton)
        val scoreText = findViewById<TextView>(R.id.playerScore)
        val upgradeBtn = findViewById<Button>(R.id.upgradeButton)
        var storyText = findViewById<TextView>(R.id.storyText)

        //open story file
        try {
            br = application.assets.open("StoryFile.txt").bufferedReader()
        }
        catch (e: Exception){
            storyText.text = "failed to open file"
        }

        //disable upgradeBtn until score reaches certain value
        upgradeBtn.isEnabled = false

        //increments the player score after increment score button is clicked
        incrementBtn?.setOnClickListener() {
            score++
            scoreText.text = score.toString()
            try {
                storyText.text = br?.readLine()
            }
            catch (e: Exception) {
                storyText.text = "failed to read from line"
            }
            var debugStoryText = storyText.text
        }
    }
}