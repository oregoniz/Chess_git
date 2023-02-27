package Chess;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInTheField(chessBoard, toLine, toColumn) && isRightMove(chessBoard, line, column, toLine, toColumn) && isNotSame(line, column, toLine, toColumn)) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean isRightMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean is = false;
        if (Math.abs(line - toLine) == 2) {
            if (Math.abs(column - toColumn) == 1) is = true;
        }
        if (Math.abs(column - toColumn) == 2) {
            if (Math.abs(line - toLine) == 1) is = true;
        }
        return is;
    }
}



