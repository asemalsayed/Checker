package com.example.myapplication


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
class BotGame : AppCompatActivity() {

    var checkersModel = checkersModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bot_game_layout)
        Log.d("BotGame","$checkersModel")
    }
}
