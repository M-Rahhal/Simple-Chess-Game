package Movements;

import Board.Board;
import Board.Spot;
import Pieces.Piece;

public class SingleMovement implements MovementStyle{
    Piece piece;

    public SingleMovement(Piece piece){
        this.piece=piece;
    }
    @Override
    public boolean canMove(Spot end, Board board) {

        if (board.getPiece(end) != null && board.getPiece(end).isWhite() == piece.isWhite())
            return false;

       Spot start =  piece.getCurrentSpot();

        if (start.getY()==end.getY())
            return Math.abs(start.getX()-end.getX())==1;
        else if (start.getX()==end.getX())
            return Math.abs(start.getY()-end.getY())==1;
        if (start.getX() - end.getX() == start.getY() - end.getY())
            return true;
        else if (-start.getX() + end.getX() == start.getY() - end.getY())
            return true;
        return false;
    }
}
