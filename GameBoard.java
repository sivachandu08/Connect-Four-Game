public class GameBoard {

    private final int ROWS = 6;
    private final int COLUMNS = 7;

    private char[][] board;

    public GameBoard() {

        board = new char[ROWS][COLUMNS];

        initializeBoard();
    }

    private void initializeBoard() {

        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLUMNS; j++) {

                board[i][j] = '.';
            }
        }
    }

    public void displayBoard() {

        System.out.println();

        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLUMNS; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();

        for (int i = 1; i <= COLUMNS; i++) {

            System.out.print(i + " ");
        }

        System.out.println("\n");
    }

    public boolean isColumnFull(int column) {

        return board[0][column] != '.';
    }

    public boolean dropDisc(int column, char symbol) {

        for (int row = ROWS - 1; row >= 0; row--) {

            if (board[row][column] == '.') {

                board[row][column] = symbol;

                return true;
            }
        }

        return false;
    }
    public boolean checkWinner(char symbol) {

        // Horizontal Check
        for (int row = 0; row < ROWS; row++) {

            for (int col = 0; col <= COLUMNS - 4; col++) {

                if (board[row][col] == symbol &&
                    board[row][col + 1] == symbol &&
                    board[row][col + 2] == symbol &&
                    board[row][col + 3] == symbol) {

                    return true;
                }
            }
        }

        // Vertical Check
        for (int row = 0; row <= ROWS - 4; row++) {

            for (int col = 0; col < COLUMNS; col++) {

                if (board[row][col] == symbol &&
                    board[row + 1][col] == symbol &&
                    board[row + 2][col] == symbol &&
                    board[row + 3][col] == symbol) {

                    return true;
                }
            }
        }

        // Left Diagonal Check
        for (int row = 0; row <= ROWS - 4; row++) {

            for (int col = 0; col <= COLUMNS - 4; col++) {

                if (board[row][col] == symbol &&
                    board[row + 1][col + 1] == symbol &&
                    board[row + 2][col + 2] == symbol &&
                    board[row + 3][col + 3] == symbol) {

                    return true;
                }
            }
        }

        // Right Diagonal Check
        for (int row = 0; row <= ROWS - 4; row++) {

            for (int col = 3; col < COLUMNS; col++) {

                if (board[row][col] == symbol &&
                    board[row + 1][col - 1] == symbol &&
                    board[row + 2][col - 2] == symbol &&
                    board[row + 3][col - 3] == symbol) {

                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBoardFull() {

        for (int col = 0; col < COLUMNS; col++) {

            if (board[0][col] == '.') {

                return false;
            }
        }

        return true;
    }

    public void resetBoard() {

        initializeBoard();
    }
}