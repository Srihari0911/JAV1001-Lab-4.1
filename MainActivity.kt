/* This project was worked in group with Jobin Koodathinkal Jose (A00250653) and myself Sri Hari Sreenivasan (A00272180) */

// We chose Cricket as our game and we don't have negative values. Though we chose Cricket the max value for spinner is 6.

package com.example.scorekeepingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import com.example.scorekeepingapp.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        //Initializing values
        val team1Score = findViewById<TextView>(id.team1_score)
        val team2Score = findViewById<TextView>(id.team2_score)
        val increment1 = findViewById<Spinner>(id.score1_increment)
        val increment2 = findViewById<Spinner>(id.score2_increment)
        val teamIncrease = findViewById<Button>(id.team_increase)
        val teamDecrease = findViewById<Button>(id.team_decrease)
        val teamToggleButton = findViewById<Switch>(id.team_toggle_button)

        // Setting initial scores to 0
        team1Score.text = "0"
        team2Score.text = "0"
        var currentTeam = 1
        

        // Added code code for toggle listener
        val onCheckedChangeListener = teamToggleButton.setOnCheckedChangeListener { _, isChecked ->
            currentTeam = if (isChecked) 2 else 1
        }
        // OnclickListeners to increase the values
        teamIncrease.setOnClickListener {
            val scoreIncrement = increment1.selectedItem.toString().toInt()
            if (currentTeam == 1) {
                val currentScore = team1Score.text.toString().toInt()
                val newScore = currentScore + scoreIncrement
                team1Score.text = newScore.toString()
            } else {
                val scoreIncrement = increment2.selectedItem.toString().toInt()
                val currentScore = team2Score.text.toString().toInt()
                val newScore = currentScore + scoreIncrement
                team2Score.text = newScore.toString()
            }
        }
        // OnclickListeners to decrease the values
        teamDecrease.setOnClickListener {
            val scoreIncrement = increment1.selectedItem.toString().toInt()
            if (currentTeam == 1) {
                val scoreIncrement = increment1.selectedItem.toString().toInt()
                val currentScore = team1Score.text.toString().toInt()
                val newScore = currentScore - scoreIncrement
                if (newScore >= 0) {
                    team1Score.text = newScore.toString()
                }
            } else {
                val scoreIncrement = increment2.selectedItem.toString().toInt()
                val currentScore = team2Score.text.toString().toInt()
                val newScore = currentScore - scoreIncrement
                if (newScore >= 0) {
                    team2Score.text = newScore.toString()
                }
            }
        }
    }
}
