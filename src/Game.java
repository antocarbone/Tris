package src;
public class Game {
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private Board board;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void play() {
        while (!(board.isFull())) {
            board.makeMove(currentPlayer.makeMove(board), currentPlayer.mark);
            board.print();
            if (board.checkForWin(currentPlayer.mark)) {
                System.out.println("\nHAI VINTO!");
                break;
            }
            if (currentPlayer.mark == player1.mark) {
                System.out.println("\nTURNO DI PLAYER 2");
                currentPlayer = player2;
            } else {
                System.out.println("\nTURNO DI PLAYER 1");
                currentPlayer = player1;
            }
        }
    }
}
