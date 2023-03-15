package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class board(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private final val sellSide = 115f
    private final val originX = 70f
    private final val originY = 200f
    private final val paint = Paint()
    private  final val imgResIDs = setOf(
        R.drawable.dark_man,
        R.drawable.white_man
    )
    private final val bitmaps = mutableMapOf<Int, Bitmap>()

    var checkersDelegate: checkersDelegate? = null
    init{
        loadBitmaps()
    }
    override fun onDraw(canvas: Canvas?) {
        drawCheckersBoard(canvas)
        drawPieces(canvas)

    }

    private  fun drawPieces(canvas: Canvas?){
//        val checkersModel = checkersModel()
//        checkersModel.reset()

        for(row in 0..7){
            for (col in 0..7){

                checkersDelegate?.pieceAt(col,row)?.let{drawPieceAt(canvas,col,row,it.resID)}
            }
        }
//        drawPieceAt(canvas,0,0,R.drawable.white_man)

    }

    private fun drawPieceAt(canvas: Canvas?,col:Int, row:Int, resID:Int){
        val darkMan = bitmaps[resID]!!
        canvas?.drawBitmap(darkMan, null,RectF(originX+col*sellSide,originY+(7-row)*sellSide,originX+(col+1)*sellSide,originY+(8-row)*sellSide),paint)
    }


    private fun loadBitmaps(){
        imgResIDs.forEach {
            bitmaps[it] = BitmapFactory.decodeResource(resources, it)
    }
    }

    private  fun drawCheckersBoard(canvas: Canvas?){
        for (row in 0..7){
            for (col in 0..7) {
                drawSquareAt(canvas,col,row,(row+col) %2 == 1)
            }
        }
    }
    private fun drawSquareAt(canvas: Canvas?,col: Int, row:Int,isDark:Boolean){
        paint.color =if (isDark) Color.DKGRAY else Color.LTGRAY
        canvas?.drawRect(originX +col*sellSide, originY+(row)*sellSide, originX + (1+col)*sellSide, originY +(1+row)* sellSide, paint)

    }
}