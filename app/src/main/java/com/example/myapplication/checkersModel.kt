package com.example.myapplication

class checkersModel {

    var piecesBox = mutableSetOf<checkersPiece>()

    init{
        reset()
    }

    fun reset(){
        piecesBox.removeAll(piecesBox)
        for(i in 0..2){
            for (j in 0..7){
                if((i+j)%2==0){
                    piecesBox.add(checkersPiece(j,i,checkersPlayer.WHITE,R.drawable.white_man))
                }
                if((i+j)%2==1){
                    piecesBox.add(checkersPiece(j,7-i,checkersPlayer.BLACK,R.drawable.dark_man))
                }
            }
        }



    }

    fun pieceAt(col:Int, row:Int) : checkersPiece?{
        for(piece in piecesBox){
            if(col == piece.col && row == piece.row){
                return piece
            }
        }
        return null
    }

    override fun toString(): String {
        var desc = " \n"
        for (row in 7 downTo 0){
            desc +="$row"
            for (col in 0..7){
                val piece = pieceAt(col, row)
                if(piece == null) {
                    desc += " ."
                }else{
                    when (piece.player){
                        checkersPlayer.WHITE-> {desc += " W"}
                        checkersPlayer.BLACK-> {desc += " B"}
                    }
                }
            }
            desc +="\n"
        }
        desc += "  0 1 2 3 4 5 6 7"

        return desc
    }
}