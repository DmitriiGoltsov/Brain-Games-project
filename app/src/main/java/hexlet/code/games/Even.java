package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Scanner;

public class Even {
    public static void startEvenGame() {
        Engine.askName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        final var numberOfRounds = 3; // Player has to win 3 times to achieve the complete victory.
        var victoryCount = 0;

        for (var i = 0; i <= numberOfRounds; i++) {
            Scanner scanner = new Scanner(System.in);
            final int startOfRange = 0;
            final int endOfRange = 1000;
            int numberForGame = generateRoundDate(startOfRange, endOfRange);

            System.out.println("Question: " + numberForGame);
            var playerAnswer = scanner.next();
            if (isEven(numberForGame, playerAnswer)) {
                System.out.println("Your answer: " + playerAnswer + "\nCorrect!");
                victoryCount += 1;
                if (victoryCount == numberOfRounds) {
                    System.out.println(Engine.congratulate());
                    break;
                }
            } else {
                System.out.println(Engine.sendSadMessage(playerAnswer));
                break;
            }
        }
    }

    public static int generateRoundDate(int lowRange, int highRange) {
        return Utils.generateRanNum(lowRange, highRange);
    }

    public static boolean isEven(int checkedNum, String checkedAnswer) {
        if (checkedNum % 2 == 0 && checkedAnswer.equals("yes")) {
            return true;
        } else if (checkedNum % 2 != 0 && checkedAnswer.equals("no")) {
            return true;
        }
        return false;
    }
}