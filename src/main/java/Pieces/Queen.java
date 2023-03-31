package Pieces;

import Board.*;
import Movements.DiagonalAndStraight;

public class Queen extends Piece {


    public Queen(boolean isWhite, Board board) {
        super( isWhite, board);
        setMovementStyle(new DiagonalAndStraight(this));
    }

    @Override
    public boolean canMove(Spot end, Board board) {
        return getMovementStyle().canMove(end , board);
    }
}