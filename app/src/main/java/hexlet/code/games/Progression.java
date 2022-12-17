package hexlet.code.games;

import java.util.Scanner;
import java.util.StringJoiner;

import static hexlet.code.Engine.playerName;

public class Progression {
    public static void startProgressionGame() {
        System.out.println("What number is missing in the progression?");
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);

        for (var i3 = 0; i3 <= 4; i3++) {
            int[] numbers = new int[10];
            String[] numbersAsStrings = new String[10];
            var commonDifference = (int) (1 + Math.random() * 10);
            numbers[0] = commonDifference;
            numbersAsStrings[0] = Integer.toString(commonDifference);
            for (var i = 1; i < numbers.length; i++) {
                numbers[i] = numbers[i - 1] + commonDifference;
                numbersAsStrings[i] = Integer.toString(numbers[i]);
            }
            var indexToHide = (int) (0 + Math.random() * numbers.length);
            var result = new StringJoiner(" ");
            result.add("Question: ");
            for (var i2 = 0; i2 < numbers.length; i2++) {
                if (i2 == indexToHide) {
                    result.add("..");
                } else {
                    result.add(numbersAsStrings[i2]);
                }
            }
            System.out.println(result);
            var playerAnswer = scanner.next();

            if (numbers[indexToHide] == Integer.parseInt(playerAnswer)) {
                System.out.println("Your answer is: " + playerAnswer + "\nCorrect!");
                victoryCount += 1;
            }
            if (numbers[indexToHide] != Integer.parseInt(playerAnswer)) {
                System.out.println(playerAnswer + " is wrong answer ;(. Correct answer was " + numbers[indexToHide]
                        + "\nLet's try again, " + playerName);
                break;
            }
            if (victoryCount == 3) {
                System.out.println("Congratulations, " + playerName + "!");
                break;
            }
        }
    }
}
