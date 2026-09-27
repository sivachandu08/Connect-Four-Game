import java.util.Random;

public class ComputerPlayer extends Player {

    private Random random;

    public ComputerPlayer(char symbol) {
        super("Computer", symbol);
        random = new Random();
    }

    @Override
    public int makeMove(GameBoard board) {

        int column;

        do {

            column = random.nextInt(7);

        } while (board.isColumnFull(column));

        System.out.println("Computer selected column : " + (column + 1));

        return column;
    }
}