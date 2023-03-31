package Movements;

import Board.Board;
import Board.Spot;
import Pieces.Piece;

public class KnightMovement implements MovementStyle{
     Piece piece;


     public KnightMovement(Piece piece){
         this.piece = piece;
     }
    @Override
    public boolean canMove(Spot end, Board board) {
        if (!piece.isAlive()) {
            return false;
        }
        if (board.getPiece(end) != null && board.getPiece(end).isWhite() == piece.isWhite()) {
            return false;
        }

        Spot start = piece.getCurrentSpot();

        if (Math.abs(start.getY() - end.getY())==2 && Math.abs(start.getX()-end.getX())==1){
            return true;
        }

        if (Math.abs(start.getX() - end.getX())==2 && Math.abs(start.getY()-end.getY())==1){
            return true;
        }

        return false;

    }
}
