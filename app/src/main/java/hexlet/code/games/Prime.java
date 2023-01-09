package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.NUMBER_OF_ROUND;

public class Prime {

    private static String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static final int LOW_RANGE = 2;
    static final int HIGH_RANGE = 100;

    public static void startPrimeGame() {

        String[][] roundsData = new String[NUMBER_OF_ROUND][2];

        for (var i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }
    public static String[] generateRoundData() {

        int number = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        String question = Integer.toString(number);
        String answer = isPrime(number) ? "yes" : "no";
        return new String[] {question, answer};
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
