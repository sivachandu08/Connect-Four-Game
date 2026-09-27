import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileManager {

    private static final String FILE_NAME = "MatchHistory.txt";

    public void saveMatch(String winner, int player1Score, int player2Score) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write("====================================");
            writer.newLine();

            writer.write("Date : " + LocalDateTime.now());
            writer.newLine();

            writer.write("Winner : " + winner);
            writer.newLine();

            writer.write("Player 1 Score : " + player1Score);
            writer.newLine();

            writer.write("Player 2 Score : " + player2Score);
            writer.newLine();

            writer.write("====================================");
            writer.newLine();
            writer.newLine();

        } catch (IOException e) {

            System.out.println("Unable to save match history.");
        }
    }
}