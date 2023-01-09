package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.NUMBER_OF_ROUND;

public class Even {

    private static String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int LOW_RANGE = 0;
    static final int HIGH_RANGE = 1000;

    public static void startEvenGame() {
        String[][] roundsData = new String[NUMBER_OF_ROUND][2];

        for (var i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(description, roundsData);
    }
    public static String[] generateRoundData() {
        int numberForGame = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        String[][] roundData = new String[1][2];
        String question = Integer.toString(numberForGame);
        String answer = isEven(numberForGame) ? "yes" : "no";

        return new String[] {question, answer};
    }

    public static boolean isEven(int checkedNum) {
        return checkedNum % 2 == 0;
    }
}
