package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.getNumberofquestionsandanswers;
import static hexlet.code.Engine.getNumberOfRound;
import static hexlet.code.Engine.getNumberOfRoundsToGenerateFor;

public class Even {

    private static String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static final int LOWRANGE = 0;
    static final int HIGHRANGE = 1000;

    public static void startEvenGame() {
        String[][] roundsData = new String[getNumberOfRound()][getNumberofquestionsandanswers()];

        for (var i = 0; i < roundsData.length; i++) {
            String[][] roundData = generateRoundData();
            roundsData[i] = roundData[roundData.length - 1];
        }

        Engine.run(description, roundsData);
    }
    public static String[][] generateRoundData() {
        int numberForGame = Utils.generateRandomNumber(LOWRANGE, HIGHRANGE);
        String[][] roundData = new String[getNumberOfRoundsToGenerateFor()][getNumberofquestionsandanswers()];
        roundData[0][0] = Integer.toString(numberForGame);
        roundData[0][1] = isEven(numberForGame) ? "yes" : "no";

        return roundData;
    }

    public static boolean isEven(int checkedNum) {
        return checkedNum % 2 == 0;
    }
}
