import java.util.Scanner;

public class ConnectFour {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("       CONNECT FOUR GAME");
        System.out.println("========================================");

        boolean playAgain = true;

        while (playAgain) {

            System.out.print("Enter Player 1 Name (X): ");
            String player1 = scanner.nextLine();

            System.out.print("Enter Player 2 Name (O): ");
            String player2 = scanner.nextLine();

            Game game = new Game(player1, player2);

            game.startGame();

            System.out.print("\nDo you want to play again? (Y/N): ");
            String choice = scanner.nextLine();

            playAgain = choice.equalsIgnoreCase("Y");

            System.out.println();
        }

        System.out.println("========================================");
        System.out.println("      Thank You For Playing");
        System.out.println("========================================");

        scanner.close();
    }
}