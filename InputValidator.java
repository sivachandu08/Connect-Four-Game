import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    private Scanner scanner;

    public InputValidator() {
        scanner = new Scanner(System.in);
    }

    public int getValidColumn(GameBoard board) {

        while (true) {

            try {

                System.out.print("Enter Column (1-7): ");

                int column = scanner.nextInt();

                if (column < 1 || column > 7) {
                    System.out.println("Please enter a value between 1 and 7.");
                    continue;
                }

                if (board.isColumnFull(column - 1)) {
                    System.out.println("This column is full. Choose another.");
                    continue;
                }

                return column - 1;

            } catch (InputMismatchException e) {

                System.out.println("Invalid input! Numbers only.");
                scanner.nextLine();
            }
        }
    }

    public int getValidColumn(GameBoard board, String playerName) {

        while (true) {

            try {

                System.out.print(playerName + ", Enter Column (1-7): ");

                int column = scanner.nextInt();

                if (column < 1 || column > 7) {
                    System.out.println("Please enter a value between 1 and 7.");
                    continue;
                }

                if (board.isColumnFull(column - 1)) {
                    System.out.println("This column is full. Choose another.");
                    continue;
                }

                return column - 1;

            } catch (InputMismatchException e) {

                System.out.println("Invalid input! Numbers only.");
                scanner.nextLine();
            }
        }
    }
}