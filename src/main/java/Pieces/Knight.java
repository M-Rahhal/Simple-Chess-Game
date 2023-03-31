package Pieces;

import Board.*;
import Movements.KnightMovement;

public class Knight extends Piece{

    public Knight(boolean isWhite, Board board) {
        super(isWhite , board);
        setMovementStyle(new KnightMovement(this));
    }

    @Override
    public boolean canMove(Spot end, Board board) {
        return getMovementStyle().canMove(end,board);
    }

}