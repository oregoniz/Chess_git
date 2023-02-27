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
        boolean is = false;
        boolean otw = false;
        int stepsL = toLine - line;
        int stepsC = toColumn - column;
        String direction = "";
        if (stepsL > 0 && stepsC > 0) direction = "ur";
        if (stepsL > 0 && stepsC < 0) direction = "ul";
        if (stepsL < 0 && stepsC > 0) direction = "dr";
        if (stepsL < 0 && stepsC > 0) direction = "dl";

        if (Math.abs(stepsL) == Math.abs(stepsC)) {
            is = true;
            switch (direction) {
                case "ur":
                    for (int i = line; i <= line + Math.abs(stepsL); i++) {
                        if (chessBoard.board[i][i] != null) {
                            otw = true;
                            break;
                        }
                    }
                case "ul":
                    for (int i = line; i <= line + Math.abs(stepsL); i++) {
                        if (chessBoard.board[i][-i] != null) {
                            otw = true;
                            break;
                        }
                    }
                case "dr":
                    for (int i = line; i <= line + Math.abs(stepsL); i++) {
                        if (chessBoard.board[-i][i] != null) {
                            otw = true;
                            break;
                        }
                    }
                case "dl":
                    for (int i = line; i <= line + Math.abs(stepsL); i++) {
                        if (chessBoard.board[-i][-i] != null) {
                            otw = true;
                            break;
                        }
                    }
            }
        }
        return is && otw;
    }
}
