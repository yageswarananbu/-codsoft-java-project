import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1; // Minimum value for the range
        int maxRange = 100; // Maximum value for the range
        int attemptsLimit = 5; // Limit of attempts per round
        int rounds = 0; // Count of rounds played
        int totalAttempts = 0; // Total attempts across all rounds
        boolean playAgain = true; // Flag to control multiple rounds

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0; // Attempts for the current round
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (rounds + 1) + ": Guess a number between " + minRange + " and " + maxRange);

            while (!guessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Attempt " + (attempts + 1) + "/" + attemptsLimit + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " correctly.");
                    guessedCorrectly = true;
                }

                attempts++;
                totalAttempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + generatedNumber);
            }

            rounds++;

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame over! You played " + rounds + " round(s) with a total of " + totalAttempts + " attempt(s).");

        scanner.close();
    }
}
