package Pieces.Factory;

import Board.Board;
import Pieces.*;

public class PiecesFactory {

    private Board board;
    public PiecesFactory(Board board){
        this.board = board;
    }

    private Piece getInstance(boolean isWhite , Types type){
        Piece piece = null;
        switch (type){
            case KING:
                piece = new King(isWhite , board);
                break;
            case PAWN:
                piece = new Pawn(isWhite, board);
                break;
            case ROOK:
                piece = new Rook(isWhite, board);
                break;
            case QUEEN:
                piece = new Queen(isWhite, board);
                break;
            case BISHOP:
                piece = new Bishop(isWhite, board);
                break;
            case KNIGHT:
                piece = new Knight(isWhite, board);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return piece;
    }
    public Piece getWhiteInstance( Types type){
        return getInstance(true , type);
    }
    public Piece getBlackInstance( Types type){
        return getInstance(false , type);
    }
}
