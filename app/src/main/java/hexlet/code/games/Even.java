package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.getPlayerName;

public class Even {
    public static void startEvenGame() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var numberOfRounds = 3; // Player should win 3 times to achieve the complete victory.
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);

        for (var i = 0; i <= numberOfRounds; i++) {
            /* Establish high ens (limit) of the spectrum (diapason).
            The programme will create a random number whose evenness player should check in that diapason */
            int highEndOfSpectrum = 1000;

            int number = (int) (Math.random() * highEndOfSpectrum);
            System.out.println("Question: " + number);
            var playerAnswer = scanner.next().toLowerCase();
            if (number % 2 == 0 && playerAnswer.equals("yes")) {
                System.out.println("Your answer: " + playerAnswer);
                System.out.println("Correct!");
                victoryCount += 1;
                if (victoryCount == 3) {
                    System.out.println("Congratulations, " + getPlayerName() + "!");
                    break;
                }
            } else if (number % 2 != 0 && playerAnswer.equals("no")) {
                System.out.println("Your answer: " + playerAnswer);
                System.out.println("Correct!");
                victoryCount += 1;
                if (victoryCount == 3) {
                    System.out.println("Congratulations, " + getPlayerName() + "!");
                    break;
                }
            } else if (number % 2 == 0 && playerAnswer.equals("no")) {
                System.out.println("Your answer: " + playerAnswer);

                System.out.println("'" + playerAnswer + "'" + " is wrong answer ;(. Correct answer was 'yes'."
                        + "\nLet's try again, " + getPlayerName() + "!");
                break;
            } else if (number % 2 != 0 && playerAnswer.equals("yes")) {
                System.out.println("Your answer: " + playerAnswer);

                System.out.println("'" + playerAnswer + "'" + " is wrong answer ;(. Correct answer was 'no'."
                        + "\nLet's try again, " + getPlayerName() + "!");
                break;
            } else {
                System.out.println("Your answer: " + playerAnswer);
                System.out.println("Wrong input");
                break;
            }
        }
    }
}
