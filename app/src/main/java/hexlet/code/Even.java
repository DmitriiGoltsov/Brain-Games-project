package hexlet.code;

import java.util.Scanner;
import java.util.Random;
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
        /*Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        for (var i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (0 + Math.random() * 1000);
        }
        var i = 0;
        System.out.println(numbers[i]);
        while (i < 3) {
            var playerAnswer = scanner.next();
            if (numbers[i] % 2 == 0 && playerAnswer.equals("yes")) {
                System.out.println("Correct!");
                i++;
            } else if (numbers[i] % 2 != 0 && playerAnswer.equals("no")) {
                System.out.println("Correct!");
                i++;
            } else if (numbers[i] % 2 == 0 && playerAnswer.equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                break;
            } else if (numbers[i] % 2 != 0 && playerAnswer.equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                break;
            } else {
                System.out.println("Wrong input");
            }
            System.out.println("Congratulations, " + playerName); */
        Scanner scanner = new Scanner(System.in);
        int victoryCount = 0;
        for (var i = 0; i <= 4; i++) {
            victoryCount = 0;
            int number = (int) (0 + Math.random() * 1000);
            System.out.println(number);
            var playerAnswer = scanner.next();
            if (victoryCount == 3) {
                System.out.println("Congratulation");
            }
            if (number % 2 == 0 && playerAnswer.equals("yes")) {
                System.out.println("Correct!");
                i++;
                victoryCount += 1;
            } else if (number % 2 != 0 && playerAnswer.equals("no")) {
                System.out.println("Correct!");
                i++;
                victoryCount += 1;
            } else if (number % 2 == 0 && playerAnswer.equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                break;
            } else if (number % 2 != 0 && playerAnswer.equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}