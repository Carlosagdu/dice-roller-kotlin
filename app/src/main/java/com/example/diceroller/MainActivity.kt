package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to click on a button and
 * update the text view to a number
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * This method allows to get a random number according to the number of sides
     * and then update it to the text view in the activity
     */
    private fun rollDice() {
        //Creates a Dice instance with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Second Dice instance
        val secondDice = Dice(8)
        val secondDiceRoll = secondDice.roll()

        //Update the screen with the new random number
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        //Second update
        val secondTextView: TextView = findViewById(R.id.textView2)
        secondTextView.text = secondDiceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}