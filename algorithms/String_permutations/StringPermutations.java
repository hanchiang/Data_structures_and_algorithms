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

public class StringPermutations {
    public static void permutate(String prefix, String remaining) {
        if (remaining.length() == 1) {
            System.out.println(prefix + remaining);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                permutate(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i+1));
            }
        }
    }

    public static void permutations(String input) {
        permutate("", input);
    }


    public static void main(String[] args) {
        String input = "";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to permutate: ");
        input = sc.nextLine();

        permutations(input);

    }
}
