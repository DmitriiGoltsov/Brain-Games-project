package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void run(String description, String[] data, String[] correctAnswers) {
        Utils.askName();
        System.out.println(description);
        int victoryCount = 0;
        for (var i = 0; i < data.length; i++) {
            System.out.println("Question: " + Integer.parseInt(data[i]));
            Scanner scanner = new Scanner(System.in);
            String playerAnswer = scanner.next().toLowerCase();
            if (playerAnswer.equals(correctAnswers[i])) {
                System.out.println("Correct!");
                victoryCount += 1;
                if (victoryCount == data.length) {
                    System.out.println(Utils.congratulate());
                }
            } else {
                System.out.println(Utils.sendSadMessage(playerAnswer));
                break;
            }
        }
    }
    public static void run(String description, String[] data, int[] correctAnswers) {
        Utils.askName();
        System.out.println(description);
        int victoryCount = 0;
        for (var i = 0; i < data.length; i++) {
            System.out.println("Question: " + data[i]);
            Scanner scanner = new Scanner(System.in);
            String playerAnswer = scanner.next();
            if (Integer.parseInt(playerAnswer) == correctAnswers[i]) {
                System.out.println("Correct!");
                victoryCount += 1;
                if (victoryCount == data.length) {
                    System.out.println(Utils.congratulate());
                }
            } else {
                System.out.println(Utils.sendSadMessage(Integer.parseInt(playerAnswer), correctAnswers[i]));
                break;
            }
        }
    }
}
