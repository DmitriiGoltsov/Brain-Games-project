package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Scanner;

public class GCD {

    public static void startGCDGame() {
        Engine.askName();
        System.out.println("Find the greatest common divisor of given numbers.");
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);
        final var numberOfRounds = 3;
        final int highRange = 100;
        final int lowRange = 1;

        for (var i = 0; i <= numberOfRounds; i++) {
            // Initializing two given numbers whose GCD should be found.
            int operand1 = generateRoundData(lowRange, highRange);
            int operand2 = generateRoundData(lowRange, highRange);
            System.out.println("Question: " + operand1 + " " + operand2);

            int gCD = findGCD(operand1, operand2);
            int playerAnswer = Integer.parseInt(scanner.next());
            if (isGCD(gCD, playerAnswer)) {
                System.out.println("Your answer is: " + playerAnswer + "\nCorrect!");
                victoryCount += 1;
                if (victoryCount == numberOfRounds) {
                    System.out.println(Engine.congratulate());
                    break;
                }
            } else {
                System.out.println(Engine.sendSadMessage(playerAnswer, gCD));
                break;
            }
        }
    }

    public static int generateRoundData(int lowRange, int highRange) {
        return Utils.generateRanNum(lowRange, highRange);
    }

    public static int findGCD(int operand1, int operand2) {
        int length = Math.max(operand1, operand2);

        int gCD = 1;
        for (var i2 = 1; i2 <= length; i2++) {
            if (operand1 % i2 == 0 && operand2 % i2 == 0) {
                gCD = i2;
            }
        } return gCD;
    }

    public static boolean isGCD(int gCD, int playerAnswer) {
        return gCD == playerAnswer;
    }
}