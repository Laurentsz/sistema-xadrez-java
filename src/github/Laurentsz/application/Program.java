package github.Laurentsz.application;

import github.Laurentsz.boardgame.Board;
import github.Laurentsz.chess.ChessMatch;

public class Program {

    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();

        UI.printBoard(chessMatch.getPieces());

    }
}
