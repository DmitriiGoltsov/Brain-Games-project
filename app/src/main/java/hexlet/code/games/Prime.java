package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Scanner;

public class Prime {
    public static boolean isPrime(int number) {
        final int numberOfPrimeDivisors = 2;
        var count = 0;
        for (var i = 1; i <= number; i++) {
            var tempCheck = number % i;
            if (tempCheck == 0) {
                count++;
                if (count > numberOfPrimeDivisors) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void startPrimeGame() {
        Engine.askName();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        final var numberOfRounds = 3;
        final int lowRange = 2;
        final int highRange = 100;
        var victoryCount = 0;

        Scanner scanner = new Scanner(System.in);
        for (var i = 0; i <= numberOfRounds; i++) {
            int number = Utils.generateRanNum(lowRange, highRange);

            System.out.println("Question: " + number);
            var playerAnswer = scanner.next().toLowerCase();

            if ((isPrime(number) && playerAnswer.equals("yes")) || (!isPrime(number) && playerAnswer.equals("no"))) {
                victoryCount += 1;
                System.out.println("Your answer: " + playerAnswer + "\nCorrect!");
            } else {
                System.out.println(Engine.sendSadMessage(playerAnswer));
                break;
            }
            if (victoryCount == numberOfRounds) {
                System.out.println(Engine.congratulate());
                break;
            }
        }
    }
}
