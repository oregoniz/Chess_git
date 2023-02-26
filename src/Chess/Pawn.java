package Chess;

import javax.sound.sampled.Line;

public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (isInTheField(chessBoard,toLine, toColumn) && isRightMove(chessBoard,line, column, toLine, toColumn) && isNotSame(chessBoard,line, column, toLine, toColumn)) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public boolean isRightMove(ChessBoard chessBoard,int line, int column, int toLine, int toColumn) {
        int step = toLine - line;
        boolean is = false;
        if (column == toColumn) {
            if (color.equals("White") && line == 1 && (step == 1 || step == 2)) {
                is = true;
            }
            if (color.equals("Black") && line == 6 && (step == -1 || step == -2)) {
                is = true;
            }
            if (color.equals("White") && step == 1) {
                is = true;
            }
            if (color.equals("Black") && step == -1) {
                is = true;
            }
        }
        return is;
    }
}
