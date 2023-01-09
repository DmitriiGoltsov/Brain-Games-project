package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.NUMBER_OF_ROUND;

public class Calc {

    private static String description = "What is the result of the expression?";
    static final int LOW_RANGE = 0;
    static final int HIGH_RANGE = 100;
    static final String[] OPERATORS = {"+", "-", "*"};

    public static void startCalcGame() {

        String[][] roundsData = new String[NUMBER_OF_ROUND][2];

        for (var i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
//            String[][] roundData = generateRoundData();
//            roundsData[i] = roundData[roundData.length - 1];
        }
        Engine.run(description, roundsData);
    }
    public static String[] generateRoundData() {

        int operand1 = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        int operand2 = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        int randomIndex = Utils.generateRandomNumber(OPERATORS.length);
        String chosenOperator = OPERATORS[randomIndex];
        String firstOperand = Integer.toString(operand1);
        String secondOperand = Integer.toString(operand2);
        String question = firstOperand + " " + chosenOperator + " " + secondOperand;
        String answer = Integer.toString(calculate(chosenOperator, operand1, operand2));

        return new String[] {question, answer};
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
