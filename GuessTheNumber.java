import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly && maxAttempts > 0) {
            String input = JOptionPane.showInputDialog(null,
                    "Guess the number between " + minRange + " and " + maxRange + ":");
            int guess = Integer.parseInt(input);
            maxAttempts--;

            if (guess == randomNumber) {
                hasGuessedCorrectly = true;
                score += maxAttempts + 1;
                JOptionPane.showMessageDialog(null,
                        "Congratulations! You guessed the correct number. Your score: " + score);
            } else if (guess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Guess a higher number. Attempts left: " + maxAttempts);
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Guess a lower number. Attempts left: " + maxAttempts);
            }
        }

        if (!hasGuessedCorrectly) {
            JOptionPane.showMessageDialog(null, "Game over! The number was: " + randomNumber);
        }
    }
}
