import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int round = 1;
        char playAgain;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {

            int randomNumber = random.nextInt(100) + 1;
            int attempts = 10;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("---------------------------");
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have only " + attempts + " attempts.");

            for (int i = 1; i <= attempts; i++) {

                System.out.print("Attempt " + i + ": Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == randomNumber) {

                    System.out.println("Congratulations! You guessed the correct number.");

                    int score = (attempts - i + 1) * 10;
                    totalScore += score;

                    System.out.println("You earned " + score + " points.");
                    guessed = true;
                    break;

                } else if (guess < randomNumber) {

                    System.out.println("Too Low! Try a higher number.");

                } else {

                    System.out.println("Too High! Try a lower number.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry! You have used all attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Current Total Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

            round++;

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n=================================");
        System.out.println("Game Over!");
        System.out.println("Rounds Played : " + (round - 1));
        System.out.println("Final Score   : " + totalScore);
        System.out.println("Thank you for playing!");
        System.out.println("=================================");

        sc.close();
    }
}