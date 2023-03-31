package Pieces;

import Board.*;
import Movements.StraightMovement;

public class Rook extends Piece {

    private boolean hasMoved;


    public Rook(boolean isWhite, Board board) {
        super(isWhite, board);
        hasMoved = false;
        setMovementStyle(new StraightMovement(this));
    }
    @Override
    public boolean move(Spot end){
        if (canMove(end, this.getBoard())){
            super.move(end);
            this.hasMoved = true;
            return true;
        }
        return false;
    }


    @Override
    public boolean canMove(Spot end, Board board) {
      return getMovementStyle().canMove(end , board);
    }

    public boolean HasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}