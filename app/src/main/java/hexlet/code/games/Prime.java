package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.getNumberofquestionsandanswers;
import static hexlet.code.Engine.getNumberOfRound;
import static hexlet.code.Engine.getNumberOfRoundsToGenerateFor;

public class Prime {

    private static String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int LOWRANGE = 2;
    static final int HIGHRANGE = 100;

    public static void startPrimeGame() {

        String[][] roundsData = new String[getNumberOfRound()][getNumberofquestionsandanswers()];

        for (var i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData()[0];
        }
        Engine.run(description, roundsData);
    }
    public static String[][] generateRoundData() {
        String[][] roundData = new String[getNumberOfRoundsToGenerateFor()][getNumberofquestionsandanswers()];
        int number = Utils.generateRandomNumber(LOWRANGE, HIGHRANGE);
        roundData[0][0] = Integer.toString(number);
        roundData[0][1] = isPrime(number) ? "yes" : "no";
        return roundData;
    }
    public static boolean isPrime(int number) {
        final int numberOfPrimeDivisors = 2;
        var count = 0;
        for (var i = 1; i <= number; i++) {
            var tempCheck = number % i;
            if (tempCheck == 0) {
                count++;
                if (count > numberOfPrimeDivisors) {
                    return false;
                }
            }
        }
        return true;
    }
}
