package Chess;

abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    abstract boolean isRightMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public boolean isInTheField(ChessBoard chessBoard, int toLine, int toColumn) {
        return chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn);
    }

    public boolean isNotSame(int line, int column, int toLine, int toColumn) {
        if ((line != toLine) || (column != toColumn)) return true;
        else return false;
    }
}


