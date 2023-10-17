import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayer extends Player {
    private static Scanner scanner = new Scanner(System.in);

    public HumanPlayer(char mark) {
        super(mark);
    }

    @Override
    public Move makeMove(Board board) {
        int row = 0, col = 0;
        while (true) {
            try {
                System.out.println("\nEnter a row: ");
                row = scanner.nextInt();
                System.out.println("\nInsert row is: " + row);

                System.out.println("\nEnter a column: ");
                col = scanner.nextInt();
                System.out.println("\nInsert row is: " + col);

            } catch (InputMismatchException e) {
                System.out.println("\nValori inseriti non validi");
            }
            Move humanMove = new Move(row, col);
            if (board.isValidMove(humanMove)) {
                return humanMove;
            } else {
                System.out.println("\nMossa non valida!");
            }
        }
    }
}
