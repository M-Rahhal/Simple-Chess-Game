package Movements;

import Board.Board;
import Board.Spot;
import Pieces.Piece;

public class DiagonalMovement implements MovementStyle{
     Piece piece;

     public DiagonalMovement(Piece piece){
         this.piece = piece;
     }
    @Override
    public boolean canMove(Spot end, Board board) {
        if (!piece.isAlive()) {
            return false;
        }
        if (piece.getCurrentSpot().equals(end)){
            return false;
        }
        if (board.getPiece(end) != null && board.getPiece(end).isWhite() == piece.isWhite()) {
            return false;
        }

        Spot start = piece.getCurrentSpot();

        if (start.getX() - end.getX() != start.getY() - end.getY() ||
                -start.getX() + end.getX() != start.getY() - end.getY())
            return false;

        int x, y;
        if(end.getX() > start.getX() && end.getY() > start.getY()) {
            y = start.getY()+1;
            for( x= start.getX()+1; x<end.getX(); x++) {
                if(board.getPiece(x, y)!= null)
                    return false;
                y++;
            }
        }

        else if(end.getX() < start.getX() && end.getY() < start.getY()) {
            y = start.getY()-1;
            for( x= start.getX()-1; x> end.getX(); x--) {
                if(board.getPiece(x, y) != null) {
                    return false;
                }
                y--;
            }

        }
        else if(end.getX() > start.getX() && end.getY() < start.getY()) {
            y = start.getY()-1;
            for( x= start.getX()+1; x< end.getX(); x++) {
                if(board.getPiece(x, y) != null) {
                    return false;
                }
                y--;
            }
        }
        else if(end.getX() < start.getX() && end.getY() > start.getY()) {
            y = start.getY()+1;
            for( x= start.getX()-1; x> end.getX(); x--) {
                if(board.getPiece(x, y) != null) {
                    return false;
                }
                y++;
            }
        }
        return true;
    }
}
