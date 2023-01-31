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

    init{
        loadBitmaps()
    }
    override fun onDraw(canvas: Canvas?) {
        drawCheckersBoard(canvas)
        drawPieces(canvas)

    }

    private  fun drawPieces(canvas: Canvas?){
        drawPieceAt(canvas,0,0,R.drawable.white_man)

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
        for (i in 0..7){
            for (j in 0..7) {
                paint.color =if ((i+j) %2 == 1) Color.BLUE else Color.CYAN
                canvas?.drawRect(originX +j*sellSide, originY+(i)*sellSide, originX + (1+j)*sellSide, originY +(1+i)* sellSide, paint)
            }
        }
    }
}