package Chess;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        return "P";
    }

    @Override
    public boolean isRightMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int step = toLine - line;
        boolean canStep = false;
        if (column == toColumn) {
            if (color.equals("White") && line == 1 && step == 1 && chessBoard.board[toLine][column] == null) {
                canStep = true;
            }
            if (color.equals("White") && line == 1 && step == 2 && chessBoard.board[toLine][column] == null && chessBoard.board[toLine - 1][column] == null) {
                canStep = true;
            }
            if (color.equals("Black") && line == 6 && step == -1 && chessBoard.board[toLine][column] == null) {
                canStep = true;
            }
            if (color.equals("Black") && line == 6 && step == -2 && chessBoard.board[toLine][column] == null && chessBoard.board[toLine + 1][column] == null) {
                canStep = true;
            }
            if (color.equals("White") && step == 1 && chessBoard.board[toLine][column] == null) {
                canStep = true;
            }
            if (color.equals("Black") && step == -1 && chessBoard.board[toLine][column] == null) {
                canStep = true;
            }
        } else if (Math.abs(column - toColumn) == 1) {
            if (color.equals("White") && (toLine == line + 1) && !chessBoard.board[toLine][column].color.equals("Black")) {
                canStep = true;
            }
            if (color.equals("Black") && (toLine == line - 1) && !chessBoard.board[toLine][column].color.equals("White")) {
                canStep = true;}
            }

            return canStep;
        }
    }
