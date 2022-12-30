package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static void startPrimeGame() {
        String description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        final var numberOfRounds = 3;
        String[] data = new String[numberOfRounds];
        String[] correctAnswers = new String[numberOfRounds];

        for (var i = 0; i < numberOfRounds; i++) {
            int number = generateRandomNumber();
            data[i] = Integer.toString(number);
            if (isPrime(number)) {
                correctAnswers[i] = "yes";
            } else {
                correctAnswers[i] = "no";
            }
        }
        Engine.run(description, data, correctAnswers);
    }
    public static int generateRandomNumber() {
        final int lowRange = 2;
        final int highRange = 100;
        return Utils.generateRandomNumber(lowRange, highRange);
    }
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
}
