public class Board {
    private static int SIZE = 3;
    private char cells[][];

    public Board() {
        this.cells = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                cells[i][j] = ' ';
    }

    public void print() {
        System.out.println("\n|---|---|---|\n");
        for (int i = 0; i < SIZE; i++) {
            System.out.println("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.println(" "+cells[i][j]);
                System.out.println(" |");
            }
            System.out.println("\n|---|---|---|\n");
        }
    }

    public boolean isValidMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();

        if ((row <= SIZE && row >= 1) && (col <= SIZE && col >= 1)) {
            if (cells[row][col] == ' ')
                return true;
            else
                return false;
        } else
            return false;
    }

    public boolean makeMove(Move move, char mark) {
        cells[move.getRow()][move.getCol()] = mark;
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public boolean checkForWin(char mark) {
        if (cells[0][0] == mark && cells[0][1] == mark && cells[0][2] == mark) {
            return true;
        } else if (cells[1][0] == mark && cells[1][1] == mark && cells[1][2] == mark) {
            return true;
        } else if (cells[2][0] == mark && cells[2][1] == mark && cells[2][2] == mark) {
            return true;
        } else if (cells[0][0] == mark && cells[1][1] == mark && cells[2][2] == mark) {
            return true;
        } else if (cells[0][2] == mark && cells[1][1] == mark && cells[2][0] == mark) {
            return true;
        } else if (cells[0][0] == mark && cells[1][0] == mark && cells[2][0] == mark) {
            return true;
        } else if (cells[0][1] == mark && cells[1][1] == mark && cells[2][1] == mark) {
            return true;
        } else if (cells[0][2] == mark && cells[1][2] == mark && cells[2][2] == mark) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isWinningMove(Move move, char mark) {
        makeMove(move, mark);
        if (checkForWin(mark)) {
            cells[move.getRow()][move.getCol()] = ' ';
            return true;
        } else {
            cells[move.getRow()][move.getCol()] = ' ';
            return false;
        }
    }
}
