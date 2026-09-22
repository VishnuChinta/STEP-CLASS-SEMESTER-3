
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // Method to determine the winner of a round
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int n = 5;

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\nRound " + (i + 1));

            // Accept player input
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = scanner.nextLine();

            // Normalize the input
            playerMove = playerMove.trim();

            if (playerMove.equalsIgnoreCase("rock")) {
                playerMove = "Rock";
            } else if (playerMove.equalsIgnoreCase("paper")) {
                playerMove = "Paper";
            } else if (playerMove.equalsIgnoreCase("scissors")) {
                playerMove = "Scissors";
            } else {
                System.out.println("Invalid move! Try again.");
                i--;
                continue;
            }

            // Generate computer move randomly
            String computerMove = moves[random.nextInt(3)];

            // Determine result
            String result = playRound(playerMove, computerMove);

            // Store round details
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Computer Move: " + computerMove);
            System.out.println("Result: " + result);

            // Update counters
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Calculate win percentage
        double winPercentage = (wins * 100.0) / n;

        // Print summary table
        System.out.println("\n========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-15s %-18s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-15s %-15s %-18s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}