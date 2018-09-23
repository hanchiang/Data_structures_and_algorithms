import java.util.Random;

public class ArrayGenerator {
    public static int[] generateNumbers(int size) {
        int[] numbers = new int[size];
        Random rand = new Random();
        int randomInt;

        for (int i = 0; i < size; i++) {
            randomInt = rand.nextInt(100);
            numbers[i] =  rand.nextFloat() >= 0.5 ? randomInt : -1 * randomInt;
        }
        return numbers;
    }
}
