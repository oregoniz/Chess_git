package Chess;

public class Queen extends ChessPiece {

    public Queen(String color) {
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
        return "Q";
    }

    @Override
    boolean isRightMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canStepS = false;
        boolean canStepD = false;
        boolean onTheWay = false;
        int stepsL = toLine - line;
        int stepsC = toColumn - column;

        if ((toLine == line) || (toColumn == column)) canStepS = true;

        if (canStepS) {
            int steps = Math.max(Math.abs(stepsL), Math.abs(stepsC));
            String direction = "";
            if (stepsL == 0 && stepsC > 0) direction = "r";
            if (stepsL == 0 && stepsC < 0) direction = "l";
            if (stepsL > 0 && stepsC == 0) direction = "u";
            if (stepsL < 0 && stepsC == 0) direction = "d";

            switch (direction) {
                case "r":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line][column + i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "l":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line][column - i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "u":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line - i][column] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "d":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line - i][column] != null) {
                            onTheWay = true;
                        }

                        break;
                    }
            }
        }

        if (Math.abs(toLine - line) == Math.abs(toColumn - column)) canStepD = true;
        if (canStepD) {
            String direction = "";
            int steps = Math.abs(stepsL);
            if (stepsL > 0 && stepsC > 0) direction = "ur";
            if (stepsL > 0 && stepsC < 0) direction = "ul";
            if (stepsL < 0 && stepsC > 0) direction = "dr";
            if (stepsL < 0 && stepsC < 0) direction = "dl";

            switch (direction) {
                case "ur":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line + i][column + i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "ul":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line + i][column - i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "dr":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line - i][column + i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "dl":
                    for (int i = 1; i <= steps; i++) {
                        if (chessBoard.board[line - i][column - i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
            }
        }
        return (canStepD||canStepS) && !onTheWay;

    }
}
