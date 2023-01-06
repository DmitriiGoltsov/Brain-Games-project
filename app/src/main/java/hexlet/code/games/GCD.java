package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.getNumberofquestionsandanswers;
import static hexlet.code.Engine.getNumberOfRound;
import static hexlet.code.Engine.getNumberOfRoundsToGenerateFor;

public class GCD {

    private static String description = "Find the greatest common divisor of given numbers.";
    static final int HIGHRANGE = 100;
    static final int LOWRANGE = 1;

    public static void startGCDGame() {
        String[][] roundsData = new String[getNumberOfRound()][getNumberofquestionsandanswers()];

        for (var i = 0; i < roundsData.length; i++) {
            String[][] roundData = generateRoundData();
            roundsData[i] = roundData[roundData.length - 1];
        }
        Engine.run(description, roundsData);
    }
    public static String[][] generateRoundData() {
        String[][] roundData = new String[getNumberOfRoundsToGenerateFor()][getNumberofquestionsandanswers()];

        int operand1 = Utils.generateRandomNumber(LOWRANGE, HIGHRANGE);
        String operand1AsString = Integer.toString(operand1);
        int operand2 = Utils.generateRandomNumber(LOWRANGE, HIGHRANGE);
        String operand2AsString = Integer.toString(operand2);

        roundData[0][0] = operand1AsString + " " + operand2AsString;
        roundData[0][1] = Integer.toString(findGCD(operand1, operand2));

        return roundData;
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
