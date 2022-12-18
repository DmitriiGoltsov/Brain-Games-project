package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.Engine.getPlayerName;

public class GCD {
    public static void findGCD() {
        System.out.println("Find the greatest common divisor of given numbers.");
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);
        final var numberOfRounds = 3;

        for (var i = 0; i <= numberOfRounds; i++) {
            final int highEndOfSpectrum = 100;
            final int lowEndOfSpectrum = 1; /* the low end is needed to prevent situations
            where player has to find GCD and one operand is zero. */

            // Initializing two given numbers whose GCD should be found.
            int operand1 = (int) (lowEndOfSpectrum + Math.random() * highEndOfSpectrum);
            int operand2 = (int) (lowEndOfSpectrum + Math.random() * highEndOfSpectrum);
            System.out.println("Question: " + operand1 + " " + operand2);

            int length;
            if (operand1 > operand2) {
                length = operand1;
            } else {
                length = operand2;
            }

            int gCD = 1;
            for (var i2 = 1; i2 <= length; i2++) {
                if (operand1 % i2 == 0 && operand2 % i2 == 0) {
                    gCD = i2;
                }
            }
            var playerAnswer = scanner.next();
            if (gCD == Integer.parseInt(playerAnswer)) {
                System.out.println("Your answer is: " + playerAnswer + "\nCorrect!");
                victoryCount += 1;
            }
            if (gCD != Integer.parseInt(playerAnswer)) {
                System.out.println("Your answer: " + playerAnswer);
                System.out.println(playerAnswer + " is wrong answer ;(. Correct answer was " + gCD
                        + "\nLet's try again, " + getPlayerName() + "!");
                break;
            }
            if (victoryCount == numberOfRounds) {
                System.out.println("Congratulations, " + getPlayerName() + "!");
                break;
            }
        }
    }
}


