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

    public static String[] generateProgression(int firstNumber, int commonDifference, int lengthOfProgression) {
        int[] numbers = new int[lengthOfProgression];
        numbers[0] = firstNumber;
        for (var i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + commonDifference;
        }
        String[] numbersAsString = new String[numbers.length];
        for (var i = 0; i < numbers.length; i++) {
            for (var j = 0; j < numbersAsString.length; j++) {
                numbersAsString[j] = String.valueOf(numbers[i]);
                i++;
            }
        }
        return numbersAsString;
    }

    public static String[] generateRoundData() {

        int firstNumber = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        int commonDifference = Utils.generateRandomNumber(LOW_RANGE, HIGH_RANGE);
        int indexToHide = Utils.generateRandomNumber(LENGTH_OF_PROGRESSION);
        String[] progression = generateProgression(firstNumber, commonDifference, LENGTH_OF_PROGRESSION);
        String answer = progression[indexToHide];
        progression[indexToHide] = "..";
        String question = String.join(" ", progression);


        return new String[] {question, answer};
    }
}
