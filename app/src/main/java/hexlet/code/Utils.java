package hexlet.code;

public class Utils {

    // Create a random number in given range (from lowRange to highRange).
    public static int generateRandomNumber(int lowRange, int highRange) {
        return (int) (lowRange + Math.random() * highRange);
    }

    // Create a random number in given range (to highRange, there is no lowRange).
    public static int generateRandomNumber(int highRange) {
        return (int) (Math.random() * highRange);
    }
}
