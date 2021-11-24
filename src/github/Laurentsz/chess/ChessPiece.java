package github.Laurentsz.chess;


import github.Laurentsz.boardgame.Board;
import github.Laurentsz.boardgame.Piece;
import github.Laurentsz.boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount(){
        return moveCount;
    }
    public void increaseMoveCount(){
        moveCount++;
    }

    public void decreaseMoveCount(){
        moveCount--;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
}
