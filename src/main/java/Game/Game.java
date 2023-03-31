package Game;


import Board.*  ;
import Pieces.*;
import Player.*;
import Validators.UserInputValidator;

import java.util.Scanner;

public class Game {
    private int numberOfMovesInTheGame=0;
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentTurn;
    private King whiteKing;
    private King blackKing;
    private boolean isGameOver;
    private GameStatus status;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        System.out.println("White player");
        String wPlayer = getNameInput();
        System.out.println("Black player");
        String bPlayer = getNameInput();
        this.board = new Board();
        initializeGame(wPlayer , bPlayer);
        whiteKing = (King) board.getPiece(4,0);
        blackKing = (King) board.getPiece(4,7);
        isGameOver =false;

    }

    public void startGame() {
        System.out.println("The game has started");
        this.play();
    }

    private String getNameInput(){
        String player;
        while(true) {
            System.out.println("Enter a name");
            player = scanner.nextLine();
            if (player.isEmpty()){
                displayInvalid();
                continue;
            }
            break;
        }
        return player;
    }
    private void initializeGame(String p1 , String p2){
        board.initializeBoard();
        whitePlayer=new HumanPlayer(p1 , true);
        blackPlayer=new HumanPlayer(p2 , false);
        currentTurn = whitePlayer;
        status = GameStatus.ACTIVE;
    }

    private void play() {
        while(true) {
            this.checkGameStatus();
            if (isGameOver) {
                System.out.println(status);
                return;
            }


            System.out.println(currentTurn.getName()+"'s turn!");
            if (currentTurn.isWhiteSide())
                if (whiteKing.isInCheck())
                    System.out.println("Your king is in check!");
            else
                if (blackKing.isInCheck())
                    System.out.println("Your king is in check");


            System.out.println("Make a move : ");
            String input = scanner.nextLine();
            if (!UserInputValidator.isValidInput(input)) {
                displayInvalid();
                continue;
            }
            String[] s = input.split(" ");
            Spot start = board.getSpot(getXFromInput(s[0]) , getYFromInput(s[0]));
            Spot end   = board.getSpot(getXFromInput(s[1]) , getYFromInput(s[1]));
            if (!playerMove(currentTurn , start , end)){
                System.out.println("You cant make this move , try again!");
                continue;
            }


            this.switchTurn();
        }
    }

    public void switchTurn(){
        if (currentTurn.isWhiteSide())
            currentTurn=blackPlayer;
        else currentTurn=whitePlayer;
    }


    public boolean playerMove(Player player , Spot start , Spot end){
        Move move = new Move(player , start , end , this.board);
        if (!move.makeMove())
            return  false;
        if (player.isWhiteSide()){
            if (whiteKing.isInCheck()){
                move.undoMove();
                return false;
            }
        }
        else{
            if (blackKing.isInCheck()){
                move.undoMove();
                return false;
            }
        }

        if (end.getPiece() instanceof Pawn){
            if (((Pawn) end.getPiece()).madeToTheEnd()){
                System.out.println("your pawn made it to the end , you can change it!\n" +
                        "Enter b for bishop\n" +
                        "enter k for knight\n" +
                        "enter q for queen\n" +
                        "enter r for rook\n" +
                        "enter anything except those for pawn");
                Scanner c = new Scanner(System.in);
                String c1 = c.next();
                ((Pawn) end.getPiece()).changePawn(c1);
            }
        }
        numberOfMovesInTheGame++;
        return true;
    }

    private void displayInvalid(){
        System.out.println("Invalid input , please try again.");
    }


    private static int getXFromInput(String s){
        char[] chars = s.toCharArray();
        return Integer.parseInt(String.valueOf(chars[1]));
    }


    private static int getYFromInput(String s){
        char[] chars = s.toCharArray();
        int n = Character.toLowerCase(chars[0]) - 'a';
        return n;
    }



    public void checkGameStatus(){
        if (numberOfMovesInTheGame>=100){
            status = GameStatus.DRAW;
            isGameOver=true;
            return;
        }
        if (this.currentTurn.isWhiteSide()){
            if (isDraw(blackKing)){
                status = GameStatus.STALEMATE;
                isGameOver =true;
            }
            else if (isLost(blackKing)){
                status = GameStatus.WHITE_WIN;
                isGameOver =true;
            }
        }
        else {
            if (isDraw(whiteKing)){
                status = GameStatus.STALEMATE;
                isGameOver = true;
            }
            else if (isLost(whiteKing)){
                status = GameStatus.BLACK_WIN;
                isGameOver =true;
            }
        }
        return;
    }
    private boolean isDraw(King king){
        for (int i =0 ; i< 7 ; i++)
            for (int j=0 ; j< 7 ; j++){
                if (king.canMove(board.getGrid()[i][j],board)){
                    return false;
                }
            }
        if (!king.isInCheck())
            return true;
        return false;
    }

    private boolean isLost(King king){
        for (int i =0 ; i< 7 ; i++)
            for (int j=0 ; j< 7 ; j++){
                if (!king.canMove(board.getGrid()[i][j],board) && king.isInCheck()){
                    return true;
                }
            }
        return false;
    }


}