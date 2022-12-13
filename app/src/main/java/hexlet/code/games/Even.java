package hexlet.code.games;

import java.util.Scanner;
import static hexlet.code.Engine.playerName;

public class Even {
    public static void startEvenGame() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var victoryCount = 0;
        Scanner scanner = new Scanner(System.in);
        for (var i = 0; i <= 4; i++) {
            int number = (int) (0 + Math.random() * 1000);
            System.out.println(number);
            var playerAnswer = scanner.next();
            if (number % 2 == 0 && playerAnswer.equals("yes")) {
                System.out.println("Correct!");
                i++;
                victoryCount += 1;
                if (victoryCount == 3) {
                    System.out.println("Congratulations, " + playerName + "!");
                    break;
                }
            } else if (number % 2 != 0 && playerAnswer.equals("no")) {
                System.out.println("Correct!");
                i++;
                victoryCount += 1;
                if (victoryCount == 3) {
                    System.out.println("Congratulations, " + playerName + "!");
                    break;
                }
            } else if (number % 2 == 0 && playerAnswer.equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                break;
            } else if (number % 2 != 0 && playerAnswer.equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                break;
            } else {
                System.out.println("Wrong input");
                break;
            }
        }
    }
}