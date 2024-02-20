import java.util.Scanner;

public class Sub {

    public static String get(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int length = dp[str1.length()][str2.length()];
        if (length == 0) {
            return "No common elements found.";
        }

        StringBuilder commonSubsequence = new StringBuilder();
        int i = str1.length(), j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                commonSubsequence.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
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

        String result = get(s1, s2);
        System.out.println(result);
    }
}
