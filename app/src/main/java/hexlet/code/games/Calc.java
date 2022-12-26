package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

public class Calc {
    public static void startCalcGame() {
        Engine.askName();
        System.out.println("What is the result of the expression?");

        final var numberOfRounds = 3;
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);

        for (var i = 0; i <= numberOfRounds; i++) {
            final int lowRange = 0;
            final int highRange = 100;

            // Initializing two different numbers as operands for our expressions
            int operand1 = generateRoundData(lowRange, highRange);
            int operand2 = generateRoundData(lowRange, highRange);

            int resultOfExpression = calculate(operand1, operand2);

            var playerAnswer = scanner.next();
            if (resultOfExpression == Integer.parseInt(playerAnswer)) {
                System.out.println("Your answer is: " + playerAnswer + "\nCorrect!");
                victoryCount += 1;
            } else {
                System.out.println(Engine.sendSadMessage(Integer.parseInt(playerAnswer), resultOfExpression));
                break;
            }
            if (victoryCount == numberOfRounds) {
                System.out.println(Engine.congratulate());
                break;
            }
        }
    }

    public static int generateRoundData(int lowRange, int highRange) {
        return Utils.generateRanNum(lowRange, highRange);
    }

    public static int calculate(int operand1, int operand2) {
        final String[] operators = {"+", "-", "*"};
        int randomIndex = Utils.generateRanNum(operators.length);
        int result;
        switch (operators[randomIndex]) {
            case "+" -> {
                result = operand1 + operand2;
                System.out.println("Question: " + operand1 + " + " + operand2);
                return result;
            }
            case "-" -> {
                result = operand1 - operand2;
                System.out.println("Question: " + operand1 + " - " + operand2);
                return result;
            }
            case "*" -> {
                result = operand1 * operand2;
                System.out.println("Question: " + operand1 + " * " + operand2);
                return result;
            }
        }
        return 0;
    }
}
