package Chess;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInTheField(chessBoard, toLine, toColumn) && isRightMove(line, column, toLine, toColumn) && isNotSame(line, column, toLine, toColumn)) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    boolean isRightMove(int line, int column, int toLine, int toColumn) {
        boolean is = false;
        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) is = true;
        return is;
    }
}
