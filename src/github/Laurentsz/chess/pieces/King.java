package github.Laurentsz.chess.pieces;

import github.Laurentsz.boardgame.Board;
import github.Laurentsz.chess.ChessPiece;
import github.Laurentsz.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }
}
