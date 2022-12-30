package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static void startEvenGame() {
        String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        final var numberOfRounds = 3;
        String[] data = new String[numberOfRounds];
        String[] correctAnswers = new String[numberOfRounds];

        for (var i = 0; i < numberOfRounds; i++) {
            int numberForGame = generateRoundData();
            data[i] = Integer.toString(numberForGame);
            if (isEven(numberForGame)) {
                correctAnswers[i] = "yes";
            } else {
                correctAnswers[i] = "no";
            }
        }
        Engine.run(description, data, correctAnswers);
    }
    public static int generateRoundData() {
        final int startOfRange = 0;
        final int endOfRange = 1000;
        return Utils.generateRandomNumber(startOfRange, endOfRange);
    }
    public static boolean isEven(int checkedNum) {
        return checkedNum % 2 == 0;
    }
}
