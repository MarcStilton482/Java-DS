import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
    public static boolean isAnagram(String first, String second) {
        first = first.toLowerCase();
        second = second.toLowerCase();
        if (first.length() != second.length())
            return false;
        int[] frequencies = new int[256];
        for (int i = 0; i < first.length(); i++) {
            frequencies[first.charAt(i)]++;
            frequencies[second.charAt(i)]--;
        }
        return Arrays.stream(frequencies).allMatch(frequency -> frequency == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First String: ");
        String first = sc.nextLine();
        System.out.println("Enter Second String: ");
        String second = sc.nextLine();
        boolean anagram = isAnagram(first, second);
        System.out.println("The given strings are anagrams: " + anagram);
    }
}
//Time Complexity : O(n), Space Complexity: O(1)