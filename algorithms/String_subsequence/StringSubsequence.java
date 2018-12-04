import java.util.ArrayList;
import java.util.Scanner;

public class StringSubsequence {
    public static ArrayList<String> subsequences(String input) {
        if (input.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        } else {
            ArrayList<String> result = new ArrayList<>();
            ArrayList<String> subs = subsequences(input.substring(1));

            for (int i = 0; i < subs.size(); i++) {
                result.add(subs.get(i));
                result.add(input.charAt(0) + subs.get(i));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        System.out.print("Enter a string to get the subsequences: ");
        input = sc.nextLine();

        ArrayList<String> result = subsequences(input);
        System.out.println("Number of results: " + result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
