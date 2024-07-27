import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int roundsPlayed = 0;
        int totalScore = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;
            
            System.out.println("Round " + (roundsPlayed + 1) + ":");
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ".");
            
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                }
                
                attemptsLeft--;
                
                if (!guessedCorrectly) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts. The number was: " + numberToGuess);
            }
            
            totalScore += (maxAttempts - attemptsLeft);
            roundsPlayed++;
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over!");
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Total score: " + totalScore);
        
        scanner.close();
    }
}
