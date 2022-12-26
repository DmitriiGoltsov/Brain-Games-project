package hexlet.code;

public class Utils {
    public static int generateRanNum(int lowRange, int highRange) {
        return (int) (lowRange + Math.random() * highRange);
    }
    public static int generateRanNum(int highRange) {
        return (int) (Math.random() * highRange);
    }
}
