package github.Laurentsz.application;

import github.Laurentsz.boardgame.Board;
import github.Laurentsz.chess.ChessException;
import github.Laurentsz.chess.ChessMatch;
import github.Laurentsz.chess.ChessPiece;
import github.Laurentsz.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> capturedPieces = new ArrayList<>();

        while (!chessMatch.getCheckMate()){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch, capturedPieces);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if(capturedPiece != null){
                    capturedPieces.add(capturedPiece);
                }
            }catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, capturedPieces);
    }
}
