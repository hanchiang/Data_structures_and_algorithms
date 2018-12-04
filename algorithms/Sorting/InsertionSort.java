import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] num) {
        for (int j = 1; j < num.length; j++) {
            int numToInsert = num[j];
            int i = j - 1;

            while(i >= 0 && num[i] > numToInsert) {
                num[i+1] = num[i];
                i--;
            }
            num[i+1] = numToInsert;
        }
    }

    public static void main(String[] args) {
        int[] numbers = ArrayGenerator.generateRandomNumbers(15);
         System.out.println("Unsorted: " + Arrays.toString(numbers));
         insertionSort(numbers);
         System.out.println("Sorted: " + Arrays.toString(numbers));
    }
}
