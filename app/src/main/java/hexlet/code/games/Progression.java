package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.StringJoiner;
import static hexlet.code.Engine.getNumberofquestionsandanswers;
import static hexlet.code.Engine.getNumberOfRound;
import static hexlet.code.Engine.getNumberOfRoundsToGenerateFor;

public class Progression {

    private static String description = "What number is missing in the progression?";
    static final int HIGHRANGE = 100;
    static final int LOWRANGE = 1;
    static final int LENGTHOFPROGRESSION = 10;

    public static void startProgressionGame() {

        String[][] roundsData = new String[getNumberOfRound()][getNumberofquestionsandanswers()];

        for (var i = 0; i < roundsData.length; i++) {
            roundsData[i] = generateRoundData()[0];
        }
        Engine.run(description, roundsData);
    }
    public static String generateProgressionAsString(int[] numbers, int indexToHide) {
        String[] numsString = new String[numbers.length];
        for (var i = 0; i < numbers.length; i++) {
            for (var j = 0; j < numsString.length; j++) {
                numsString[j] = String.valueOf(numbers[i]);
                i++;
            }
        }
        numsString[indexToHide] = "..";
        var result = new StringJoiner(" ");
        for (var numString : numsString) {
            result.add(numString);
        }
        return result.toString();
    }
    public static int[] generateProgression(int commonDifference) {
        int[] numbers = new int[LENGTHOFPROGRESSION];
        numbers[0] = commonDifference;
        for (var i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + commonDifference;
        }
        return numbers;
    }

    public static String[][] generateRoundData() {
        String[][] roundData = new String[getNumberOfRoundsToGenerateFor()][getNumberofquestionsandanswers()];
        int commonDifference = Utils.generateRandomNumber(LOWRANGE, HIGHRANGE);
        int indexToHide = Utils.generateRandomNumber(LENGTHOFPROGRESSION);
        int[] numbers = generateProgression(commonDifference);
        String numbersAsString = generateProgressionAsString(numbers, indexToHide);
        roundData[0][0] = numbersAsString;
        roundData[0][1] = Integer.toString(numbers[indexToHide]);

        return roundData;
    }
}
