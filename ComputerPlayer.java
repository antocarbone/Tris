import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(char mark) {
        super(mark);
    }

    @Override
    public Move makeMove(Board board) {
        Random rand = new Random();
        Move move;
        char other_player_mark;

        if (super.mark == 'x')
            other_player_mark = 'o';
        else
            other_player_mark = 'x';

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                move = new Move(i, j);
                if (board.isValidMove(move) && board.isWinningMove(move, super.mark))
                    return move;
            }

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                move = new Move(i, j);
                if (board.isValidMove(move) && board.isWinningMove(move, other_player_mark))
                    return move;
            }

        do {
            move = new Move(rand.nextInt(3), rand.nextInt(3));
        } while (!board.isValidMove(move));

        return move;
    }
}
