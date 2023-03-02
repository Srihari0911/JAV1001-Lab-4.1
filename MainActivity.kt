/* This project was worked in group with Jobin Koodathinkal Jose (A00250653) and myself Sri Hari Sreenivasan (A00272180).
We both worked in developing the logic and designing the layouts. I worked on Textviews along with spinner. 
Jobin worked on Buttons and OnClickListeners. */

package com.example.scorekeepingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //Initializing values
        val team1Score = findViewById<TextView>(R.id.team1_score)
        val team2Score = findViewById<TextView>(R.id.team2_score)
        val increment1 = findViewById<Spinner>(R.id.score1_increment)
        val increment2 = findViewById<Spinner>(R.id.score2_increment)
        val team1Increase = findViewById<Button>(R.id.team1_increase)
        val team1Decrease = findViewById<Button>(R.id.team1_decrease)
        val team2Increase = findViewById<Button>(R.id.team2_increase)
        val team2Decrease = findViewById<Button>(R.id.team2_decrease)

        // Setting initial scores to 0
        team1Score.text = "0"
        team2Score.text = "0"


        // Set onClickListeners for team 1 buttons
        //Team1 - Increase
        team1Increase.setOnClickListener {
            val scoreIncrement = increment1.selectedItem.toString().toInt()
            val currentScore = team1Score.text.toString().toInt()
            val newScore = currentScore + scoreIncrement
            team1Score.text = newScore.toString()
        }
        //Team1 - Decrease
        team1Decrease.setOnClickListener {
            val scoreIncrement = increment1.selectedItem.toString().toInt()
            val currentScore = team1Score.text.toString().toInt()
            val newScore = currentScore - scoreIncrement
            if (newScore >= 0) {
                team1Score.text = newScore.toString()
            }
        }

        // Set onClickListeners for team 2 buttons
        //Team2 - Increase
        team2Increase.setOnClickListener {
            val scoreIncrement = increment2.selectedItem.toString().toInt()
            val currentScore = team2Score.text.toString().toInt()
            val newScore = currentScore + scoreIncrement
            team2Score.text = newScore.toString()
        }
        //Team2 - Decrease
        team2Decrease.setOnClickListener {
            val scoreIncrement = increment2.selectedItem.toString().toInt()
            val currentScore = team2Score.text.toString().toInt()
            val newScore = currentScore - scoreIncrement
            if (newScore >= 0) {
                team2Score.text = newScore.toString()
            }
        }
    }
}
