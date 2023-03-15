package com.example.myapplication


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/*



*/


class BotGame : AppCompatActivity(), checkersDelegate {

    var checkersModel = checkersModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bot_game_layout)
        Log.d("BotGame","$checkersModel")
        val checkersView = findViewById<board>(R.id.checkersView)
        checkersView.checkersDelegate = this
    }

    override fun pieceAt(col: Int, row: Int): checkersPiece? {
        return checkersModel.pieceAt(col,row)
    }
}
