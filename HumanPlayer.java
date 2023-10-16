import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayer extends Player {
    private static Scanner scanner;

    public HumanPlayer(char mark) {
        super(mark);
    }

    @Override
    public Move makeMove(Board board) {
        Scanner humanInput = new Scanner(System.in);
        int row = 0, col = 0;
        try {
            System.out.println("\nEnter a row: ");
            row = humanInput.nextInt();
            System.out.println("\nInsert row is: " + row);
            System.out.println("\nEnter a column: ");
            col = humanInput.nextInt();
            System.out.println("\nInsert row is: " + col);
        } catch (InputMismatchException e) {
            System.out.println("\nValori inseriti non validi");
        }

        Move humanMove = new Move(row, col);
        if (board.isValidMove(humanMove))
            return humanMove;
        else {
            System.out.println("\nMossa non valida!");
            return null;
        }

    }
}
