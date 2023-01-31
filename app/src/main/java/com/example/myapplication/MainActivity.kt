package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botModeBtn = findViewById<Button>(R.id.botModeBtn)
        botModeBtn.setOnClickListener {
            val intentBot = Intent(this, BotGame::class.java)
            startActivity(intentBot) }

            val multiModeBtn = findViewById<Button>(R.id.multiModeBtn)
            multiModeBtn.setOnClickListener {
                val intentMulti = Intent(this, MultiGame::class.java)
                startActivity(intentMulti) }
    }
}