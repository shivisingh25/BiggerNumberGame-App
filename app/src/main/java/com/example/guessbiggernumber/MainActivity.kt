package com.example.guessbiggernumber

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Random


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()
        findViewById<Button>(R.id.btnLeft)
            .setOnClickListener {
                // code here will run everytime left button is clicked
                checkAnswer(true)
                assignNumbersToButtons()
            }


        findViewById<Button>(R.id.btnRight)
            .setOnClickListener {
                checkAnswer(false)
                assignNumbersToButtons()
            }

    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum: Int = findViewById<Button>(R.id.btnLeft).text.toString().toInt()
        val rightNum: Int = findViewById<Button>(R.id.btnRight).text.toString().toInt()
        val isAnswerCorrect: Boolean =
            if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            // Correct answer!!
            // Change background color
            findViewById<ConstraintLayout>(R.id.subheading1).setBackgroundColor(Color.GREEN)
            // Show a Toast
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            // Wrong answer!!
            findViewById<ConstraintLayout>(R.id.subheading1).setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum: Int = r.nextInt(10)
        var rightNum: Int = leftNum
        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }
        findViewById<Button>(R.id.btnLeft).text = leftNum.toString()
        findViewById<Button>(R.id.btnRight).text = rightNum.toString()
    }
}

