package Template;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame extends Game {
    private int numberToGuess;
    private int maxAttempts;
    private int[] attempts;
    private boolean gameWon; // Track if the game has been won
    private int winningPlayer; // Track the player who won

    @Override
    public void initializeGame(int numberOfPlayers) {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1; // Number between 1 and 100
        maxAttempts = 5; // Each player has 5 attempts
        attempts = new int[numberOfPlayers];
        gameWon = false; // Initialize gameWon to false
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("Players will guess a number between 1 and 100.");
    }

    @Override
    public boolean endOfGame() {
        // The game ends if a player has guessed correctly or if all players have exhausted their attempts
        if (gameWon) {
            return true; // Game won by someone
        }

        for (int attempt : attempts) {
            if (attempt < maxAttempts) {
                return false; // At least one player has remaining attempts
            }
        }
        return true; // All players have exhausted attempts
    }

    @Override
    public void playSingleTurn(int player) {
        if (gameWon) {
            return; // Exit if the game has already been won
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + (player + 1) + ", it's your turn! You have " + (maxAttempts - attempts[player]) + " attempts left.");
        
        // Player makes a guess
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();
        attempts[player]++;

        // Check the guess
        if (guess == numberToGuess) {
            System.out.println("Player " + (player + 1) + " guessed correctly!");
            gameWon = true; // Set gameWon to true
            winningPlayer = player; // Track the winning player
        } else if (guess < numberToGuess) {
            System.out.println("Too low! Try again.");
        } else {
            System.out.println("Too high! Try again.");
        }
    }

    @Override
    public void displayWinner() {
        if (gameWon) {
            System.out.println("Player " + (winningPlayer + 1) + " is the winner!"); // Declare the correct winner
        } else {
            System.out.println("No one guessed the number. The number was: " + numberToGuess);
        }
    }
}
