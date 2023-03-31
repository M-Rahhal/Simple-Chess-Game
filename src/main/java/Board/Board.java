package Board;

import Pieces.*;
import Pieces.Factory.PiecesFactory;
import Pieces.Factory.Types;

import java.util.LinkedList;

public class Board {


    private static final int ROWS = 8;
    private static final int COLUMNS = 8;
    private PiecesFactory factory;
    private Spot[][] spots;

    private LinkedList<Piece> whitePieces = new LinkedList<>();
    private LinkedList<Piece> blackPieces = new LinkedList<>();

    public Board() {
        spots = new Spot[ROWS][COLUMNS];
    }

    public void initializeBoard() {
         factory = new PiecesFactory(this);

        spots[0][0] = new Spot( 0, 0 ,  factory.getWhiteInstance(Types.ROOK));
        spots[1][0] = new Spot( 1, 0 ,  factory.getWhiteInstance(Types.KNIGHT));
        spots[2][0] = new Spot( 2, 0 ,  factory.getWhiteInstance(Types.BISHOP));
        spots[3][0] = new Spot( 3, 0 ,  factory.getWhiteInstance(Types.QUEEN));
        spots[4][0] = new Spot( 4, 0 ,  factory.getWhiteInstance(Types.KING));
        spots[5][0] = new Spot( 5, 0 ,  factory.getWhiteInstance(Types.BISHOP));
        spots[6][0] = new Spot( 6, 0 ,  factory.getWhiteInstance(Types.KNIGHT));
        spots[7][0] = new Spot( 7, 0 ,  factory.getWhiteInstance(Types.ROOK));

        for ( int x =0 ; x < 8 ; x++)
            spots[x][1] = new Spot(x, 1, factory.getWhiteInstance(Types.PAWN));

        for (int x = 0 ; x<8 ; x++){
            whitePieces.add(spots[x][0].getPiece());
            whitePieces.add(spots[x][1].getPiece());
        }



        spots[0][7] = new Spot( 0, 7 , factory.getBlackInstance(Types.ROOK));
        spots[1][7] = new Spot( 1, 7 , factory.getBlackInstance(Types.KNIGHT));
        spots[2][7] = new Spot( 2, 7 , factory.getBlackInstance(Types.BISHOP));
        spots[3][7] = new Spot( 3, 7 , factory.getBlackInstance(Types.QUEEN));
        spots[4][7] = new Spot( 4, 7 , factory.getBlackInstance(Types.KING));
        spots[5][7] = new Spot( 5, 7 , factory.getBlackInstance(Types.BISHOP));
        spots[6][7] = new Spot( 6, 7 , factory.getBlackInstance(Types.KNIGHT));
        spots[7][7] = new Spot( 7, 7 , factory.getBlackInstance(Types.ROOK));
        for ( int x =0 ; x < 8 ; x++)
            spots[x][6] = new Spot(x, 6, factory.getBlackInstance(Types.PAWN));

        for (int x = 0 ; x<8 ; x++){
            blackPieces.add(spots[x][7].getPiece());
            blackPieces.add(spots[x][6].getPiece());
        }

        for (int i = 0; i < 8; i++)
            for (int j = 2; j < 6; j++)
                spots[i][j] = new Spot(i, j, null);


    }

    public LinkedList<Piece> getWhitePieces() {
        return whitePieces;
    }

    public LinkedList<Piece> getBlackPieces() {
        return blackPieces;
    }
    public Piece getPiece(Spot spot) {
        return spots[spot.getX()][spot.getY()].getPiece();
    }
    public Piece getPiece(int x , int y) {
        return spots[x][y].getPiece();
    }


    public Spot[][] getGrid() {
        return spots;
    }

    public Spot getSpot(int x, int y) {
        return spots[x][y];
    }

}