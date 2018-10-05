import java.util.Arrays;
import java.util.Random;

// Runtime: O(n)

public class MaxsubarrayLinear {
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

    public static Result maxSubarrayLinear(int[] numbers) {
        int maxSum = numbers[0];
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int left = 0;   // tracks the left index of every new subarray segment

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if (sum > maxSum) {
                maxSum = sum;
                maxLeft = left;
                maxRight = i;
            } else if (sum < 0) {
                // If sum is negative, discard everything(except maxSum) that has been calculated up to i, and start from i +1
                sum = 0;
                left = i + 1;
            }
        }

        return new Result(maxLeft, maxRight, maxSum);
    }

    public static void main(String[] args) {
        int[] numbers = generateNumbers(10);

        System.out.println("Array: " + Arrays.toString(numbers));
        Result result = maxSubarrayLinear(numbers);
        System.out.println("max left: " + result.maxLeftIndex + ", max right: " + result.maxRightIndex + ", sum: " + result.sum);
    }
}
