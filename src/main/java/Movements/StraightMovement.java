package Movements;

import Board.Board;
import Board.Spot;
import Pieces.Piece;

public class StraightMovement implements MovementStyle{
    Piece piece;
    public StraightMovement(Piece piece){
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


        if (piece.getCurrentSpot().getX() == end.getX()) {
            int min = Math.min(piece.getCurrentSpot().getY() , end.getY());
            int max = Math.max(piece.getCurrentSpot().getY() , end.getY());

            for (int i = max - 1; i > min; i--){
                if (board.getPiece(piece.getCurrentSpot().getX(), i) != null)
                    return false;
            }
            return true;
        }

        if (piece.getCurrentSpot().getY() == end.getY()) {
            int min = Math.min(piece.getCurrentSpot().getX(), end.getX());
            int max = Math.max(piece.getCurrentSpot().getX(), end.getX());

            for (int i = max - 1; i > min; i--) {
                if (board.getPiece(i, piece.getCurrentSpot().getY()) != null)
                    return false;
            }
            return true;
        }
        return false;
    }
}
