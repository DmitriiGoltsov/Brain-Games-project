package hexlet.code.games;

import java.util.Scanner;
import java.util.StringJoiner;

import static hexlet.code.Engine.playerName;

public class Progression {
    public static void startProgressionGame() {
        System.out.println("What number is missing in the progression?");

        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);

        // Initialize a cycle that counts player's victories and initialize progressions.
        for (var i3 = 0; i3 <= 3; i3++) {

            /* Create two arrays that will be used in the game.
            Their length is defined by the length of the progression which is defined by the TOR of the game
            */
            int[] numbers = new int[10];
            String[] numbersAsStrings = new String[10];

            // The variable bellow is to define the common difference of our progression. It can't be zero.
            var commonDifference = (int) (1 + Math.random() * 10);
            numbers[0] = commonDifference; // Manually define 0-index of our int array.
            numbersAsStrings[0] = Integer.toString(commonDifference); // The same to string array.

            /* This cycle fills two different arrays of progressions:
            one with numbers and one with the same numbers but represented as strings.*/
            for (var i = 1; i < numbers.length; i++) {
                numbers[i] = numbers[i - 1] + commonDifference;
                numbersAsStrings[i] = Integer.toString(numbers[i]);
            }
            // Randomly choose an index of the array that will be covered.
            var indexToHide = (int) (0 + Math.random() * numbers.length);

            /* Begin to create a string that will be shown to player, including the covered index. */
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
