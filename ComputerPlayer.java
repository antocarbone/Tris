import java.util.Random;

public class ComputerPlayer extends Player {
    private static Random random = new Random();

    public ComputerPlayer(char mark) {
        super(mark);
    }

    @Override
    public Move makeMove(Board board) {
        char other_player_mark;
        if (super.getMark() == 'x')
            other_player_mark = 'o';
        else
            other_player_mark = 'x';

        // controllo mosse di bloccaggio
        Move move;
        char[][] check = board.getCells();
        for (int i = 0; i < 3; i++) {
            if (check[i][0] == other_player_mark && check[i][1] == other_player_mark) {
                move = new Move(i, 2);
                if (board.isValidMove(move))
                    return move;
            }
            if (check[i][0] == other_player_mark && check[i][2] == other_player_mark) {
                move = new Move(i, 1);
                if (board.isValidMove(move))
                    return move;
            }
            if (check[i][1] == other_player_mark && check[i][2] == other_player_mark) {
                move = new Move(i, 0);
                if (board.isValidMove(move))
                    return move;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (check[0][i] == other_player_mark && check[1][i] == other_player_mark) {
                move = new Move(2, i);
                if (board.isValidMove(move))
                    return move;
            }
            if (check[0][i] == other_player_mark && check[2][i] == other_player_mark) {
                move = new Move(1, i);
                if (board.isValidMove(move))
                    return move;
            }
            if (check[1][i] == other_player_mark && check[2][i] == other_player_mark) {
                move = new Move(0, i);
                if (board.isValidMove(move))
                    return move;
            }
        }
        if (check[0][0] == other_player_mark && check[1][1] == other_player_mark) {
            move = new Move(2, 2);
            if (board.isValidMove(move))
                return move;
        }

    }
}
