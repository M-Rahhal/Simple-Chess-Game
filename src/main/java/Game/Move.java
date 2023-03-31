package Game;

import Board.*;
import Pieces.*;
import Player.Player;

public class Move {

    private Board board;
    private Player player;
    private Piece piece;
    private Piece killedPiece;
    private Spot end;
    private Spot start;


    public Move(Player player , Spot start , Spot end ,Board board){
        this.player=player;
        this.start=start;
        this.end=end;
        this.piece=start.getPiece();
        this.board = board;
    }

    public boolean makeMove(){
        if (piece == null)
            return false;
        if (!piece.canMove(end , board))
            return false;
        if (end.getPiece()!=null)
            killedPiece=end.getPiece();
        piece.move(end);
        return true;
    }

    public boolean undoMove(){
        start.setPiece(end.getPiece());
        end.setPiece(killedPiece);
        killedPiece=null;
        return true;
    }

}
