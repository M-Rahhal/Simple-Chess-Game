package Pieces;


import Board.Board;
import Board.Spot;
import Movements.SingleForwardMovement;

public class Pawn extends Piece {
    private boolean isOriginSpot;

    public Pawn(boolean isWhite, Board board) {
        super(isWhite, board);
        isOriginSpot = true;
        setMovementStyle(new SingleForwardMovement(this));
    }



    public boolean madeToTheEnd() {
        if(!this.isWhite() && this.getCurrentSpot().getY() == 0) {
            return true;
        }

        if(this.isWhite() && this.getCurrentSpot().getY() == 7) {
            return true;
        }
        return false;
    }

    public boolean changePawn(String str){
        char[] array = str.toCharArray();
        if (array.length!=1)
            return false;
        char choice = Character.toLowerCase(array[0]);
        Spot s = this.getCurrentSpot();
        if (isAlive() && madeToTheEnd()){
            switch (choice){
                case 'b':
                    s.setPiece(new Bishop(this.isWhite() , this.getBoard()));
                    break;
                case 'k':
                    s.setPiece(new Knight(this.isWhite() , this.getBoard()));
                    break;
                case 'q':
                    s.setPiece(new Queen(this.isWhite() , this.getBoard()));
                    break;
                case 'r':
                    s.setPiece(new Rook(this.isWhite() , this.getBoard()));
                    break;
                case 'p':
                    break;
                default:
                    return false;
            }

        }
        return true;
    }




    @Override
    public boolean move(Spot end) {

        if (canMove(end , this.getBoard())) {
            super.move(end);
            if (this.isOriginSpot)
                this.isOriginSpot = false;
            return true;
        }
        return false;
    }


    @Override
    public boolean canMove(Spot end, Board board) {
        Spot start =  this.getCurrentSpot();

        if (Math.abs(end.getX()-start.getX()) == 1 && end.getY()-start.getY()==1 && end.getPiece() != null){
            return true;
        }
        if (isOriginSpot && start.getX() == end.getX() && end.getY()-start.getY()==2){
            return true;
        }
        return getMovementStyle().canMove(end , board);
    }

    public boolean isOriginSpot(){
        return this.isOriginSpot;
    }

}