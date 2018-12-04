import java.util.ArrayList;
import java.util.Scanner;

public class BitsGenerator {
    public static ArrayList<String> generateBits(int n) {
        if (n == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            res.add("1");
            return res;
        } else {
            ArrayList<String> result = new ArrayList<>();

            ArrayList<String> generated = generateBits(n - 1);
            for (int i = 0; i < generated.size(); i++) {
                result.add(generated.get(i) + 0);
                result.add(generated.get(i) + 1);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numBits;

        System.out.print("Enter the length of bits to generate all possible bits: ");
        numBits = sc.nextInt();

        ArrayList<String> result = generateBits(numBits);
        System.out.println("Number of bits generated: " + result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
