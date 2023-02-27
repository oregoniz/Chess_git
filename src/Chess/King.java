package Chess;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard chessboard, int line, int column) {
        boolean is = false;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (chessboard.board[i][j] != null) {
                    if (!chessboard.board[i][j].color.equals(this.color) && chessboard.board[i][j].canMoveToPosition(chessboard, i, j, line, column)) {
                        is = true;
                    }
                }
            }
        }
        return is;
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
        return "K";
    }

    @Override
    boolean isRightMove(int line, int column, int toLine, int toColumn) {
        boolean is = false;
        if (Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <= 1) is = true;
        return is;
    }
}
