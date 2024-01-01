import java.util.Scanner;
public class Even_Odd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int k = sc.nextInt();
        if(k%2 == 0)
        {
            System.out.println("Number entered is even.");
        }
        else
        {
            System.out.println("Number entered is odd.");
        }         
    }
}