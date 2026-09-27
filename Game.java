public class Game implements Playable {

    private GameBoard board;

    private HumanPlayer player1;
    private HumanPlayer player2;

    private FileManager fileManager;

    public Game(String firstPlayer, String secondPlayer) {

        board = new GameBoard();

        player1 = new HumanPlayer(firstPlayer, 'X');
        player2 = new HumanPlayer(secondPlayer, 'O');

        fileManager = new FileManager();
    }

    @Override
    public void startGame() {

        board.resetBoard();

        HumanPlayer currentPlayer = player1;

        System.out.println();
        System.out.println("====================================");
        System.out.println("          CONNECT FOUR");
        System.out.println("====================================");

        while (true) {

            board.displayBoard();

            int column = currentPlayer.makeMove(board);

            board.dropDisc(column, currentPlayer.getSymbol());

            if (board.checkWinner(currentPlayer.getSymbol())) {

                board.displayBoard();

                System.out.println();
                System.out.println("************************************");
                System.out.println(currentPlayer.getName() + " Wins the Game!");
                System.out.println("************************************");

                fileManager.saveMatch(
                        currentPlayer.getName(),
                        player1.getScore(),
                        player2.getScore());

                break;
            }

            if (board.isBoardFull()) {

                board.displayBoard();

                System.out.println();
                System.out.println("Game Draw!");

                fileManager.saveMatch(
                        "Draw",
                        player1.getScore(),
                        player2.getScore());

                break;
            }

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }
}