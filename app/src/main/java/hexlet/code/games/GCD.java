package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static void startGCDGame() {
        String description = "Find the greatest common divisor of given numbers.";
        final var numberOfRounds = 3;
        String[] data = new String[numberOfRounds];
        int[] correctAnswers = new int[numberOfRounds];

        for (var i = 0; i < numberOfRounds; i++) {
            int operand1 = generateRoundData();
            String operand1AsString = Integer.toString(operand1);
            int operand2 = generateRoundData();
            String operand2AsString = Integer.toString(operand2);
            int gCD = findGCD(operand1, operand2);
            correctAnswers[i] = gCD;
            data[i] =  operand1AsString + " " + operand2AsString;
        }
        Engine.run(description, data, correctAnswers);
    }
    public static int generateRoundData() {
        final int highRange = 100;
        final int lowRange = 1;
        return Utils.generateRandomNumber(lowRange, highRange);
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
}
