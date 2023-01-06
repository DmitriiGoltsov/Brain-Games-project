package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.getNumberofquestionsandanswers;
import static hexlet.code.Engine.getNumberOfRound;
import static hexlet.code.Engine.getNumberOfRoundsToGenerateFor;

public class Calc {

    private static String description = "What is the result of the expression?";
    static final int LOWRANGE = 0;
    static final int HIGHRANGE = 100;
    static final String[] OPERATORS = {"+", "-", "*"};
    public static void startCalcGame() {

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
        int operand2 = Utils.generateRandomNumber(LOWRANGE, HIGHRANGE);
        int randomIndex = Utils.generateRandomNumber(OPERATORS.length);
        String chosenOperator = OPERATORS[randomIndex];
        String firstOperand = Integer.toString(operand1);
        String secondOperand = Integer.toString(operand2);
        roundData[0][0] = firstOperand + " " + chosenOperator + " " + secondOperand;
        roundData[0][1] = Integer.toString(calculate(chosenOperator, operand1, operand2));
        return roundData;
    }

    public static int calculate(String operator, int operand1, int operand2) {
        int result;
        switch (operator) {
            case "+" -> {
                result = operand1 + operand2;
                return result;
            }
            case "-" -> {
                result = operand1 - operand2;
                return result;
            }
            case "*" -> {
                result = operand1 * operand2;
                return result;
            }
            default -> {
                result = 0;
                return result;
            }
        }
    }
}
