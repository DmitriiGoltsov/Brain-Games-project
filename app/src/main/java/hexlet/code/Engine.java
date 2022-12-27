package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String playerName;
    public static String getPlayerName() {
        return playerName;
    }
    public static void askName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""

                Welcome to the Brain Games!
                May I have your name?""");
        playerName = scanner.next();
        System.out.println("\nHello, " + playerName + "!");
    }
    public static String congratulate() {
        return "Congratulations, " + getPlayerName() + "!";
    }
    public static String sendSadMessage(String wrongAnswer) {
        return switch (wrongAnswer) {
            case "yes" -> "Your answer: " + wrongAnswer + "\n" + wrongAnswer
                    + " is wrong answer ;(. Correct answer was no"
                    + "\nLet's try again, " + getPlayerName() + "!";
            case "no" -> "Your answer: " + wrongAnswer + "\n" + wrongAnswer
                    + " is wrong answer ;(. Correct answer was yes"
                    + "\nLet's try again, " + getPlayerName() + "!";
            default -> "Wrong input";
        };
    }
    public static String sendSadMessage(int wrongAnswer, int correctAnswer) {
        return "Your answer: " + wrongAnswer + "\n" + wrongAnswer
                    + " is wrong answer ;(. Correct answer was " + correctAnswer
                    + "\nLet's try again, " + getPlayerName() + "!";
    }
}
