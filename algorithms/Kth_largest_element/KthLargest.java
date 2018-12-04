import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class KthLargest {
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

    // largest[0] holds the largest number, largest[1] holds the 2nd largest number, and so on
    // e.g. [50, 40, 30]
    public static int klargest(int[] num, int k) {
        int[] largest = new int[k];

        largest[0] = num[0];
        for (int largestIdx = 1; largestIdx < k; largestIdx++) {
            largest[largestIdx] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < num.length; i++) {
            // System.out.println("i : " + i);
            // loop through largest[] to check whether num[i] is greater than any of largest[largestlargestIdx]
            for (int largestlargestIdx = 0; largestlargestIdx < k; largestlargestIdx++) {
                // If it is, shift the elements of largest[] rightwards, from index k-1 down to largestlargestIdx and
                // break away from loop
                if (num[i] > largest[largestlargestIdx]) {
                    int shift;
                    for (shift = k - 1; shift > largestlargestIdx; shift--) {
                        largest[shift] = largest[shift - 1];
                    }
                    largest[shift] = num[i];
                    // System.out.println("largest: " + Arrays.toString(largest));
                    break;
                }
            }
        }
        return largest[k-1];
    }

    public static void main(String[] args) {
        int k;
        int[] numbers = generateNumbers(4);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter k value: ");
        k = scanner.nextInt();
        int result = klargest(numbers, k);

        System.out.println("array: " + Arrays.toString(numbers));
        System.out.println("Result: " + result);
    }
}
