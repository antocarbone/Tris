import java.util.Scanner;

public class Tris {

    public static void Main(String[] args) {
        while (playAgain()) {
            startNewGame();
        }
        System.out.println("\n\nGRAZIE PER AVER GIOCATO!\nARRIVEDERCI");
        return;
    }

    private static Player generateNewPlayer(char mark) {
        Scanner scanner = new Scanner(System.in);
        Player player;
        int sel;
        while (true) {
            System.out.println(
                    "\nInserisci 1 se player è umano altrimenti inserisci 0 se player deve essere il computer: ");
            sel = scanner.nextInt();
            if (sel != 0 && sel != 1)
                System.out.println("\nInput non valido!\nRiprova");
            else
                break;
        }
        scanner.close();
        if (sel == 1) {
            player = new HumanPlayer(mark);
            return player;
        } else {
            player = new ComputerPlayer(mark);
            return player;
        }
    }

    private static void startNewGame() {
        System.out.println("\nCREAZIONE PLAYER 1");
        Player player1 = generateNewPlayer('x');

        System.out.println("\nCREAZIONE PLAYER2");
        Player player2 = generateNewPlayer('o');

        Game partita = new Game(player1, player2);
        System.out.println("\nINIZIA IL PLAYER1");
        partita.play();
        return;
    }

    private static boolean playAgain() {
        int sel;
        System.out.println("\nIniziare una nuova partita? (1=si/0=no): ");
        Scanner scanner = new Scanner(System.in);
        sel = scanner.nextInt();
        scanner.close();
        if (sel == 1) {
            return true;
        } else if (sel == 0) {
            return false;
        }
        return false;
    }
}
