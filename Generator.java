import java.util.Random;
import java.util.Scanner;


public class Generator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_CHANCES = 10;

    int generate() {
        Random randomNum = new Random();
        return randomNum.nextInt(MIN_NUMBER, MAX_NUMBER+1);
    }

    void playGame() {
        int result = generate();
        int guess = -1;
        int chances = MAX_CHANCES;

        System.out.println("Guess a number between " + MIN_NUMBER + " to " + MAX_NUMBER + " : ");

        while (result != guess && chances > 0) {
            Scanner input = new Scanner(System.in);
            guess = input.nextInt();

            if (guess == result) {
                System.out.println("Congrats, you guessed the correct number! You won the game.");
                System.out.println("You scored " + chances + " points out of " + MAX_CHANCES);
            } else if (guess < result) {
                chances--;
                System.out.print("Please guess higher: ");
            } else {
                chances--;
                System.out.print("Please guess lower: ");
            }
        }

        if (chances == 0) {
            System.out.println("You failed to guess the number. You lose the game.");
            System.out.println("The correct guess was " + result);
        }
    }

    public static void main(String[] args) {
        Scanner playAgainScanner = new Scanner(System.in);
        char playAgain;

        do {
            System.out.println("The Number Guessing Game has Started :");
            Generator numberGenerator = new Generator();
            numberGenerator.playGame();

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = playAgainScanner.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("Thanks for playing!");
        playAgainScanner.close();
    }
}
