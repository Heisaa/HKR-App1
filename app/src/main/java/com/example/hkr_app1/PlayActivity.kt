package com.example.hkr_app1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val buttonGuess = findViewById<Button>(R.id.buttonGuess)
        val textAddition = findViewById<TextView>(R.id.textAddition)
        val editGuess = findViewById<EditText>(R.id.editGuess)
        val textFeedback = findViewById<TextView>(R.id.textFeedback)
        val textRound = findViewById<TextView>(R.id.textRound)

        var answer = generateChallange(1, textAddition)
        var score = 0
        var round = 1
        val endRound = 5

        var state = State.GUESSING

        buttonGuess.isEnabled = false
        textRound.text = "${round}/${endRound}"

        editGuess.doAfterTextChanged {
            // Deactivate button if guess is empty
            buttonGuess.isEnabled = !it.isNullOrEmpty()

        }

        buttonGuess.setOnClickListener {

            when(state) {
                State.GUESSING -> {
                    if (answer == editGuess.text.toString().toInt()) {
                        textFeedback.setTextColor(Color.GREEN)
                        textFeedback.text = "Correct!"
                        score++
                    } else {
                        textFeedback.setTextColor(Color.RED)
                        textFeedback.text = "Not correct"
                    }

                    buttonGuess.text = "Continue"
                    editGuess.isEnabled = false

                    state = State.FEEDBACK


                }

                State.FEEDBACK -> {



                    if (round >= endRound) {
                        val intent = Intent(this, ScoreActivity::class.java)
                        intent.putExtra("score", score)
                        finish()
                        startActivity(intent)
                    } else {

                        textFeedback.text = ""
                        editGuess.isEnabled = true
                        editGuess.text.clear()
                        buttonGuess.text = "Guess"


                        answer = generateChallange(1, textAddition)
                        round++

                        state = State.GUESSING
                    }


                }
            }


            textRound.text = "Round ${round}/${endRound}\nScore: ${score}"


        }
    }

    private fun generateChallange(numbers : Int, element : TextView): Int {
        var firstNum: Int;
        var secondNum: Int;

        if (numbers == 1) {
            firstNum = (1..9).random()
            secondNum = (1..9).random()
        } else if (numbers == 2) {
            firstNum = (10..99).random()
            secondNum = (10..99).random()
        } else {
            firstNum = (100..999).random()
            secondNum = (100..999).random()
        }

        element.text = "${firstNum} + ${secondNum} ="

        return firstNum + secondNum
    }

    enum class State {
        GUESSING,
        FEEDBACK,
    }
}