package Pieces;


import Board.*;
import Movements.MovementStyle;

public abstract class Piece {
    private boolean isWhite;
    private boolean isAlive;
    private Board board;
    private Spot currentSpot;
    private MovementStyle movementStyle;


    public Piece(boolean isWhite , Board board) {
        this.isWhite = isWhite;
        this.board = board;
        isAlive = true;
    }

    public void setCurrentSpot(Spot currentSpot){

        this.currentSpot = currentSpot;
    }
    public Spot getCurrentSpot(){
        return this.currentSpot;
    }

    public boolean move(Spot end) {
        if (!isAlive)
            return false;

        if (this.canMove(end ,board)){
            end.setPiece(this);
            this.currentSpot.setPiece(null);
        }
        return true;

    }
    public abstract boolean canMove(Spot end , Board board);


    public void setMovementStyle(MovementStyle movementStyle){
        this.movementStyle = movementStyle;
    }

    public boolean isWhite() {
        return isWhite;
    }
    public Board getBoard(){
        return this.board;
    }

    public boolean isAlive(){
        return this.isAlive;
    }

    public MovementStyle getMovementStyle() {
        return movementStyle;
    }
}
