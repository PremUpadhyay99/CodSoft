package CodSoft;

import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 50;
        int attemptsLimit = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (true) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a number within the valid range.");
                } else if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + secretNumber);
                    System.out.println("Attempts: " + attempts);
                    score += attempts;
                    rounds++;

                    break;
                } else if (attempts >= attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was: " + secretNumber);
                    rounds++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Game Over!");
                System.out.println("Rounds played: " + rounds);
                System.out.println("Total Score: " + score);
                break;
            }
        }

        scanner.close();
    }
}

