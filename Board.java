public class Board {
    private static int SIZE=3;
    private char cells[][];

    public Board() {
        this.cells=new char [SIZE] [SIZE];
    }

    public void print() {

    }

    public boolean isValidMove(Move move) {
        int row=move.getRow();
        int col=move.getCol();

        if( (row<=SIZE && row>=1) && (col<=SIZE && col>=1)) {
            if(cells[row][col]=='X' || cells[row][col]=='O' || cells[row][col]=='x' || cells[row][col]=='o'){
               return false; 
            }
        }
        else {
            return false;
        }
        return true;
    }
 
    public boolean makeMove(Move move, char mark) {

    }

    public boolean isFull(){

    }

    public boolean checkForWin(char mark) {

    }
}
