package com.example.hkr_app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonPlayMenu = findViewById<Button>(R.id.buttonPlayMenu)
        val buttonScore = findViewById<Button>(R.id.buttonScore)
        val buttonHelp = findViewById<Button>(R.id.buttonHelp)

        buttonPlayMenu.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }

        buttonScore.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java)
            startActivity(intent)
        }

        buttonHelp.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }
    }
}
