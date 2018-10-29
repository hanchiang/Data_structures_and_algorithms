import java.util.ArrayList;
import java.util.Scanner;

/*
    function with 2 params: Current permutation so far, and remaining string to permutate
    Idea: Loop through the string, add the ith character to prefix string, and permutate string without the ith character
    e.g. input = "wes"
    permutate("", "wes")
        permutate("w", "es")
            permutate("we", "s")
                permutate("wes", "")
            permutate("ws", "e")
                permutate("wse", "")
        permutate("e", "ws")
            permutate("ew", "s")
                permutate("ews", "")
            permutate("es", "w")
                permutate("esw", "")
        permutate("s", "we")
            permutate("sw", "e")
                permutate("swe", "")
            permutate("se", "w")
                permutate("sew", "")
 */

public class StringPermutations2 {
    public static ArrayList<String> permutate(String remaining) {
        if (remaining.length() == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(remaining);
            return res;
        } else {
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < remaining.length(); i++) {
                ArrayList<String> permutations = permutate(remaining.substring(0, i) + remaining.substring(i + 1));

                for (int j = 0; j < permutations.size(); j++) {
                    result.add(remaining.charAt(i) + permutations.get(j));
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {
        String input = "";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to permutate: ");
        input = sc.nextLine();

        ArrayList<String> result = permutate(input);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
