import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private static final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int makeMove(GameBoard board) {

        while (true) {

            try {

                System.out.print(getName() + " (" + getSymbol() + ") Enter Column (1-7): ");

                int column = scanner.nextInt();

                if (column < 1 || column > 7) {

                    System.out.println("Invalid column! Please enter a value between 1 and 7.");
                    continue;
                }

                if (board.isColumnFull(column - 1)) {

                    System.out.println("Column is full! Choose another column.");
                    continue;
                }

                return column - 1;

            } catch (InputMismatchException e) {

                System.out.println("Invalid input! Please enter numbers only.");
                scanner.nextLine();
            }
        }
    }
}