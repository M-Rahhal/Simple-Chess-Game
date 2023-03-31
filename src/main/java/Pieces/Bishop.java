package Pieces;

import Board.*;
import Movements.DiagonalMovement;

public class Bishop extends Piece {

     public Bishop(boolean isWhite, Board board) {
        super( isWhite, board);
        setMovementStyle(new DiagonalMovement(this));
    }

    @Override
    public boolean canMove(Spot end, Board board) {
        return getMovementStyle().canMove(end , board);
    }

}