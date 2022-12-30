package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static void startCalcGame() {
        String description = "What is the result of the expression?";
        final var numberOfRounds = 3;

        String[] data = new String[numberOfRounds];
        int[] correctAnswers = new int[numberOfRounds];

        for (var i = 0; i < numberOfRounds; i++) {
            int operand1 = generateRoundData();
            int operand2 = generateRoundData();
            String operator = chooseRandomOperator();
            correctAnswers[i] = calculate(operator, operand1, operand2);
            String firstOperand = Integer.toString(operand1);
            String secondOperand = Integer.toString(operand2);
            data[i] = firstOperand + " " + operator + " " + secondOperand;
        }
        Engine.run(description, data, correctAnswers);
    }
    public static int generateRoundData() {
        final int lowRange = 0;
        final int highRange = 100;
        return Utils.generateRandomNumber(lowRange, highRange);
    }
    public static String chooseRandomOperator() {
        final String[] operators = {"+", "-", "*"};
        int randomIndex = Utils.generateRandomNumber(operators.length);
        return operators[randomIndex];
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
