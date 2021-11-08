package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        //Do a roll dice when the app starts
        rollDice()
    }

    /**
     * This method allows to get a random number according to the number of sides
     * and then update it to the text view in the activity
     */
    private fun rollDice() {
        //Creates a Dice instance with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Reference the dice image
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Set the image id according to the result
        val drawableResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //set the image resource
        diceImage.setImageResource(drawableResource)

        //add a content description
        diceImage.contentDescription = diceRoll.toString()

    }
}

//Dice with a fixed number of sides
class Dice(private val numSides: Int) {

    // Generate a random number and return it
    fun roll(): Int {
        return (1..numSides).random()
    }
}