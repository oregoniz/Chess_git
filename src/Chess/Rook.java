package Chess;

public class Rook extends ChessPiece {

    public Rook(String color) {
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
        return "R";
    }

    @Override
    boolean isRightMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canStep = false;
        boolean onTheWay = false;
        int stepsL = toLine - line;
        int stepsC = toColumn - column;

        if ((toLine == line) || (toColumn == column)) canStep = true;

        if (canStep) {
            int steps = Math.max(Math.abs(stepsL), Math.abs(stepsC));
            String direction = "";
            if (stepsL == 0 && stepsC > 0) direction = "r";
            if (stepsL == 0 && stepsC < 0) direction = "l";
            if (stepsL > 0 && stepsC == 0) direction = "u";
            if (stepsL < 0 && stepsC == 0) direction = "d";

            switch (direction) {
                case "r":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line][column + i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "l":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line][column - i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "u":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line - i][column] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "d":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line - i][column] != null) {
                            onTheWay = true;
                        }

                        break;
                    }
            }
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                onTheWay = true;
            }
        }
        return canStep && !onTheWay;
    }
}
