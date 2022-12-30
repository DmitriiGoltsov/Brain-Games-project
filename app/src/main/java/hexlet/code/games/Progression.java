package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.StringJoiner;

public class Progression {
    public static void startProgressionGame() {
        String description = "What number is missing in the progression?";
        final var numberOfRounds = 3;
        String[] data = new String[numberOfRounds];
        int[] correctAnswers = new int[numberOfRounds];

        for (var i = 0; i < numberOfRounds; i++) {
            var commonDifference = createCommonDifference();
            int[] numbers = generateProgression(commonDifference);
            var indexToHide = Utils.generateRandomNumber(numbers.length);
            String numbersToShow = generateProgressionAsString(numbers, indexToHide);
            data[i] = numbersToShow;
            correctAnswers[i] = numbers[indexToHide];
        }
        Engine.run(description, data, correctAnswers);
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
        final var lengthOfProgression = 10;
        int[] numbers = new int[lengthOfProgression];
        numbers[0] = commonDifference;
        for (var i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + commonDifference;
        }
        return numbers;
    }
    public static int createCommonDifference() {
        final int highRange = 100;
        final int lowRange = 1;
        return Utils.generateRandomNumber(lowRange, highRange);
    }
}
