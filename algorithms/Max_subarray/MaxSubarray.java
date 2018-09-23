import java.util.Arrays;
import java.util.Random;

// Runtime: n lg n
// To return the left index, right index, and the sum


public class MaxSubarray {
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

    // Max subarray that crosses the midpoint has indices i, j, such that low <= i <= mid < j <= high
    public static Result maxCrossSubarray(int[] arr, int low, int mid, int high) {
        int maxLeftSum = arr[mid];
        int maxLeftIndex = mid;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > maxLeftSum) {
                maxLeftSum = sum;
                maxLeftIndex = i;
            }
        }

        int maxRightSum = arr[mid+1];
        int maxRightIndex = mid + 1;
        sum = 0;

        for (int j = mid + 1; j <= high; j++) {
            sum += arr[j];
            if (sum > maxRightSum) {
                maxRightSum = sum;
                maxRightIndex = j;
            }
        }
        return new Result(maxLeftIndex, maxRightIndex, maxLeftSum + maxRightSum);
    }

    public static Result maxSubarray(int[] arr, int low, int high) {
        if (low == high) {
            return new Result(low, high, arr[low]);
        } else {
            int mid = (low + high) / 2;
            Result leftSum = maxSubarray(arr, low, mid);
            Result rightSum = maxSubarray(arr, mid + 1, high);
            Result crossSum = maxCrossSubarray(arr, low, mid, high);


            if (leftSum.sum >= rightSum.sum && leftSum.sum >= crossSum.sum) {
                return leftSum;
            } else if (rightSum.sum >= leftSum.sum && rightSum.sum >= crossSum.sum) {
                return rightSum;
            } else {
                return crossSum;
            }
        }
    }


    public static void main(String[] args) {
        int[] numbers = generateNumbers(7);

        System.out.println("Array: " + Arrays.toString(numbers));

        Result result = maxSubarray(numbers, 0, numbers.length - 1);

        System.out.println("max left: " + result.maxLeftIndex + ", max right: " + result.maxRightIndex +
                ", sum: " + result.sum);
    }
}
