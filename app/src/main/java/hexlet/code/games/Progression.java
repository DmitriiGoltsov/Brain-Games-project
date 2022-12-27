package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Scanner;
import java.util.StringJoiner;

public class Progression {

    public static void startProgressionGame() {
        Engine.askName();
        final var numberOfRounds = 3;
        final int highRange = 100;
        final int lowRange = 1;

        var victoryCount = 0;
        for (var j = 0; j <= numberOfRounds; j++) {

            var commonDifference = Utils.generateRanNum(lowRange, highRange);
            int[] numbers = generateProgression(commonDifference);
            var indexToHide = Utils.generateRanNum(numbers.length);
            var correctAnswer = numbers[indexToHide];

            System.out.println("What number is missing in the progression?");
            String numbersToShow = generateProgString(numbers, indexToHide);
            System.out.println("Question: " + numbersToShow);

            Scanner scanner = new Scanner(System.in);
            var playerAnswer = scanner.next();
            if (numbers[indexToHide] == Integer.parseInt(playerAnswer)) {
                System.out.println("Your answer: " + playerAnswer + "\nCorrect!");
                victoryCount += 1;
            }
            if (numbers[indexToHide] != Integer.parseInt(playerAnswer)) {
                System.out.println(Engine.sendSadMessage(Integer.parseInt(playerAnswer), correctAnswer));
                break;
            }
            if (victoryCount == numberOfRounds) {
                System.out.println(Engine.congratulate());
                break;
            }
        }
    }

    public static String generateProgString(int[] numbers, int indexToHide) {

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
}
