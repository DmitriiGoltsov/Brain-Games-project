package hexlet.code;

import java.util.Scanner;

public class Even {
    public static String isEven() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        isEvenGame();
        return playerName;
        }
    public static void isEvenGame() {
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
                    System.out.println("Congratulations! ");
                    break;
                }
            } else if (number % 2 != 0 && playerAnswer.equals("no")) {
                System.out.println("Correct!");
                i++;
                victoryCount += 1;
                    if (victoryCount == 3) {
                        System.out.println("Congratulations! " + isEven());
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