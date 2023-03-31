package Movements;

import Board.Board;
import Board.Spot;
import Pieces.Piece;

public class SingleForwardMovement implements MovementStyle{
    Piece piece;

    public SingleForwardMovement(Piece piece){
        this.piece=piece;
    }
    @Override
    public boolean canMove(Spot end, Board board) {

        Spot start =  piece.getCurrentSpot();

        if (!piece.isAlive()) {
            return false;
        }
        if (board.getPiece(end) != null && board.getPiece(end).isWhite() == piece.isWhite()) {
            return false;
        }

        if (start.getX() == end.getX() && end.getY()-start.getY()==1){
            return true;
        }
        return false;
    }
}
