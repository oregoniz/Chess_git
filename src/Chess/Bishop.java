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
        if (isInTheField(chessBoard, toLine, toColumn) && isRightMove(chessBoard, line, column, toLine, toColumn) && isNotSame(line, column, toLine, toColumn)) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    boolean isRightMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean canStep = false;
        boolean onTheWay = false;
        int stepsL = toLine - line;
        int stepsC = toColumn - column;

        if (Math.abs(stepsL) == Math.abs(stepsC)) {
            canStep = true;
        }
        if (canStep) {
            String direction = "";
            int steps = Math.abs(stepsL);
            if (stepsL > 0 && stepsC > 0) direction = "ur";
            if (stepsL > 0 && stepsC < 0) direction = "ul";
            if (stepsL < 0 && stepsC > 0) direction = "dr";
            if (stepsL < 0 && stepsC < 0) direction = "dl";

            switch (direction) {
                case "ur":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line + i][column + i] != null) {
                            onTheWay = true;

                        }
                    }
                    break;
                case "ul":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line + i][column - i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "dr":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line - i][column + i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
                case "dl":
                    for (int i = 1; i < steps; i++) {
                        if (chessBoard.board[line - i][column - i] != null) {
                            onTheWay = true;
                        }
                    }
                    break;
            }
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                onTheWay = true;
            }
        }


        return canStep && !onTheWay;
    }
}
