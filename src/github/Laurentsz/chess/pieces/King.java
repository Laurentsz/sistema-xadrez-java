package github.Laurentsz.chess.pieces;

import github.Laurentsz.boardgame.Board;
import github.Laurentsz.boardgame.Position;
import github.Laurentsz.chess.ChessMatch;
import github.Laurentsz.chess.ChessPiece;
import github.Laurentsz.chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // special move castling

        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            // special move castling kingside rook
            Position positionRookOne = new Position(position.getRow(), position.getColumn() +3);
            if(testRookCastling(positionRookOne)){
                Position position1 = new Position(position.getRow(), position.getColumn() +1);
                Position position2 = new Position(position.getRow(), position.getColumn() +2);
                if(getBoard().piece(position1) == null && getBoard().piece(position2) == null){
                    mat[position.getRow()][position.getColumn() +2] = true;
                }

            }

        }

        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            // special move castling queenside rook
            Position positionRookTwo = new Position(position.getRow(), position.getColumn() -4);
            if(testRookCastling(positionRookTwo)){
                Position position1 = new Position(position.getRow(), position.getColumn() -1);
                Position position2 = new Position(position.getRow(), position.getColumn() -2);
                Position position3 = new Position(position.getRow(), position.getColumn() -3);
                if(getBoard().piece(position1) == null && getBoard().piece(position2) == null && getBoard().piece(position3) == null){
                    mat[position.getRow()][position.getColumn() -2] = true;
                }
            }
        }

        return mat;

    }
}
