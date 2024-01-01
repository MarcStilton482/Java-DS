import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        int rev = 0;
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int temp = num;

        while (num > 0) {
            t = num % 10;
            rev = (rev * 10) + t;
            num /= 10; // Fix: Divide by 10, not by num
        }

        if (temp == rev) {
            System.out.println("Entered number is a palindrome");
        } else {
            System.out.println("Entered number is not a palindrome");
        }
    }
}
