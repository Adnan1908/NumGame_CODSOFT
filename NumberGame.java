import java.util.*;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rdn = new Random();

        int lowRng = 1;
        int upperRng = 100;
        int secretNumber = rdn.nextInt(upperRng - lowRng + 1) + lowRng;

        int round = 0;
        int totalAttempts = 0;

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Round: " + (round + 1));
            int attempts = playGame(sc, secretNumber, lowRng, upperRng);
            totalAttempts += attempts;
            round++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playInput = sc.next();
            playAgain = playInput.equalsIgnoreCase("yes");
        }

        System.out.println("Game over!");
        System.out.println("Total rounds played: " + round);
        System.out.println("Total attempts: " + totalAttempts);
        double averageAttemptsPerRound = round > 0 ? (double) totalAttempts / round : 0;
        System.out.println("Average attempts per round: " + averageAttemptsPerRound);

        sc.close();
    }

    public static int playGame(Scanner scanner, int secretNumber, int lowerRange, int upperRange) {
        int attempts = 0;

        while (true) {
            System.out.print("Guess the number between " + lowerRange + " and " + upperRange + ": ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations You guessed the number " + secretNumber + " in " + attempts + " attempts.");
                return attempts;
            }
        }
    }
}

