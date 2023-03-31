package Movements;

import Board.Board;
import Board.Spot;
import Pieces.Piece;

public class DiagonalAndStraight implements MovementStyle{
    Piece piece;

    StraightMovement straightMovement;
    DiagonalMovement diagonalMovement;

    public DiagonalAndStraight(Piece piece){
        this.piece=piece;
        this.straightMovement = new StraightMovement(piece);
        this.diagonalMovement = new DiagonalMovement(piece);
    }
    @Override
    public boolean canMove(Spot end, Board board) {
        return diagonalMovement.canMove(end , board) || straightMovement.canMove(end , board);
    }
}
