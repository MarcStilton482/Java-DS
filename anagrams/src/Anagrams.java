import java.util.Scanner;

public class Anagrams {
    public static boolean isAnagram(String first, String second) {
        char[] charOfFirst = first.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] charOfSecond = second.replaceAll("\\s", "").toLowerCase().toCharArray();

        if (charOfFirst.length != charOfSecond.length)
            return false;

        int[] frequencies = new int[26];
        for (int i = 0; i < charOfFirst.length; i++) {
            frequencies[charOfFirst[i] - 'a']++;
            frequencies[charOfSecond[i] - 'a']--;
        }

        for (int frequency : frequencies) {
            if (frequency != 0)
                return false;
        }

        return true;
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
