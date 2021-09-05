package github.Laurentsz.chess.pieces;

import github.Laurentsz.boardgame.Board;
import github.Laurentsz.chess.ChessPiece;
import github.Laurentsz.chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[getBoard().getRows()][getBoard().getColumns()];
    }
}
