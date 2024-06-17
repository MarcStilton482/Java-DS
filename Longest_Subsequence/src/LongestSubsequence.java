import java.util.Scanner;

public class LongestSubsequence {

    public static String get(String string1, String string2) {
        if (string1 == null || string2 == null) {
            throw new NullPointerException("String is Empty");
        }
        int[][] dynamicProgramming = new int[string1.length() + 1][string2.length() + 1];

        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dynamicProgramming[i][j] = dynamicProgramming[i - 1][j - 1] + 1;
                } else {
                    dynamicProgramming[i][j] = Math.max(dynamicProgramming[i - 1][j], dynamicProgramming[i][j - 1]);
                }
            }
        }
        int length = dynamicProgramming[string1.length()][string2.length()];
        if (length == 0) {
            return "No common elements found.";
        }
        StringBuilder commonSubsequence = new StringBuilder();
        int i = string1.length(), j = string2.length();
        while (i > 0 && j > 0) {
            if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                commonSubsequence.insert(0, string1.charAt(i - 1));
                i--;
                j--;
            } else if (dynamicProgramming[i - 1][j] > dynamicProgramming[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return commonSubsequence.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String1: ");
        String s1 = sc.nextLine();
        System.out.println("Enter String2: ");
        String s2 = sc.nextLine();
        try
        {
            String result = get(s1, s2);
            System.out.println(result);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
//Time Complexity - O(n*m)
// Space Complexity - O(n*m)