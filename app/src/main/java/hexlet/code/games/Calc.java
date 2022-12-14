package hexlet.code.games;

import java.util.Scanner;
import static hexlet.code.Engine.playerName;

public class Calc {
    public static void startCalcGame() {
        System.out.println("What is the result of the expression?");
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);

        for (var i = 0; i <= 4; i++) {
            // Initializing two different numbers as operands for our expressions
            int operand1 = (int) (0 + Math.random() * 100);
            int operand2 = (int) (0 + Math.random() * 100);

            // Create an array with the result of the different expressions (with different operators).
            int[] resultsOfExpressions = new int[3];
            resultsOfExpressions[0] = operand1 + operand2;
            resultsOfExpressions[1] = operand1 - operand2;
            resultsOfExpressions[2] = operand1 * operand2;

            /* Create an array with the same expressions as given above but as Strings.
            It is used to show expressions that should be resolved to the player.*/
            String[] expressionsAsStrings = new String[resultsOfExpressions.length];
            expressionsAsStrings[0] = operand1 + " + " + operand2;
            expressionsAsStrings[1] = operand1 + " - " + operand2;
            expressionsAsStrings[2] = operand1 + " * " + operand2;

            /* Create a random index within the bounds of the length of our arrays.
            It will be used to randomly choose an expression result and expression results as a String*/
            int bound = resultsOfExpressions.length;
            int randomIndex = (int) (0 + Math.random() * bound);

            /* Define what expression will be displayed and should be resolved by the player.
            Plus define a variable that will be use to check the answer*/
            int expressionResult = resultsOfExpressions[randomIndex];
            System.out.println(expressionsAsStrings[randomIndex]);

            var playerAnswer = scanner.next();
            if (expressionResult == Integer.parseInt(playerAnswer)) {
                System.out.println("Your answer is: " + playerAnswer + "\nCorrect!");
                victoryCount += 1;
                i++;
            } else {
                System.out.println(playerAnswer + " is wrong answer ;(. Correct answer was " + expressionResult
                        + "\nLet's try again, " + playerName);
                break;
            }
            if (victoryCount == 3) {
                System.out.println("Congratulations, " + playerName + "!");
                break;
            }
        }
    }
}
