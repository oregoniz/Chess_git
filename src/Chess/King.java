package Chess;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInTheField(chessBoard, toLine, toColumn) && isRightMove(chessBoard, line, column, toLine, toColumn) && isNotSame(chessBoard, line, column, toLine, toColumn)) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    boolean isRightMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean is = false;
        if (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1) is = true;
        return is;
    }
}
