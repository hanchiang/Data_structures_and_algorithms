import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int tempI = 0;
        // index for left and right sub array
        int left = low, right = mid + 1;

        // Merge left and right sub arrays into temp array
        while(left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[tempI] = arr[left];
                left++;
            } else {
                temp[tempI] = arr[right];
                right++;
            }
            tempI++;
        }

        // There are still items in left subarray
        while(left <= mid) {
            temp[tempI] = arr[left];
            left++;
            tempI++;
        }

        // There are still items in right subarray
        while(right <= high) {
            temp[tempI] = arr[right];
            right++;
            tempI++;
        }


        for (int j = 0; j < tempI; j++) {
            arr[j + low] = temp[j];
        }

    }

    public static void mergesort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] numbers = ArrayGenerator.generateRandomNumbers(7);

        System.out.println("Unsorted: " + Arrays.toString(numbers));
        mergesort(numbers, 0, numbers.length-1);
        System.out.println("Sorted: " + Arrays.toString(numbers));
    }
}
