// Gabriella S Maria
// Lab 1: Guessing Game
// 04/14/2023
// CS 145

// Import the Scanner class from the java.util package
// This class is used to read input from various sources such as keyboard input
import java.util.Scanner;

// Declare the GuessingGame class
public class GuessingGame {

    // The main method, the starting point of the Java application
    public static void main(String[] args) {
        // Create a new Scanner object to read input from the console
        Scanner in = new Scanner(System.in);

        // Declare and initialize variables to keep track of game statistics
        int games = 1, // Number of games played
            guesses = 0, // Total number of guesses made
            max = 0, // Maximum number of guesses in a single game
            count; // Number of guesses in the current game

        // Main game loop, continues until the player decides to quit
        while (true) {
            // Generate a random number between 1 and 100 (inclusive)
            int number = 1 + (int) (Math.random() * (99 + 1));
            count = 0; // Reset the current game's guess count

            // Loop for player's guesses in the current game
            while (true) {
                // Prompt the player to enter a guess
                System.out.print("I'm thinking of a number between 1 and 100...");
                int guess = in.nextInt(); // Read the player's guess from the console
                count++; // Increment the current game's guess count

                // Check if the player's guess is lower, higher, or equal to the target number
                if (guess < number) {
                    System.out.println("higher");
                } else if (guess > number) {
                    System.out.println("lower");
                } else {
                    System.out.println("You got it right in " + count + " guesses");
                    break; // Exit the current game's guess loop
                }
            }

            // Update overall game statistics
            guesses += count; // Add the current game's guess count to the total

            // Check if the current game's guess count is greater than the maximum guess count
            if (count > max) {
                max = count; // Update the maximum guess count
            }

            // Read and discard the remaining newline character
            in.nextLine();

            // Prompt the player to play again
            System.out.print("Do you want to play again? ");
            String choice = in.nextLine().toLowerCase(); // Read and convert the player's response to lowercase

            // Check if the player wants to play another game
            if (!choice.equals("yes i'm thinking of a number...")) {
                break; // Exit the main game loop
            }

            // Increment the number of games played
            games++;
        }

        // Display the overall game results
        System.out.println("Overall results:");
        System.out.println("total games = " + games);
        System.out.println("total guesses = " + guesses);
        System.out.println("guesses/game = " + guesses / games);
        System.out.println("max guesses = " + max);
    }
}