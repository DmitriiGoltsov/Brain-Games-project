package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import static hexlet.code.Engine.NUMBER_OF_ROUND;

public class Progression {

    private static String description = "What number is missing in the progression?";
    static final int HIGH_RANGE = 100;
    static final int LOW_RANGE = 1;
    static final int LENGTH_OF_PROGRESSION = 10;

    public static void startProgressionGame() {

        String[][] roundsData = new String[NUMBER_OF_ROUND][2];

        for (var i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(description, roundsData);
    }
    public static String[] generateProgressionAsString(int[] numbers) {
        String[] numsString = new String[numbers.length];
        for (var i = 0; i < numbers.length; i++) {
            for (var j = 0; j < numsString.length; j++) {
                numsString[j] = String.valueOf(numbers[i]);
                i++;
            }
        }

        return numsString;
    }
    public static int[] generateProgression(int commonDifference) {
        int[] numbers = new int[LENGTH_OF_PROGRESSION];
        numbers[0] = commonDifference;
        for (var i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + commonDifference;
        }
        return numbers;
    }

    public static String[] generateRoundData() {

        int commonDifference = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        int indexToHide = Utils.generateRandomNumber(LENGTH_OF_PROGRESSION);
        int[] numbers = generateProgression(commonDifference);
        String[] numbersAsString = generateProgressionAsString(numbers);
        numbersAsString[indexToHide] = "..";
        String question = String.join(" ", numbersAsString);
        String answer = Integer.toString(numbers[indexToHide]);

        return new String[] {question, answer};
    }
}
