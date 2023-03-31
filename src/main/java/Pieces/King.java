package Pieces;

import Board.*;
import Movements.SingleMovement;
import Movements.StraightMovement;

public class King extends Piece {
    private boolean hasMoved;
    private Rook rook = null;

    public King(boolean isWhite, Board board) {
        super(isWhite, board);
        hasMoved = false;
        setMovementStyle(new SingleMovement(this));
    }
    @Override
    public boolean canMove(Spot end, Board board) {
        if (board.getPiece(end) != null && board.getPiece(end).isWhite() == isWhite())
            return false;
        if (isCastling(end))
            return true;

        else if (getMovementStyle().canMove(end , board))
            return true;

        return false;

    }

    private boolean isCastling(Spot end){
        if (end.getPiece()==null)
            return false;

        if (!this.hasMoved && end.getPiece() instanceof Rook){
            if ( (!((Rook) end.getPiece()).HasMoved()))
                return true;
        }
        return false;
    }

    @Override
    public boolean move(Spot end) {
        if (isInCheck(end))
            return false;
        if (canMove(end, this.getBoard())){
            if (isCastling(end))
                return doCastling((Rook) end.getPiece());

            super.move(end);
            this.hasMoved = true;
            return true;
        }
        return false;
    }


    private boolean doCastling(Rook rook){
            Spot kingSpot = this.getCurrentSpot();
            Spot rookSpot = rook.getCurrentSpot();
            rookSpot.setPiece(this);
            kingSpot.setPiece(rook);
            return true;
    }



    public boolean isInCheck() {
        if (isWhite()) {
            for (Piece piece : this.getBoard().getBlackPieces())
                if (piece.canMove(this.getCurrentSpot() , this.getBoard()))
                    return true;
        }
        else {
            for (Piece piece : this.getBoard().getWhitePieces())
                if (piece.canMove(this.getCurrentSpot() , this.getBoard()))
                    return true;
        }

        return false;
    }
    public boolean isInCheck(Spot end){
        if (isWhite()) {
            for (Piece piece : this.getBoard().getBlackPieces())
                if (piece.canMove(end , this.getBoard()))
                    return true;
        }
        else {
            for (Piece piece : this.getBoard().getWhitePieces())
                if (piece.canMove(end , this.getBoard()))
                    return true;
        }

        return false;
    }
}