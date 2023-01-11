package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.NUMBER_OF_ROUND;

public class GCD {

    private static String description = "Find the greatest common divisor of given numbers.";
    static final int HIGH_RANGE = 100;
    static final int LOW_RANGE = 1;

    public static void startGCDGame() {
        String[][] roundsData = new String[NUMBER_OF_ROUND][2];

        for (var i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }
    public static String[] generateRoundData() {

        int operand1 = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        int operand2 = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);

        String question = operand1 + " " + operand2;
        String answer = Integer.toString(findGCD(operand1, operand2));

        return new String[] {question, answer};
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
