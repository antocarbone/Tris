import java.util.Scanner;

public class Tris {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (playAgain(scanner)) {
            startNewGame(scanner);
        }
        System.out.println("\n\nGRAZIE PER AVER GIOCATO!\nARRIVEDERCI");
        return;
    }

    private static Player generateNewPlayer(char mark, Scanner scanner) {
        Player player;
        int s;

        while (true) {
            System.out.println("\nInserisci 1 (giocatore umano) o 0 (cpu) : ");
            s = scanner.nextInt();
            if (s != 0 && s != 1)
                System.out.println("\nInput non valido!\nRiprova");
            else
                break;
        }
        if (s == 1) {
            player = new HumanPlayer(mark);
            return player;
        } else {
            player = new ComputerPlayer(mark);
            return player;
        }
    }

    private static void startNewGame(Scanner scanner) {
        System.out.println("\nCREAZIONE PLAYER 1");
        Player player1 = generateNewPlayer('x', scanner);

        System.out.println("\nCREAZIONE PLAYER2");
        Player player2 = generateNewPlayer('o', scanner);

        Game partita = new Game(player1, player2);
        System.out.println("\nINIZIA IL PLAYER1");
        partita.play();
        return;
    }

    private static boolean playAgain(Scanner scanner) {
        int sel;
        System.out.println("\nIniziare una nuova partita? (1=si/0=no): ");
        sel = scanner.nextInt();
        if (sel == 1) {
            return true;
        } else if (sel == 0) {
            return false;
        }
        return false;
    }
}
